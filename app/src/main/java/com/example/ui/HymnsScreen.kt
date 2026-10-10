package com.example.ui

import android.content.Intent
import androidx.activity.compose.BackHandler
import androidx.compose.animation.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.data.HymnsData
import com.example.model.Hymn
import com.example.model.HymnCategory
import com.example.ui.theme.BibleGold
import com.example.ui.theme.BibleGoldLight
import com.example.ui.theme.BibleNavyPrimary
import com.example.viewmodel.MainViewModel

@Composable
fun HymnsScreen(viewModel: MainViewModel) {
  val activeHymn by viewModel.activeHymnDetail.collectAsState()

  if (activeHymn != null) {
    BackHandler {
      viewModel.closeHymnDetail()
    }
    HymnDetailView(hymn = activeHymn!!, viewModel = viewModel)
  } else {
    HymnsListView(viewModel = viewModel)
  }
}

@Composable
private fun HymnsListView(viewModel: MainViewModel) {
  val searchQuery by viewModel.hymnSearchQuery.collectAsState()
  val selectedCategory by viewModel.selectedHymnCategory.collectAsState()
  val showFavoritesOnly by viewModel.showOnlyFavoriteHymns.collectAsState()
  val isPlaying by viewModel.synthesizer.isPlaying.collectAsState()
  val currentPlayingNum by viewModel.synthesizer.currentHymnNumber.collectAsState()

  val filteredHymns = remember(searchQuery, selectedCategory, showFavoritesOnly) {
    val results = HymnsData.searchHymns(searchQuery, selectedCategory)
    if (showFavoritesOnly) {
      results.filter { viewModel.prefs.isHymnFavorite(it.number) }
    } else {
      results
    }
  }

  LazyColumn(
    modifier = Modifier
      .fillMaxSize()
      .testTag("hymns_list_screen"),
    contentPadding = PaddingValues(bottom = 100.dp)
  ) {
    // Header Banner
    item {
      Box(
        modifier = Modifier
          .fillMaxWidth()
          .height(180.dp)
      ) {
        Image(
          painter = painterResource(id = R.drawable.banner_hinario),
          contentDescription = "Banner Hinário CCB",
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
              text = "Hinário CCB Nº 5",
              style = MaterialTheme.typography.labelSmall,
              color = BibleGoldLight,
              modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
            )
          }
          Spacer(modifier = Modifier.height(4.dp))
          Text(
            text = "Hinos de Louvores e Súplicas a Deus",
            style = MaterialTheme.typography.headlineLarge,
            color = Color.White
          )
          Text(
            text = "Pesquise por número ou título e ouça o arranjo harmônico",
            style = MaterialTheme.typography.bodySmall,
            color = Color.White.copy(alpha = 0.9f)
          )
        }
      }
    }

    // Search Field
    item {
      Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
          value = searchQuery,
          onValueChange = { viewModel.setHymnSearchQuery(it) },
          placeholder = { Text("Pesquisar hino por número (ex: 131) ou letra...") },
          leadingIcon = {
            Icon(Icons.Default.Search, contentDescription = null, tint = BibleGold)
          },
          trailingIcon = {
            if (searchQuery.isNotEmpty()) {
              IconButton(onClick = { viewModel.setHymnSearchQuery("") }) {
                Icon(Icons.Default.Clear, contentDescription = "Limpar busca")
              }
            }
          },
          modifier = Modifier
            .fillMaxWidth()
            .testTag("hymn_search_field"),
          shape = RoundedCornerShape(16.dp),
          singleLine = true
        )
      }
    }

    // Category & Favorites Filters
    item {
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .horizontalScroll(rememberScrollState())
          .padding(horizontal = 16.dp, vertical = 4.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
      ) {
        FilterChip(
          selected = showFavoritesOnly,
          onClick = { viewModel.toggleShowOnlyFavorites() },
          label = { Text("Favoritos") },
          leadingIcon = {
            Icon(
              imageVector = if (showFavoritesOnly) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
              contentDescription = null,
              tint = if (showFavoritesOnly) Color.Red else MaterialTheme.colorScheme.onSurfaceVariant,
              modifier = Modifier.size(16.dp)
            )
          },
          modifier = Modifier.testTag("fav_hymns_filter")
        )

        HymnCategory.entries.forEach { cat ->
          val isSelected = selectedCategory == cat
          FilterChip(
            selected = isSelected,
            onClick = { viewModel.setHymnCategory(cat) },
            label = { Text(cat.label) },
            modifier = Modifier.testTag("hymn_cat_${cat.name}")
          )
        }
      }
    }

    // Results Counter
    item {
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = 16.dp, vertical = 6.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Text(
          text = "${filteredHymns.size} hino(s) encontrado(s)",
          style = MaterialTheme.typography.labelMedium,
          color = MaterialTheme.colorScheme.onSurfaceVariant
        )
      }
    }

    // Hymns List Cards
    items(filteredHymns, key = { it.number }) { hymn ->
      val isThisPlaying = (isPlaying && currentPlayingNum == hymn.number)
      var isFav by remember(hymn.number) {
        mutableStateOf(viewModel.prefs.isHymnFavorite(hymn.number))
      }

      Card(
        modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = 16.dp, vertical = 5.dp)
          .testTag("hymn_item_${hymn.number}")
          .clickable { viewModel.openHymnDetail(hymn) },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
          containerColor = if (isThisPlaying) {
            MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.5f)
          } else {
            MaterialTheme.colorScheme.surface
          }
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.5.dp)
      ) {
        Row(
          modifier = Modifier
            .fillMaxWidth()
            .padding(14.dp),
          verticalAlignment = Alignment.CenterVertically
        ) {
          // Number Golden Circle
          Box(
            modifier = Modifier
              .size(46.dp)
              .clip(CircleShape)
              .background(
                if (isThisPlaying) BibleGold else MaterialTheme.colorScheme.primary.copy(alpha = 0.12f)
              ),
            contentAlignment = Alignment.Center
          ) {
            Text(
              text = hymn.number.toString(),
              style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
              color = if (isThisPlaying) Color.White else MaterialTheme.colorScheme.primary
            )
          }

          Spacer(modifier = Modifier.width(14.dp))

          // Hymn Info
          Column(modifier = Modifier.weight(1f)) {
            Text(
              text = hymn.title,
              style = MaterialTheme.typography.titleMedium.copy(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
              ),
              maxLines = 1
            )
            Spacer(modifier = Modifier.height(2.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
              Text(
                text = hymn.category.label,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
              )
              Text(
                text = " • ${hymn.tonality}",
                style = MaterialTheme.typography.bodySmall,
                color = BibleGold
              )
            }
          }

          // Quick Play Organ Action
          IconButton(
            onClick = { viewModel.playHymnOrgan(hymn) },
            modifier = Modifier.testTag("quick_play_${hymn.number}")
          ) {
            Icon(
              imageVector = if (isThisPlaying) Icons.Default.PauseCircleFilled else Icons.Default.PlayCircleFilled,
              contentDescription = if (isThisPlaying) "Pausar Órgão" else "Tocar Órgão",
              tint = if (isThisPlaying) BibleGold else MaterialTheme.colorScheme.primary,
              modifier = Modifier.size(36.dp)
            )
          }

          // Favorite Action
          IconButton(
            onClick = {
              isFav = viewModel.toggleHymnFavorite(hymn.number)
            },
            modifier = Modifier.size(36.dp)
          ) {
            Icon(
              imageVector = if (isFav) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
              contentDescription = "Favoritar Hino",
              tint = if (isFav) Color.Red else MaterialTheme.colorScheme.outline
            )
          }
        }
      }
    }
  }
}

