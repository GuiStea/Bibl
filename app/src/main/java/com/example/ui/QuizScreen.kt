package com.example.ui

import androidx.activity.compose.BackHandler
import androidx.compose.animation.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.data.QuizRepository
import com.example.model.QuizCategory
import com.example.model.QuizDifficulty
import com.example.ui.theme.*
import com.example.viewmodel.MainViewModel

@Composable
fun QuizScreen(viewModel: MainViewModel) {
  val isQuizActive by viewModel.isQuizActive.collectAsState()
  val quizState by viewModel.quizState.collectAsState()

  var selectedDifficulty by remember { mutableStateOf(QuizDifficulty.TODAS) }
  var selectedCategory by remember { mutableStateOf(QuizCategory.TODAS) }
  var showExitDialog by remember { mutableStateOf(false) }

  if (showExitDialog) {
    AlertDialog(
      onDismissRequest = { showExitDialog = false },
      title = { Text("Sair do Quiz?") },
      text = { Text("Se você sair agora, o progresso desta rodada de 10 perguntas será cancelado.") },
      confirmButton = {
        TextButton(
          onClick = {
            showExitDialog = false
            viewModel.exitQuiz()
          }
        ) {
          Text("Sair")
        }
      },
      dismissButton = {
        TextButton(onClick = { showExitDialog = false }) {
          Text("Continuar")
        }
      }
    )
  }

  if (isQuizActive) {
    BackHandler {
      if (!quizState.isFinished) {
        showExitDialog = true
      } else {
        viewModel.exitQuiz()
      }
    }

    if (!quizState.isFinished) {
      QuizPlayView(
        state = quizState,
        onSelectAnswer = { viewModel.selectAnswer(it) },
        onNextQuestion = { viewModel.nextQuestion() },
        onExitRequest = { showExitDialog = true }
      )
    } else {
      QuizResultView(
        state = quizState,
        onPlayAgain = { viewModel.startNewQuiz(quizState.selectedDifficulty, quizState.selectedCategory) },
        onChangeDifficulty = { viewModel.exitQuiz() }
      )
    }
  } else {
    QuizSetupView(
      selectedDifficulty = selectedDifficulty,
      onDifficultySelected = { selectedDifficulty = it },
      selectedCategory = selectedCategory,
      onCategorySelected = { selectedCategory = it },
      onStartQuiz = {
        viewModel.startNewQuiz(selectedDifficulty, selectedCategory)
      },
      viewModel = viewModel
    )
  }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun QuizSetupView(
  selectedDifficulty: QuizDifficulty,
  onDifficultySelected: (QuizDifficulty) -> Unit,
  selectedCategory: QuizCategory,
  onCategorySelected: (QuizCategory) -> Unit,
  onStartQuiz: () -> Unit,
  viewModel: MainViewModel
) {
  LazyColumn(
    modifier = Modifier
      .fillMaxSize()
      .testTag("quiz_setup_screen"),
    contentPadding = PaddingValues(bottom = 100.dp)
  ) {
    // Banner
    item {
      Box(
        modifier = Modifier
          .fillMaxWidth()
          .height(190.dp)
      ) {
        Image(
          painter = painterResource(id = R.drawable.banner_quiz),
          contentDescription = "Banner Quiz Bíblico",
          contentScale = ContentScale.Crop,
          modifier = Modifier.fillMaxSize()
        )
        Box(
          modifier = Modifier
            .fillMaxSize()
            .background(
              Brush.verticalGradient(
                listOf(
                  Color.Black.copy(alpha = 0.3f),
                  BibleNavyPrimary.copy(alpha = 0.9f)
                )
              )
            )
        )
        Column(
          modifier = Modifier
            .fillMaxSize()
            .padding(18.dp),
          verticalArrangement = Arrangement.Bottom
        ) {
          Surface(
            color = BibleGold.copy(alpha = 0.3f),
            shape = RoundedCornerShape(12.dp)
          ) {
            Text(
              text = "Banco de 200 Perguntas Bíblicas",
              style = MaterialTheme.typography.labelSmall,
              color = BibleGoldLight,
              modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
            )
          }
          Spacer(modifier = Modifier.height(4.dp))
          Text(
            text = "Quiz Sobre a Bíblia",
            style = MaterialTheme.typography.headlineLarge,
            color = Color.White
          )
          Text(
            text = "Cada rodada seleciona 10 perguntas sorteadas com referências e explicações.",
            style = MaterialTheme.typography.bodySmall,
            color = Color.White.copy(alpha = 0.9f)
          )
        }
      }
    }

    // Difficulty Section
    item {
      Column(modifier = Modifier.padding(16.dp)) {
        Text(
          text = "1. Nível de Dificuldade",
          style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
        )
        Text(
          text = "Personalize o desafio do seu teste bíblico:",
          style = MaterialTheme.typography.bodySmall,
          color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.height(10.dp))

        QuizDifficulty.entries.forEach { diff ->
          val isSelected = selectedDifficulty == diff
          Card(
            modifier = Modifier
              .fillMaxWidth()
              .padding(vertical = 4.dp)
              .testTag("difficulty_${diff.name}")
              .clickable { onDifficultySelected(diff) },
            shape = RoundedCornerShape(14.dp),
            colors = CardDefaults.cardColors(
              containerColor = if (isSelected) {
                MaterialTheme.colorScheme.primaryContainer
              } else {
                MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
              }
            ),
            border = if (isSelected) {
              androidx.compose.foundation.BorderStroke(2.dp, MaterialTheme.colorScheme.primary)
            } else null
          ) {
            Row(
              modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
              verticalAlignment = Alignment.CenterVertically
            ) {
              RadioButton(
                selected = isSelected,
                onClick = { onDifficultySelected(diff) }
              )
              Spacer(modifier = Modifier.width(8.dp))
              Column(modifier = Modifier.weight(1f)) {
                Text(
                  text = diff.label,
                  style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                  color = if (isSelected) MaterialTheme.colorScheme.onPrimaryContainer else MaterialTheme.colorScheme.onSurface
                )
                Text(
                  text = diff.description,
                  style = MaterialTheme.typography.bodySmall,
                  color = MaterialTheme.colorScheme.onSurfaceVariant
                )
              }
              Surface(
                color = MaterialTheme.colorScheme.primary.copy(alpha = 0.12f),
                shape = RoundedCornerShape(8.dp)
              ) {
                Text(
                  text = "${QuizRepository.countByDifficulty(diff)} disp.",
                  style = MaterialTheme.typography.labelSmall,
                  color = MaterialTheme.colorScheme.primary,
                  modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                )
              }
            }
          }
        }
      }
    }

    // Category Section
    item {
      Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Text(
          text = "2. Categoria Temática",
          style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
        )
        Text(
          text = "Escolha um tema ou jogue com todas misturadas:",
          style = MaterialTheme.typography.bodySmall,
          color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.height(8.dp))

        FlowRow(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.spacedBy(8.dp),
          verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
          QuizCategory.entries.forEach { cat ->
            val isSelected = selectedCategory == cat
            FilterChip(
              selected = isSelected,
              onClick = { onCategorySelected(cat) },
              label = { Text(cat.label, style = MaterialTheme.typography.labelMedium) },
              leadingIcon = if (isSelected) {
                { Icon(Icons.Default.Check, contentDescription = null, modifier = Modifier.size(16.dp)) }
              } else null,
              modifier = Modifier.testTag("category_${cat.name}")
            )
          }
        }
      }
    }

    // Start Button
    item {
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
      ) {
        Button(
          onClick = onStartQuiz,
          modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .testTag("start_quiz_button"),
          shape = RoundedCornerShape(16.dp),
          colors = ButtonDefaults.buttonColors(
            containerColor = BibleNavyPrimary
          )
        ) {
          Icon(Icons.Default.PlayArrow, contentDescription = null, tint = BibleGold)
          Spacer(modifier = Modifier.width(8.dp))
          Text(
            text = "Iniciar Quiz (10 Perguntas)",
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
            color = Color.White
          )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
          text = "✨ 10 perguntas serão sorteadas aleatoriamente do banco de 200.",
          style = MaterialTheme.typography.bodySmall,
          color = MaterialTheme.colorScheme.onSurfaceVariant,
          textAlign = TextAlign.Center
        )
      }
    }

    // Stats Card
    item {
      Card(
        modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = 16.dp, vertical = 8.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
          containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
        )
      ) {
        Row(
          modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
          horizontalArrangement = Arrangement.SpaceAround
        ) {
          Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Quizzes Jogados", style = MaterialTheme.typography.labelSmall)
            Text(
              text = viewModel.prefs.totalQuizzesPlayed.toString(),
              style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
              color = MaterialTheme.colorScheme.primary
            )
          }
          Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Recorde", style = MaterialTheme.typography.labelSmall)
            Text(
              text = "${viewModel.prefs.bestScore}/10",
              style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
              color = BibleGold
            )
          }
          Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Total Acertos", style = MaterialTheme.typography.labelSmall)
            Text(
              text = viewModel.prefs.totalCorrectAnswers.toString(),
              style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
              color = SuccessGreen
            )
          }
        }
      }
    }
  }
}

