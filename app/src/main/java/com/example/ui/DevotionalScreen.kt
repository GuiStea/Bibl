package com.example.ui

import android.content.Intent
import androidx.compose.animation.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.data.DevotionalsData
import com.example.model.DevotionalCategory
import com.example.ui.theme.BibleGold
import com.example.ui.theme.BibleGoldLight
import com.example.ui.theme.BibleNavyPrimary
import com.example.viewmodel.MainViewModel

@Composable
fun DevotionalScreen(viewModel: MainViewModel) {
  val context = LocalContext.current
  val selectedDevotional by viewModel.selectedDevotional.collectAsState()
  val selectedTheme by viewModel.selectedDevotionalTheme.collectAsState()
  val isSpeaking by viewModel.ttsManager.isSpeaking.collectAsState()
  val textSize by viewModel.devotionalTextSize.collectAsState()

  val listState = rememberLazyListState()

  val displayedDevotionals = remember(selectedTheme) {
    if (selectedTheme == null) {
      DevotionalsData.devotionalsList
    } else {
      DevotionalsData.getByTheme(selectedTheme!!)
    }
  }

  LazyColumn(
    state = listState,
    modifier = Modifier
      .fillMaxSize()
      .testTag("devotional_screen"),
    contentPadding = PaddingValues(bottom = 100.dp)
  ) {
    // Header Hero Banner
    item {
      Box(
        modifier = Modifier
          .fillMaxWidth()
          .height(180.dp)
      ) {
        Image(
          painter = painterResource(id = R.drawable.banner_devotional),
          contentDescription = "Banner Devocional",
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
                  BibleNavyPrimary.copy(alpha = 0.88f)
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
              text = "Leitura & Reflexão Bíblica",
              style = MaterialTheme.typography.labelSmall,
              color = BibleGoldLight,
              modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
            )
          }
          Spacer(modifier = Modifier.height(4.dp))
          Text(
            text = "Palavra do Dia",
            style = MaterialTheme.typography.headlineLarge,
            color = Color.White
          )
          Text(
            text = "Versículos temáticos, reflexão pastoral e orações para o seu dia",
            style = MaterialTheme.typography.bodySmall,
            color = Color.White.copy(alpha = 0.9f)
          )
        }
      }
    }

    // Theme Filter Scrollable Row
    item {
      Column(modifier = Modifier.padding(top = 12.dp, bottom = 6.dp)) {
        Text(
          text = "Filtrar por Tema:",
          style = MaterialTheme.typography.labelMedium,
          color = MaterialTheme.colorScheme.onSurfaceVariant,
          modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
        )
        Row(
          modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())
            .padding(horizontal = 12.dp),
          horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
          FilterChip(
            selected = selectedTheme == null,
            onClick = { viewModel.filterDevotionalsByTheme(null) },
            label = { Text("Todos os Temas") },
            modifier = Modifier.testTag("theme_all")
          )
          DevotionalCategory.entries.forEach { theme ->
            FilterChip(
              selected = selectedTheme == theme,
              onClick = { viewModel.filterDevotionalsByTheme(theme) },
              label = { Text(theme.title) },
              modifier = Modifier.testTag("theme_${theme.name}")
            )
          }
        }
      }
    }

    // Devotionals Horizontal Selector Cards
    item {
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .horizontalScroll(rememberScrollState())
          .padding(horizontal = 12.dp, vertical = 6.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
      ) {
        displayedDevotionals.forEach { dev ->
          val isSelected = dev.id == selectedDevotional.id
          ElevatedCard(
            modifier = Modifier
              .width(200.dp)
              .clickable { viewModel.selectDevotional(dev) }
              .testTag("devotional_card_${dev.id}"),
            shape = RoundedCornerShape(14.dp),
            colors = CardDefaults.elevatedCardColors(
              containerColor = if (isSelected) {
                MaterialTheme.colorScheme.primaryContainer
              } else {
                MaterialTheme.colorScheme.surface
              }
            )
          ) {
            Column(modifier = Modifier.padding(12.dp)) {
              Surface(
                color = if (isSelected) BibleGold else MaterialTheme.colorScheme.surfaceVariant,
                shape = RoundedCornerShape(6.dp)
              ) {
                Text(
                  text = dev.category.title,
                  style = MaterialTheme.typography.labelSmall,
                  color = if (isSelected) Color.White else MaterialTheme.colorScheme.onSurfaceVariant,
                  modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                )
              }
              Spacer(modifier = Modifier.height(6.dp))
              Text(
                text = dev.title,
                style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                maxLines = 2
              )
              Spacer(modifier = Modifier.height(4.dp))
              Text(
                text = dev.keyVerseReference,
                style = MaterialTheme.typography.bodySmall,
                color = BibleGold
              )
            }
          }
        }
      }
    }

    // Active Devotional Content Container
    item {
      Card(
        modifier = Modifier
          .fillMaxWidth()
          .padding(16.dp)
          .testTag("active_devotional_container"),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
      ) {
        Column(modifier = Modifier.padding(18.dp)) {

          // Controls & Action Bar
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Surface(
              shape = RoundedCornerShape(8.dp),
              color = MaterialTheme.colorScheme.primaryContainer
            ) {
              Text(
                text = selectedDevotional.category.title,
                style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
              )
            }

            // Audio & Font Controls
            Row(verticalAlignment = Alignment.CenterVertically) {
              // Font Size adjustment
              IconButton(
                onClick = { viewModel.adjustDevotionalTextSize(-1) },
                modifier = Modifier.size(36.dp)
              ) {
                Text("A-", fontWeight = FontWeight.Bold, style = MaterialTheme.typography.labelMedium)
              }
              IconButton(
                onClick = { viewModel.adjustDevotionalTextSize(1) },
                modifier = Modifier.size(36.dp)
              ) {
                Text("A+", fontWeight = FontWeight.Bold, style = MaterialTheme.typography.labelMedium)
              }

              // Share Button
              IconButton(
                onClick = {
                  val sendIntent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(
                      Intent.EXTRA_TEXT,
                      "📖 Palavra do Dia: ${selectedDevotional.title}\n\n" +
                          "\"${selectedDevotional.keyVerseText}\" (${selectedDevotional.keyVerseReference})\n\n" +
                          "Reflexão:\n${selectedDevotional.reflectionParagraphs.joinToString("\n\n")}\n\n" +
                          "Oração:\n${selectedDevotional.guidedPrayer}"
                    )
                    type = "text/plain"
                  }
                  context.startActivity(Intent.createChooser(sendIntent, "Compartilhar Palavra do Dia"))
                },
                modifier = Modifier.size(36.dp).testTag("share_devotional_btn")
              ) {
                Icon(Icons.Default.Share, contentDescription = "Compartilhar")
              }
            }
          }

          Spacer(modifier = Modifier.height(12.dp))

          // Title
          Text(
            text = selectedDevotional.title,
            style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
            color = MaterialTheme.colorScheme.onSurface
          )

          Spacer(modifier = Modifier.height(14.dp))

          // Key Verse Highlight Card
          Card(
            modifier = Modifier
              .fillMaxWidth()
              .testTag("key_verse_box"),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
              containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.35f)
            ),
            border = androidx.compose.foundation.BorderStroke(1.5.dp, BibleGold)
          ) {
            Column(modifier = Modifier.padding(16.dp)) {
              Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                  imageVector = Icons.Default.FormatQuote,
                  contentDescription = null,
                  tint = BibleGold,
                  modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                  text = "Versículo Chave",
                  style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                  color = BibleGold
                )
              }

              Spacer(modifier = Modifier.height(8.dp))

              Text(
                text = "\"${selectedDevotional.keyVerseText}\"",
                style = MaterialTheme.typography.bodyLarge.copy(
                  fontSize = (textSize + 1).sp,
                  lineHeight = (textSize + 8).sp,
                  fontStyle = androidx.compose.ui.text.font.FontStyle.Italic
                ),
                color = MaterialTheme.colorScheme.onSurface
              )

              Spacer(modifier = Modifier.height(6.dp))

              Text(
                text = "— ${selectedDevotional.keyVerseReference}",
                style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.align(Alignment.End)
              )
            }
          }

          Spacer(modifier = Modifier.height(16.dp))

          // Listen with Speech Audio Button
          FilledTonalButton(
            onClick = { viewModel.playDevotionalAudio(selectedDevotional) },
            modifier = Modifier
              .fillMaxWidth()
              .testTag("play_devotional_audio_button"),
            shape = RoundedCornerShape(14.dp),
            colors = ButtonDefaults.filledTonalButtonColors(
              containerColor = if (isSpeaking) BibleGold else MaterialTheme.colorScheme.secondaryContainer
            )
          ) {
            Icon(
              imageVector = if (isSpeaking) Icons.Default.Stop else Icons.Default.VolumeUp,
              contentDescription = null,
              tint = if (isSpeaking) Color.White else MaterialTheme.colorScheme.onSecondaryContainer
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
              text = if (isSpeaking) "Parar Leitura em Voz Alta" else "Ouvir Palavra do Dia (Áudio Narrado)",
              color = if (isSpeaking) Color.White else MaterialTheme.colorScheme.onSecondaryContainer,
              fontWeight = FontWeight.Bold
            )
          }

          Spacer(modifier = Modifier.height(16.dp))

          // Reflection Text Paragraphs
          Text(
            text = "Leitura e Reflexão",
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
            color = MaterialTheme.colorScheme.primary
          )

          Spacer(modifier = Modifier.height(8.dp))

          selectedDevotional.reflectionParagraphs.forEach { paragraph ->
            Text(
              text = paragraph,
              style = MaterialTheme.typography.bodyLarge.copy(
                fontSize = textSize.sp,
                lineHeight = (textSize + 8).sp
              ),
              color = MaterialTheme.colorScheme.onSurface,
              modifier = Modifier.padding(vertical = 4.dp)
            )
          }

          Spacer(modifier = Modifier.height(18.dp))

          // Guided Prayer Card
          Card(
            modifier = Modifier
              .fillMaxWidth()
              .testTag("guided_prayer_card"),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
              containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
            )
          ) {
            Column(modifier = Modifier.padding(16.dp)) {
              Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                  imageVector = Icons.Default.SelfImprovement,
                  contentDescription = null,
                  tint = BibleNavyPrimary,
                  modifier = Modifier.size(22.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                  text = "Oração do Dia",
                  style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                  color = BibleNavyPrimary
                )
              }
              Spacer(modifier = Modifier.height(8.dp))
              Text(
                text = selectedDevotional.guidedPrayer,
                style = MaterialTheme.typography.bodyMedium.copy(
                  fontSize = textSize.sp,
                  lineHeight = (textSize + 7).sp,
                  fontStyle = androidx.compose.ui.text.font.FontStyle.Italic
                )
              )
            }
          }

          Spacer(modifier = Modifier.height(14.dp))

          // Practical Action Card
          Card(
            modifier = Modifier
              .fillMaxWidth()
              .testTag("practical_action_card"),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
              containerColor = Color(0xFFE8F5E9)
            )
          ) {
            Row(
              modifier = Modifier.padding(14.dp),
              verticalAlignment = Alignment.CenterVertically
            ) {
              Icon(
                imageVector = Icons.Default.CheckCircleOutline,
                contentDescription = null,
                tint = Color(0xFF2E7D32),
                modifier = Modifier.size(24.dp)
              )
              Spacer(modifier = Modifier.width(10.dp))
              Column {
                Text(
                  text = "Ação Prática de Fé:",
                  style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                  color = Color(0xFF1B5E20)
                )
                Text(
                  text = selectedDevotional.practicalAction,
                  style = MaterialTheme.typography.bodyMedium,
                  color = Color(0xFF2E7D32)
                )
              }
            }
          }
        }
      }
    }
  }
}
