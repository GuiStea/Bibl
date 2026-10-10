package com.example.ui

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
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.data.BlessingCardsData
import com.example.model.BlessingCard
import com.example.model.BlessingCategory
import com.example.ui.theme.BibleGold
import com.example.ui.theme.BibleGoldLight
import com.example.ui.theme.BibleNavyPrimary
import com.example.util.BlessingImageGenerator
import com.example.viewmodel.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.Calendar

@Composable
fun BlessingsScreen(viewModel: MainViewModel) {
  val selectedCategory by viewModel.selectedBlessingCategory.collectAsState()
  val showFavoritesOnly by viewModel.showOnlyFavoriteBlessings.collectAsState()
  val activeDetailCard by viewModel.activeBlessingCard.collectAsState()

  if (activeDetailCard != null) {
    BackHandler {
      viewModel.closeBlessingDetail()
    }
    BlessingCardDetailView(card = activeDetailCard!!, viewModel = viewModel)
  } else {
    BlessingsListView(
      selectedCategory = selectedCategory,
      showFavoritesOnly = showFavoritesOnly,
      viewModel = viewModel
    )
  }
}

@Composable
private fun BlessingsListView(
  selectedCategory: BlessingCategory,
  showFavoritesOnly: Boolean,
  viewModel: MainViewModel
) {
  val context = LocalContext.current
  val coroutineScope = rememberCoroutineScope()

  val currentHour = remember { Calendar.getInstance().get(Calendar.HOUR_OF_DAY) }
  val timeGreeting = remember(currentHour) {
    when {
      currentHour in 5..11 -> "Bom Dia com Paz e Graça ☀️"
      currentHour in 12..17 -> "Boa Tarde Abençoada 🌤️"
      currentHour in 18..21 -> "Boa Noite na Presença de Deus 🌙"
      else -> "Durma com Deus e Bom Descanso ✨"
    }
  }

  val displayedCards = remember(selectedCategory, showFavoritesOnly) {
    val list = BlessingCardsData.getByCategory(selectedCategory)
    if (showFavoritesOnly) {
      list.filter { viewModel.prefs.isBlessingFavorite(it.id) }
    } else {
      list
    }
  }

  LazyColumn(
    modifier = Modifier
      .fillMaxSize()
      .testTag("blessings_screen"),
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
          painter = painterResource(id = R.drawable.img_bom_dia),
          contentDescription = "Banner Mensagens com Fotos",
          contentScale = ContentScale.Crop,
          modifier = Modifier.fillMaxSize()
        )
        Box(
          modifier = Modifier
            .fillMaxSize()
            .background(
              Brush.verticalGradient(
                listOf(
                  Color.Black.copy(alpha = 0.35f),
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
            color = BibleGold.copy(alpha = 0.35f),
            shape = RoundedCornerShape(12.dp)
          ) {
            Text(
              text = timeGreeting,
              style = MaterialTheme.typography.labelSmall,
              color = BibleGoldLight,
              modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
            )
          }
          Spacer(modifier = Modifier.height(4.dp))
          Text(
            text = "Fotos com Mensagens de Bênção",
            style = MaterialTheme.typography.headlineLarge,
            color = Color.White
          )
          Text(
            text = "Paisagens com texto integrado para salvar na galeria e compartilhar",
            style = MaterialTheme.typography.bodySmall,
            color = Color.White.copy(alpha = 0.9f)
          )
        }
      }
    }

    // Category Tabs Filter
    item {
      Column(modifier = Modifier.padding(vertical = 8.dp)) {
        Row(
          modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())
            .padding(horizontal = 16.dp),
          horizontalArrangement = Arrangement.spacedBy(8.dp),
          verticalAlignment = Alignment.CenterVertically
        ) {
          FilterChip(
            selected = showFavoritesOnly,
            onClick = { viewModel.toggleShowOnlyFavoriteBlessings() },
            label = { Text("Favoritos") },
            leadingIcon = {
              Icon(
                imageVector = if (showFavoritesOnly) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                contentDescription = null,
                tint = if (showFavoritesOnly) Color.Red else MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.size(16.dp)
              )
            },
            modifier = Modifier.testTag("fav_blessings_chip")
          )

          BlessingCategory.entries.forEach { cat ->
            val isSelected = (selectedCategory == cat && !showFavoritesOnly)
            FilterChip(
              selected = isSelected,
              onClick = {
                if (showFavoritesOnly) viewModel.toggleShowOnlyFavoriteBlessings()
                viewModel.setBlessingCategory(cat)
              },
              label = { Text(cat.label) },
              modifier = Modifier.testTag("cat_chip_${cat.name}")
            )
          }
        }
      }
    }

    // Cards List with text rendered ON the photo
    items(displayedCards, key = { it.id }) { card ->
      var isFav by remember(card.id) {
        mutableStateOf(viewModel.prefs.isBlessingFavorite(card.id))
      }

      Card(
        modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = 16.dp, vertical = 10.dp)
          .testTag("blessing_card_${card.id}"),
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
      ) {
        Column {
          // PHOTO CARD WITH TEXT EMBEDDED DIRECTLY ON THE IMAGE
          Box(
            modifier = Modifier
              .fillMaxWidth()
              .height(340.dp)
              .clickable { viewModel.openBlessingDetail(card) }
          ) {
            // Background Landscape Image
            Image(
              painter = painterResource(id = card.imageResId),
              contentDescription = card.title,
              contentScale = ContentScale.Crop,
              modifier = Modifier.fillMaxSize()
            )

            // Scrim gradient: dark at top and bottom for text contrast
            Box(
              modifier = Modifier
                .fillMaxSize()
                .background(
                  Brush.verticalGradient(
                    listOf(
                      Color.Black.copy(alpha = 0.55f),
                      Color.Transparent,
                      Color.Black.copy(alpha = 0.75f),
                      Color.Black.copy(alpha = 0.92f)
                    )
                  )
                )
            )

            // Top Header inside the photo
            Row(
              modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Surface(
                color = BibleGold.copy(alpha = 0.9f),
                shape = RoundedCornerShape(12.dp)
              ) {
                Text(
                  text = card.category.label,
                  style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                  color = Color.White,
                  modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                )
              }

              IconButton(
                onClick = { isFav = viewModel.toggleBlessingFavorite(card.id) },
                modifier = Modifier
                  .size(36.dp)
                  .clip(CircleShape)
                  .background(Color.Black.copy(alpha = 0.4f))
              ) {
                Icon(
                  imageVector = if (isFav) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                  contentDescription = "Favoritar",
                  tint = if (isFav) Color.Red else Color.White,
                  modifier = Modifier.size(20.dp)
                )
              }
            }

            // TEXT OVERLAY DIRECTLY ON THE PHOTO (Greeting + Divider + Verse)
            Column(
              modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(18.dp)
            ) {
              // Main Greeting
              Text(
                text = card.greeting,
                style = MaterialTheme.typography.titleMedium.copy(
                  fontSize = 19.sp,
                  fontWeight = FontWeight.Bold,
                  lineHeight = 24.sp
                ),
                color = Color.White
              )

              Spacer(modifier = Modifier.height(8.dp))

              // Decorative golden divider
              HorizontalDivider(
                modifier = Modifier.width(60.dp),
                thickness = 2.dp,
                color = BibleGold
              )

              Spacer(modifier = Modifier.height(8.dp))

              // Holy Scripture Verse on the photo
              Text(
                text = "\"${card.scriptureVerse}\"",
                style = MaterialTheme.typography.bodyMedium.copy(
                  fontSize = 14.sp,
                  fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
                  lineHeight = 20.sp
                ),
                color = Color(0xFFF1F5F9)
              )

              Spacer(modifier = Modifier.height(4.dp))

              // Reference on the photo
              Text(
                text = "— ${card.scriptureReference}",
                style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                color = BibleGoldLight,
                modifier = Modifier.align(Alignment.End)
              )
            }
          }

          // BOTTOM ACTION BAR: Salvar na Galeria & Compartilhar Imagem
          Row(
            modifier = Modifier
              .fillMaxWidth()
              .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f))
              .padding(horizontal = 14.dp, vertical = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
          ) {
            // Salvar Foto na Galeria
            Button(
              onClick = {
                coroutineScope.launch {
                  val bitmap = withContext(Dispatchers.Default) {
                    BlessingImageGenerator.generateCompositeBitmap(context, card)
                  }
                  BlessingImageGenerator.saveBitmapToGallery(context, bitmap, card.title)
                }
              },
              modifier = Modifier
                .weight(1f)
                .testTag("save_photo_${card.id}"),
              shape = RoundedCornerShape(12.dp),
              colors = ButtonDefaults.buttonColors(containerColor = BibleNavyPrimary)
            ) {
              Icon(Icons.Default.Download, contentDescription = null, tint = BibleGold, modifier = Modifier.size(18.dp))
              Spacer(modifier = Modifier.width(6.dp))
              Text("Salvar Foto", fontWeight = FontWeight.Bold)
            }

            // Compartilhar Imagem
            FilledTonalButton(
              onClick = {
                coroutineScope.launch {
                  val bitmap = withContext(Dispatchers.Default) {
                    BlessingImageGenerator.generateCompositeBitmap(context, card)
                  }
                  BlessingImageGenerator.shareCompositeBitmap(context, bitmap, card)
                }
              },
              modifier = Modifier
                .weight(1f)
                .testTag("share_photo_${card.id}"),
              shape = RoundedCornerShape(12.dp)
            ) {
              Icon(Icons.Default.Share, contentDescription = null, modifier = Modifier.size(18.dp))
              Spacer(modifier = Modifier.width(6.dp))
              Text("Compartilhar", fontWeight = FontWeight.Bold)
            }

            // Visualizar
            IconButton(
              onClick = { viewModel.openBlessingDetail(card) },
              modifier = Modifier.size(42.dp)
            ) {
              Icon(Icons.Default.Fullscreen, contentDescription = "Tela Cheia", tint = MaterialTheme.colorScheme.primary)
            }
          }
        }
      }
    }
  }
}

