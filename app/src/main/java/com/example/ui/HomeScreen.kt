package com.example.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
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
import com.example.data.DevotionalsData
import com.example.ui.theme.BibleGold
import com.example.ui.theme.BibleGoldLight
import com.example.ui.theme.BibleNavyPrimary
import com.example.viewmodel.AppScreen
import com.example.viewmodel.MainViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun HomeScreen(viewModel: MainViewModel) {
  val todayDevotional = remember { DevotionalsData.getTodayDevotional() }
  val bestScore = viewModel.prefs.bestScore
  val totalPlayed = viewModel.prefs.totalQuizzesPlayed

  val dateFormat = remember { SimpleDateFormat("EEEE, d 'de' MMMM", Locale("pt", "BR")) }
  val todayFormatted = remember { dateFormat.format(Date()).replaceFirstChar { it.uppercase() } }

  LazyColumn(
    modifier = Modifier
      .fillMaxSize()
      .testTag("home_screen"),
    contentPadding = PaddingValues(bottom = 100.dp)
  ) {
    // Hero Banner
    item {
      Box(
        modifier = Modifier
          .fillMaxWidth()
          .height(210.dp)
      ) {
        Image(
          painter = painterResource(id = R.drawable.banner_devotional),
          contentDescription = "Banner Bíblia e Fé",
          contentScale = ContentScale.Crop,
          modifier = Modifier.fillMaxSize()
        )
        // Dark gradient overlay
        Box(
          modifier = Modifier
            .fillMaxSize()
            .background(
              Brush.verticalGradient(
                colors = listOf(
                  Color.Black.copy(alpha = 0.35f),
                  BibleNavyPrimary.copy(alpha = 0.88f)
                )
              )
            )
        )
        Column(
          modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
          verticalArrangement = Arrangement.Bottom
        ) {
          Surface(
            color = BibleGold.copy(alpha = 0.25f),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier.padding(bottom = 6.dp)
          ) {
            Text(
              text = todayFormatted,
              style = MaterialTheme.typography.labelMedium,
              color = BibleGoldLight,
              modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
            )
          }
          Text(
            text = "Bíblia & Louvor",
            style = MaterialTheme.typography.displayLarge.copy(fontSize = 28.sp),
            color = Color.White
          )
          Text(
            text = "Alimento espiritual, sabedoria e comunhão para a sua alma",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.White.copy(alpha = 0.9f)
          )
        }
      }
    }

    // Daily Verse Card
    item {
      Card(
        modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = 16.dp, vertical = 12.dp)
          .testTag("daily_verse_card"),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
          containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.7f)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
      ) {
        Column(modifier = Modifier.padding(18.dp)) {
          Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
          ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
              Icon(
                imageVector = Icons.Default.AutoAwesome,
                contentDescription = null,
                tint = BibleGold,
                modifier = Modifier.size(20.dp)
              )
              Spacer(modifier = Modifier.width(8.dp))
              Text(
                text = "Versículo do Dia",
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                color = MaterialTheme.colorScheme.primary
              )
            }
            Surface(
              shape = RoundedCornerShape(12.dp),
              color = MaterialTheme.colorScheme.primaryContainer
            ) {
              Text(
                text = todayDevotional.category.title,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
              )
            }
          }

          Spacer(modifier = Modifier.height(10.dp))

          Text(
            text = "\"${todayDevotional.keyVerseText}\"",
            style = MaterialTheme.typography.bodyLarge.copy(fontSize = 15.sp),
            color = MaterialTheme.colorScheme.onSurface
          )

          Spacer(modifier = Modifier.height(6.dp))

          Text(
            text = "— ${todayDevotional.keyVerseReference}",
            style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Bold),
            color = BibleGold,
            modifier = Modifier.align(Alignment.End)
          )

          Spacer(modifier = Modifier.height(10.dp))

          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
          ) {
            FilledTonalButton(
              onClick = {
                viewModel.selectDevotional(todayDevotional)
                viewModel.navigateTo(AppScreen.DEVOTIONAL)
              },
              shape = RoundedCornerShape(12.dp),
              modifier = Modifier.testTag("read_devotional_btn")
            ) {
              Text("Ler Reflexão Completa")
              Spacer(modifier = Modifier.width(6.dp))
              Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                contentDescription = null,
                modifier = Modifier.size(16.dp)
              )
            }
          }
        }
      }
    }

    // Section Title
    item {
      Text(
        text = "Recursos Principais",
        style = MaterialTheme.typography.titleLarge,
        modifier = Modifier.padding(start = 18.dp, top = 8.dp, bottom = 8.dp)
      )
    }

    // 1. Quiz Bíblico Feature Card
    item {
      MainOptionCard(
        title = "Quiz Sobre a Bíblia",
        badge = "200 Perguntas | 10 por rodada",
        description = "Teste seus conhecimentos bíblicos com níveis personalizáveis: Fácil, Médio e Difícil, sorteadas entre 200 questões com referências bíblicas e explicações.",
        icon = Icons.Default.Quiz,
        accentColor = BibleGold,
        testTag = "quiz_option_card",
        onClick = { viewModel.navigateTo(AppScreen.QUIZ) }
      )
    }

    // 2. Palavra do Dia (Versículo & Reflexão)
    item {
      MainOptionCard(
        title = "Palavra do Dia",
        badge = "Versículos & Reflexão",
        description = "Leituras diárias edificantes com versículos temáticos (Paz, Fé, Amor, Esperança, Gratidão), meditação para o seu coração, oração guiada e áudio para ouvir.",
        icon = Icons.Default.MenuBook,
        accentColor = BibleNavyPrimary,
        testTag = "devotional_option_card",
        onClick = { viewModel.navigateTo(AppScreen.DEVOTIONAL) }
      )
    }

    // 3. Hinos CCB Feature Card
    item {
      MainOptionCard(
        title = "Hinos CCB",
        badge = "Hinário 5 | Buscar & Ouvir",
        description = "Pesquise por número ou letra dos hinos da Congregação Cristã no Brasil. Acompanhe as estrofes e ouça a melodia tocada em órgão harmônico.",
        icon = Icons.Default.MusicNote,
        accentColor = Color(0xFF6B3AA0),
        testTag = "hymns_option_card",
        onClick = { viewModel.navigateTo(AppScreen.HYMNS) }
      )
    }

    // 4. Fotos & Mensagens de Bênção
    item {
      MainOptionCard(
        title = "Fotos & Mensagens de Bênção",
        badge = "Bom Dia, Boa Tarde, Boa Noite",
        description = "Lindas paisagens da criação com versículos e votos de Bom Dia, Boa Tarde, Boa Noite e Durma com Deus para compartilhar.",
        icon = Icons.Default.Image,
        accentColor = Color(0xFF0D9488),
        testTag = "messages_option_card",
        onClick = { viewModel.navigateTo(AppScreen.MESSAGES) }
      )
    }

    // Quick Stats Bar
    item {
      Card(
        modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = 16.dp, vertical = 14.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
          containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.4f)
        )
      ) {
        Row(
          modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
          horizontalArrangement = Arrangement.SpaceAround,
          verticalAlignment = Alignment.CenterVertically
        ) {
          StatColumn(
            label = "Quizzes Feitos",
            value = totalPlayed.toString(),
            icon = Icons.Default.CheckCircle
          )
          HorizontalDivider(
            modifier = Modifier
              .height(36.dp)
              .width(1.dp)
          )
          StatColumn(
            label = "Melhor Pontuação",
            value = if (bestScore > 0) "$bestScore/10" else "—",
            icon = Icons.Default.EmojiEvents
          )
          HorizontalDivider(
            modifier = Modifier
              .height(36.dp)
              .width(1.dp)
          )
          StatColumn(
            label = "Perguntas Totais",
            value = "200",
            icon = Icons.Default.LibraryBooks
          )
        }
      }
    }
  }
}