@Composable
private fun QuizPlayView(
  state: com.example.model.QuizSessionState,
  onSelectAnswer: (Int) -> Unit,
  onNextQuestion: () -> Unit,
  onExitRequest: () -> Unit
) {
  val question = state.currentQuestion ?: return

  LazyColumn(
    modifier = Modifier
      .fillMaxSize()
      .padding(horizontal = 16.dp)
      .testTag("quiz_play_screen"),
    contentPadding = PaddingValues(top = 16.dp, bottom = 100.dp)
  ) {
    // Top Progress & Back Bar
    item {
      Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
      ) {
        IconButton(
          onClick = onExitRequest,
          modifier = Modifier.testTag("exit_quiz_button")
        ) {
          Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Sair do Quiz")
        }

        Surface(
          shape = RoundedCornerShape(12.dp),
          color = MaterialTheme.colorScheme.primaryContainer
        ) {
          Text(
            text = "Pergunta ${state.currentIndex + 1} de ${state.questions.size}",
            style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Bold),
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
          )
        }

        if (state.currentStreak > 1) {
          Surface(
            shape = RoundedCornerShape(12.dp),
            color = Color(0xFFFFE0B2)
          ) {
            Text(
              text = "🔥 ${state.currentStreak} seguidos",
              style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
              color = Color(0xFFE65100),
              modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
            )
          }
        } else {
          Spacer(modifier = Modifier.width(48.dp))
        }
      }

      Spacer(modifier = Modifier.height(8.dp))

      LinearProgressIndicator(
        progress = { state.progress },
        modifier = Modifier
          .fillMaxWidth()
          .height(8.dp)
          .clip(RoundedCornerShape(4.dp)),
        color = BibleGold,
        trackColor = MaterialTheme.colorScheme.surfaceVariant
      )

      Spacer(modifier = Modifier.height(14.dp))
    }

    // Question Badges
    item {
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
      ) {
        Surface(
          color = MaterialTheme.colorScheme.surfaceVariant,
          shape = RoundedCornerShape(8.dp)
        ) {
          Text(
            text = question.difficulty.label,
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
          )
        }
        Surface(
          color = MaterialTheme.colorScheme.surfaceVariant,
          shape = RoundedCornerShape(8.dp)
        ) {
          Text(
            text = question.category.label,
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
          )
        }
      }

      Spacer(modifier = Modifier.height(12.dp))

      // Question Text Card
      Card(
        modifier = Modifier
          .fillMaxWidth()
          .testTag("question_card"),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
          containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
      ) {
        Text(
          text = question.question,
          style = MaterialTheme.typography.titleMedium.copy(
            fontSize = 19.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 26.sp
          ),
          modifier = Modifier.padding(20.dp)
        )
      }

      Spacer(modifier = Modifier.height(16.dp))
    }

    // 4 Options
    itemsIndexed(question.options) { index, optionText ->
      val isSelected = state.selectedAnswerIndex == index
      val isSubmitted = state.isAnswerSubmitted
      val isCorrectAnswer = (index == question.correctOptionIndex)

      val backgroundColor = when {
        !isSubmitted -> MaterialTheme.colorScheme.surface
        isCorrectAnswer -> SuccessGreenLight
        isSelected && !isCorrectAnswer -> ErrorRedLight
        else -> MaterialTheme.colorScheme.surface.copy(alpha = 0.6f)
      }

      val borderColor = when {
        !isSubmitted && isSelected -> MaterialTheme.colorScheme.primary
        isSubmitted && isCorrectAnswer -> SuccessGreen
        isSubmitted && isSelected && !isCorrectAnswer -> ErrorRed
        else -> MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f)
      }

      Card(
        modifier = Modifier
          .fillMaxWidth()
          .padding(vertical = 5.dp)
          .testTag("option_$index")
          .clickable(enabled = !isSubmitted) { onSelectAnswer(index) },
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = backgroundColor),
        border = androidx.compose.foundation.BorderStroke(1.5.dp, borderColor)
      ) {
        Row(
          modifier = Modifier
            .fillMaxWidth()
            .padding(14.dp),
          verticalAlignment = Alignment.CenterVertically
        ) {
          Box(
            modifier = Modifier
              .size(36.dp)
              .clip(CircleShape)
              .background(
                when {
                  isSubmitted && isCorrectAnswer -> SuccessGreen
                  isSubmitted && isSelected && !isCorrectAnswer -> ErrorRed
                  else -> MaterialTheme.colorScheme.primary.copy(alpha = 0.1f)
                }
              ),
            contentAlignment = Alignment.Center
          ) {
            if (isSubmitted && isCorrectAnswer) {
              Icon(Icons.Default.Check, contentDescription = null, tint = Color.White, modifier = Modifier.size(20.dp))
            } else if (isSubmitted && isSelected && !isCorrectAnswer) {
              Icon(Icons.Default.Close, contentDescription = null, tint = Color.White, modifier = Modifier.size(20.dp))
            } else {
              Text(
                text = ('A' + index).toString(),
                style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                color = MaterialTheme.colorScheme.primary
              )
            }
          }

          Spacer(modifier = Modifier.width(12.dp))

          Text(
            text = optionText,
            style = MaterialTheme.typography.bodyLarge.copy(fontSize = 15.sp),
            modifier = Modifier.weight(1f),
            color = when {
              isSubmitted && isCorrectAnswer -> SuccessGreen
              isSubmitted && isSelected && !isCorrectAnswer -> ErrorRed
              else -> MaterialTheme.colorScheme.onSurface
            }
          )
        }
      }
    }

    // Explanation Card after submission
    if (state.isAnswerSubmitted) {
      item {
        Spacer(modifier = Modifier.height(14.dp))
        Card(
          modifier = Modifier
            .fillMaxWidth()
            .testTag("explanation_card"),
          shape = RoundedCornerShape(16.dp),
          colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.45f)
          )
        ) {
          Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
              Icon(
                imageVector = Icons.Default.MenuBook,
                contentDescription = null,
                tint = BibleNavyPrimary,
                modifier = Modifier.size(20.dp)
              )
              Spacer(modifier = Modifier.width(8.dp))
              Text(
                text = "Referência Bíblica: ${question.biblicalReference}",
                style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Bold),
                color = BibleNavyPrimary
              )
            }
            Spacer(modifier = Modifier.height(6.dp))
            Text(
              text = question.explanation,
              style = MaterialTheme.typography.bodyMedium,
              color = MaterialTheme.colorScheme.onSurface
            )
          }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Next / Finish Button
        Button(
          onClick = onNextQuestion,
          modifier = Modifier
            .fillMaxWidth()
            .height(52.dp)
            .testTag("next_question_button"),
          shape = RoundedCornerShape(14.dp),
          colors = ButtonDefaults.buttonColors(containerColor = BibleNavyPrimary)
        ) {
          val isLast = (state.currentIndex + 1 >= state.questions.size)
          Text(
            text = if (isLast) "Ver Resultado do Quiz" else "Próxima Pergunta",
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
            color = Color.White
          )
          Spacer(modifier = Modifier.width(8.dp))
          Icon(
            imageVector = if (isLast) Icons.Default.EmojiEvents else Icons.Default.ArrowForward,
            contentDescription = null,
            tint = BibleGold
          )
        }
      }
    }
  }
}