@Composable
private fun HymnDetailView(hymn: Hymn, viewModel: MainViewModel) {
  val context = LocalContext.current
  val isPlaying by viewModel.synthesizer.isPlaying.collectAsState()
  val progress by viewModel.synthesizer.progress.collectAsState()
  val currentPlayingNum by viewModel.synthesizer.currentHymnNumber.collectAsState()
  val isSpeaking by viewModel.ttsManager.isSpeaking.collectAsState()
  val textSize by viewModel.hymnTextSize.collectAsState()

  var isFav by remember(hymn.number) {
    mutableStateOf(viewModel.prefs.isHymnFavorite(hymn.number))
  }

  val isThisPlaying = (isPlaying && currentPlayingNum == hymn.number)

  LazyColumn(
    modifier = Modifier
      .fillMaxSize()
      .testTag("hymn_detail_screen"),
    contentPadding = PaddingValues(bottom = 100.dp)
  ) {
    // Top Bar
    item {
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = 8.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
      ) {
        IconButton(
          onClick = { viewModel.closeHymnDetail() },
          modifier = Modifier.testTag("close_hymn_detail_btn")
        ) {
          Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Voltar aos hinos")
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
          IconButton(onClick = { viewModel.adjustHymnTextSize(-1) }) {
            Text("A-", fontWeight = FontWeight.Bold)
          }
          IconButton(onClick = { viewModel.adjustHymnTextSize(1) }) {
            Text("A+", fontWeight = FontWeight.Bold)
          }
          IconButton(
            onClick = {
              val lyrics = buildString {
                append("Hino ${hymn.number} - ${hymn.title}\n\n")
                hymn.verses.forEach { verse ->
                  append("${verse.number}. ${verse.text}\n\n")
                  hymn.chorus?.let { append("Coro:\n$it\n\n") }
                }
              }
              val intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, lyrics)
                type = "text/plain"
              }
              context.startActivity(Intent.createChooser(intent, "Compartilhar Hino"))
            }
          ) {
            Icon(Icons.Default.Share, contentDescription = "Compartilhar Hino")
          }
          IconButton(
            onClick = { isFav = viewModel.toggleHymnFavorite(hymn.number) }
          ) {
            Icon(
              imageVector = if (isFav) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
              contentDescription = "Favoritar",
              tint = if (isFav) Color.Red else MaterialTheme.colorScheme.outline
            )
          }
        }
      }
    }

    // Title Card
    item {
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = 20.dp, vertical = 6.dp),
        horizontalAlignment = Alignment.CenterHorizontally
      ) {
        Surface(
          color = BibleGold.copy(alpha = 0.2f),
          shape = RoundedCornerShape(12.dp)
        ) {
          Text(
            text = "Hino ${hymn.number}",
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
            color = BibleGold,
            modifier = Modifier.padding(horizontal = 14.dp, vertical = 4.dp)
          )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
          text = hymn.title,
          style = MaterialTheme.typography.headlineLarge,
          fontWeight = FontWeight.Bold,
          color = MaterialTheme.colorScheme.onSurface
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
          text = "${hymn.category.label} • Tom: ${hymn.tonality} • Compasso: ${hymn.timeSignature}",
          style = MaterialTheme.typography.bodySmall,
          color = MaterialTheme.colorScheme.onSurfaceVariant
        )
      }

      Spacer(modifier = Modifier.height(14.dp))
    }

    // Audio Synthesizer Organ Player Card
    item {
      Card(
        modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = 16.dp, vertical = 6.dp)
          .testTag("organ_player_card"),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
          containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.6f)
        )
      ) {
        Column(modifier = Modifier.padding(16.dp)) {
          Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
          ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
              Icon(
                imageVector = Icons.Default.Piano,
                contentDescription = null,
                tint = BibleNavyPrimary,
                modifier = Modifier.size(22.dp)
              )
              Spacer(modifier = Modifier.width(8.dp))
              Text(
                text = if (isThisPlaying) "Tocando Arranjo Sacro no Órgão..." else "Arranjo Harmônico no Órgão",
                style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                color = BibleNavyPrimary
              )
            }

            Surface(
              color = if (isThisPlaying) BibleGold else MaterialTheme.colorScheme.surface,
              shape = RoundedCornerShape(8.dp)
            ) {
              Text(
                text = if (isThisPlaying) "Ao Vivo" else "Pronto",
                style = MaterialTheme.typography.labelSmall,
                color = if (isThisPlaying) Color.White else MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
              )
            }
          }

          if (isThisPlaying) {
            Spacer(modifier = Modifier.height(10.dp))
            LinearProgressIndicator(
              progress = { progress },
              modifier = Modifier
                .fillMaxWidth()
                .height(6.dp)
                .clip(RoundedCornerShape(3.dp)),
              color = BibleGold,
              trackColor = Color.White.copy(alpha = 0.5f)
            )
          }

          Spacer(modifier = Modifier.height(12.dp))

          // Player Buttons
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
          ) {
            // Main Play/Pause Organ
            Button(
              onClick = { viewModel.playHymnOrgan(hymn) },
              modifier = Modifier
                .weight(1f)
                .testTag("play_organ_btn"),
              shape = RoundedCornerShape(12.dp),
              colors = ButtonDefaults.buttonColors(containerColor = BibleNavyPrimary)
            ) {
              Icon(
                imageVector = if (isThisPlaying) Icons.Default.Pause else Icons.Default.PlayArrow,
                contentDescription = null,
                tint = BibleGold
              )
              Spacer(modifier = Modifier.width(6.dp))
              Text(if (isThisPlaying) "Pausar Melodia" else "Ouvir no Órgão")
            }

            // Recite with Voice (TTS)
            FilledTonalButton(
              onClick = { viewModel.reciteHymn(hymn) },
              modifier = Modifier
                .weight(1f)
                .testTag("recite_hymn_btn"),
              shape = RoundedCornerShape(12.dp)
            ) {
              Icon(
                imageVector = if (isSpeaking) Icons.Default.Stop else Icons.Default.RecordVoiceOver,
                contentDescription = null,
                tint = if (isSpeaking) Color.Red else MaterialTheme.colorScheme.primary
              )
              Spacer(modifier = Modifier.width(6.dp))
              Text(if (isSpeaking) "Parar Voz" else "Recitar Letra")
            }
          }

          // Speed multipliers
          Row(
            modifier = Modifier
              .fillMaxWidth()
              .padding(top = 8.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Text(
              text = "Andamento: ",
              style = MaterialTheme.typography.labelSmall,
              color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            AssistChip(
              onClick = { viewModel.synthesizer.setPlaybackSpeed(0.85f) },
              label = { Text("Lento") },
              modifier = Modifier.padding(horizontal = 2.dp)
            )
            AssistChip(
              onClick = { viewModel.synthesizer.setPlaybackSpeed(1.0f) },
              label = { Text("Normal") },
              modifier = Modifier.padding(horizontal = 2.dp)
            )
            AssistChip(
              onClick = { viewModel.synthesizer.setPlaybackSpeed(1.18f) },
              label = { Text("Rápido") },
              modifier = Modifier.padding(horizontal = 2.dp)
            )
          }
        }
      }

      Spacer(modifier = Modifier.height(14.dp))
    }

    // Verses & Chorus
    items(hymn.verses) { verse ->
      Card(
        modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = 16.dp, vertical = 6.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
      ) {
        Column(modifier = Modifier.padding(18.dp)) {
          Surface(
            shape = CircleShape,
            color = MaterialTheme.colorScheme.primary.copy(alpha = 0.12f),
            modifier = Modifier.size(28.dp)
          ) {
            Box(contentAlignment = Alignment.Center) {
              Text(
                text = verse.number.toString(),
                style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                color = MaterialTheme.colorScheme.primary
              )
            }
          }

          Spacer(modifier = Modifier.height(10.dp))

          Text(
            text = verse.text,
            style = MaterialTheme.typography.bodyLarge.copy(
              fontSize = textSize.sp,
              lineHeight = (textSize + 8).sp
            ),
            color = MaterialTheme.colorScheme.onSurface
          )
        }
      }

      // Highlight Chorus if exists
      if (hymn.chorus != null) {
        Card(
          modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 6.dp),
          shape = RoundedCornerShape(16.dp),
          colors = CardDefaults.cardColors(
            containerColor = BibleGold.copy(alpha = 0.1f)
          ),
          border = androidx.compose.foundation.BorderStroke(1.dp, BibleGold.copy(alpha = 0.4f))
        ) {
          Column(modifier = Modifier.padding(16.dp)) {
            Text(
              text = "CORO",
              style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
              color = BibleGold
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
              text = hymn.chorus,
              style = MaterialTheme.typography.bodyLarge.copy(
                fontSize = textSize.sp,
                lineHeight = (textSize + 8).sp,
                fontStyle = androidx.compose.ui.text.font.FontStyle.Italic
              ),
              color = MaterialTheme.colorScheme.onSurface
            )
          }
        }
      }
    }
  }
}