@Composable
private fun MainOptionCard(
  title: String,
  badge: String,
  description: String,
  icon: androidx.compose.ui.graphics.vector.ImageVector,
  accentColor: Color,
  testTag: String,
  onClick: () -> Unit
) {
  Card(
    modifier = Modifier
      .fillMaxWidth()
      .padding(horizontal = 16.dp, vertical = 6.dp)
      .testTag(testTag)
      .clickable { onClick() },
    shape = RoundedCornerShape(18.dp),
    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
  ) {
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp),
      verticalAlignment = Alignment.CenterVertically
    ) {
      Box(
        modifier = Modifier
          .size(54.dp)
          .clip(CircleShape)
          .background(accentColor.copy(alpha = 0.15f)),
        contentAlignment = Alignment.Center
      ) {
        Icon(
          imageVector = icon,
          contentDescription = null,
          tint = accentColor,
          modifier = Modifier.size(28.dp)
        )
      }

      Spacer(modifier = Modifier.width(14.dp))

      Column(modifier = Modifier.weight(1f)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
          Text(
            text = title,
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
          )
        }
        Surface(
          color = accentColor.copy(alpha = 0.12f),
          shape = RoundedCornerShape(8.dp),
          modifier = Modifier.padding(vertical = 3.dp)
        ) {
          Text(
            text = badge,
            style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Medium),
            color = accentColor,
            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
          )
        }
        Text(
          text = description,
          style = MaterialTheme.typography.bodySmall,
          color = MaterialTheme.colorScheme.onSurfaceVariant,
          maxLines = 3
        )
      }

      Spacer(modifier = Modifier.width(8.dp))

      Icon(
        imageVector = Icons.AutoMirrored.Filled.ArrowForward,
        contentDescription = "Acessar $title",
        tint = MaterialTheme.colorScheme.onSurfaceVariant
      )
    }
  }
}

@Composable
private fun StatColumn(
  label: String,
  value: String,
  icon: androidx.compose.ui.graphics.vector.ImageVector
) {
  Column(horizontalAlignment = Alignment.CenterHorizontally) {
    Icon(
      imageVector = icon,
      contentDescription = null,
      tint = MaterialTheme.colorScheme.primary,
      modifier = Modifier.size(20.dp)
    )
    Spacer(modifier = Modifier.height(4.dp))
    Text(
      text = value,
      style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
    )
    Text(
      text = label,
      style = MaterialTheme.typography.labelSmall,
      color = MaterialTheme.colorScheme.onSurfaceVariant,
      textAlign = TextAlign.Center
    )
  }
}