@Composable
private fun BlessingCardDetailView(
  card: BlessingCard,
  viewModel: MainViewModel
) {
  val context = LocalContext.current
  val coroutineScope = rememberCoroutineScope()
  var isFav by remember(card.id) {
    mutableStateOf(viewModel.prefs.isBlessingFavorite(card.id))
  }

  // Pre-generate the composite photo bitmap with text embedded
  var compositeBitmap by remember { mutableStateOf<android.graphics.Bitmap?>(null) }

  LaunchedEffect(card.id) {
    withContext(Dispatchers.Default) {
      compositeBitmap = BlessingImageGenerator.generateCompositeBitmap(context, card)
    }
  }

  Box(
    modifier = Modifier
      .fillMaxSize()
      .background(Color.Black)
      .testTag("blessing_detail_view")
  ) {
    // Show rendered composite bitmap or original with live overlay
    if (compositeBitmap != null) {
      Image(
        bitmap = compositeBitmap!!.asImageBitmap(),
        contentDescription = card.title,
        contentScale = ContentScale.Fit,
        modifier = Modifier
          .fillMaxSize()
          .align(Alignment.Center)
      )
    } else {
      Image(
        painter = painterResource(id = card.imageResId),
        contentDescription = card.title,
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
      )
    }

    // Top Navigation & Actions Bar
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .statusBarsPadding()
        .padding(16.dp),
      horizontalArrangement = Arrangement.SpaceBetween,
      verticalAlignment = Alignment.CenterVertically
    ) {
      IconButton(
        onClick = { viewModel.closeBlessingDetail() },
        modifier = Modifier
          .size(44.dp)
          .clip(CircleShape)
          .background(Color.Black.copy(alpha = 0.6f))
          .testTag("close_blessing_detail")
      ) {
        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Voltar", tint = Color.White)
      }

      Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
        IconButton(
          onClick = { isFav = viewModel.toggleBlessingFavorite(card.id) },
          modifier = Modifier
            .size(44.dp)
            .clip(CircleShape)
            .background(Color.Black.copy(alpha = 0.6f))
        ) {
          Icon(
            imageVector = if (isFav) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
            contentDescription = "Favoritar",
            tint = if (isFav) Color.Red else Color.White
          )
        }
      }
    }

    // Bottom Action Bar to Save and Share the image
    Surface(
      color = Color.Black.copy(alpha = 0.85f),
      shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
      modifier = Modifier
        .fillMaxWidth()
        .align(Alignment.BottomCenter)
        .navigationBarsPadding()
    ) {
      Column(modifier = Modifier.padding(20.dp)) {
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
          // Salvar Foto na Galeria
          Button(
            onClick = {
              coroutineScope.launch {
                val bmp = compositeBitmap ?: withContext(Dispatchers.Default) {
                  BlessingImageGenerator.generateCompositeBitmap(context, card)
                }
                BlessingImageGenerator.saveBitmapToGallery(context, bmp, card.title)
              }
            },
            modifier = Modifier
              .weight(1f)
              .height(52.dp)
              .testTag("detail_save_photo_btn"),
            shape = RoundedCornerShape(14.dp),
            colors = ButtonDefaults.buttonColors(containerColor = BibleGold)
          ) {
            Icon(Icons.Default.Download, contentDescription = null, tint = BibleNavyPrimary)
            Spacer(modifier = Modifier.width(8.dp))
            Text("Salvar na Galeria", color = BibleNavyPrimary, fontWeight = FontWeight.Bold)
          }

          // Compartilhar Imagem
          Button(
            onClick = {
              coroutineScope.launch {
                val bmp = compositeBitmap ?: withContext(Dispatchers.Default) {
                  BlessingImageGenerator.generateCompositeBitmap(context, card)
                }
                BlessingImageGenerator.shareCompositeBitmap(context, bmp, card)
              }
            },
            modifier = Modifier
              .weight(1f)
              .height(52.dp)
              .testTag("detail_share_photo_btn"),
            shape = RoundedCornerShape(14.dp),
            colors = ButtonDefaults.buttonColors(containerColor = BibleNavyPrimary)
          ) {
            Icon(Icons.Default.Share, contentDescription = null, tint = BibleGold)
            Spacer(modifier = Modifier.width(8.dp))
            Text("Compartilhar", color = Color.White, fontWeight = FontWeight.Bold)
          }
        }
      }
    }
  }
}