@Composable
private fun QuizResultView(
  state: com.example.model.QuizSessionState,
  onPlayAgain: () -> Unit,
  onChangeDifficulty: () -> Unit
) {
  val score = state.correctAnswersCount
  val total = state.questions.size
  val percentage = if (total > 0) (score * 100 / total) else 0

  val pastoralMessage = when {
    score == 10 -> "Perfeito! 'Procura apresentar-te a Deus aprovado, como obreiro que não tem de que se envergonhar' (2 Timóteo 2:15)."
    score >= 8 -> "Excelente! Grande conhecimento das Sagradas Escrituras! O Senhor abençoe sua busca diária pela sabedoria celestial."
    score >= 6 -> "Muito bom! 'Lâmpada para os meus pés é tua palavra e luz, para o meu caminho' (Salmos 119:105). Continue crescendo na graça!"
    else -> "Bom esforço! 'Conheçamos e prossigamos em conhecer ao Senhor' (Oséias 6:3). Faça uma nova rodada e continue aprendendo!"
  }

  LazyColumn(
    modifier = Modifier
      .fillMaxSize()
      .padding(horizontal = 16.dp)
      .testTag("quiz_result_screen"),
    contentPadding = PaddingValues(top = 20.dp, bottom = 100.dp),
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    // Score Trophy
    item {
      Box(
        modifier = Modifier
          .size(90.dp)
          .clip(CircleShape)
          .background(BibleGold.copy(alpha = 0.2f)),
        contentAlignment = Alignment.Center
      ) {
        Icon(
          imageVector = Icons.Default.EmojiEvents,
          contentDescription = null,
          tint = BibleGold,
          modifier = Modifier.size(54.dp)
        )
      }

      Spacer(modifier = Modifier.height(14.dp))

      Text(
        text = "Quiz Concluído!",
        style = MaterialTheme.typography.headlineLarge,
        fontWeight = FontWeight.Bold
      )

      Text(
        text = "Você acertou $score de $total perguntas ($percentage%)",
        style = MaterialTheme.typography.titleMedium,
        color = MaterialTheme.colorScheme.primary
      )

      Spacer(modifier = Modifier.height(12.dp))

      Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
          containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.6f)
        )
      ) {
        Column(
          modifier = Modifier.padding(16.dp),
          horizontalAlignment = Alignment.CenterHorizontally
        ) {
          Text(
            text = pastoralMessage,
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onSurface
          )
          if (state.bestStreak > 1) {
            Spacer(modifier = Modifier.height(8.dp))
            Surface(
              shape = RoundedCornerShape(8.dp),
              color = Color(0xFFFFE0B2)
            ) {
              Text(
                text = "🔥 Maior sequência nesta rodada: ${state.bestStreak} acertos seguidos",
                style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                color = Color(0xFFE65100),
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
              )
            }
          }
        }
      }

      Spacer(modifier = Modifier.height(18.dp))

      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
      ) {
        Button(
          onClick = onPlayAgain,
          modifier = Modifier
            .weight(1f)
            .height(52.dp)
            .testTag("play_again_button"),
          shape = RoundedCornerShape(14.dp),
          colors = ButtonDefaults.buttonColors(containerColor = BibleNavyPrimary)
        ) {
          Icon(Icons.Default.Refresh, contentDescription = null, tint = BibleGold)
          Spacer(modifier = Modifier.width(6.dp))
          Text("Mais 10 Perguntas")
        }

        OutlinedButton(
          onClick = onChangeDifficulty,
          modifier = Modifier
            .weight(1f)
            .height(52.dp)
            .testTag("change_difficulty_button"),
          shape = RoundedCornerShape(14.dp)
        ) {
          Text("Mudar Nível")
        }
      }

      Spacer(modifier = Modifier.height(24.dp))

      Text(
        text = "Revisão das 10 Perguntas Respondidas",
        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
        textAlign = TextAlign.Start,
        modifier = Modifier.fillMaxWidth()
      )

      Spacer(modifier = Modifier.height(10.dp))
    }

    // Review Items
    itemsIndexed(state.answeredQuestions) { idx, item ->
      Card(
        modifier = Modifier
          .fillMaxWidth()
          .padding(vertical = 5.dp)
          .testTag("review_item_$idx"),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(
          containerColor = if (item.isCorrect) SuccessGreenLight else ErrorRedLight
        )
      ) {
        Column(modifier = Modifier.padding(14.dp)) {
          Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
              imageVector = if (item.isCorrect) Icons.Default.CheckCircle else Icons.Default.Cancel,
              contentDescription = null,
              tint = if (item.isCorrect) SuccessGreen else ErrorRed,
              modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
              text = "${idx + 1}. ${item.question.question}",
              style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
            )
          }

          Spacer(modifier = Modifier.height(6.dp))

          val chosenText = item.question.options.getOrNull(item.selectedIndex) ?: ""
          val correctText = item.question.options[item.question.correctOptionIndex]

          if (!item.isCorrect) {
            Text(
              text = "Sua resposta: $chosenText",
              style = MaterialTheme.typography.bodySmall,
              color = ErrorRed
            )
          }
          Text(
            text = "Resposta correta: $correctText",
            style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.SemiBold),
            color = SuccessGreen
          )
          Text(
            text = "📖 ${item.question.biblicalReference} — ${item.question.explanation}",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
          )
        }
      }
    }
  }
}
