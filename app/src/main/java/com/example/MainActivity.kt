package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.example.ui.BlessingsScreen
import com.example.ui.DevotionalScreen
import com.example.ui.HomeScreen
import com.example.ui.HymnsScreen
import com.example.ui.QuizScreen
import com.example.ui.theme.BibleGold
import com.example.ui.theme.BibleNavyPrimary
import com.example.ui.theme.MyApplicationTheme
import com.example.viewmodel.AppScreen
import com.example.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {

  private val viewModel: MainViewModel by viewModels()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      MyApplicationTheme {
        MainAppContent(viewModel = viewModel)
      }
    }
  }
}

@Composable
fun MainAppContent(viewModel: MainViewModel) {
  val currentScreen by viewModel.currentScreen.collectAsState()

  // Handle system back button to return to Home if on another tab
  if (currentScreen != AppScreen.HOME) {
    BackHandler {
      viewModel.navigateTo(AppScreen.HOME)
    }
  }

  Scaffold(
    modifier = Modifier.fillMaxSize(),
    contentWindowInsets = WindowInsets.safeDrawing,
    bottomBar = {
      AppBottomNavigationBar(
        currentScreen = currentScreen,
        onNavigate = { viewModel.navigateTo(it) }
      )
    }
  ) { innerPadding ->
    Box(
      modifier = Modifier
        .fillMaxSize()
        .padding(innerPadding)
    ) {
      AnimatedContent(
        targetState = currentScreen,
        transitionSpec = { fadeIn() togetherWith fadeOut() },
        label = "screen_transition"
      ) { screen ->
        when (screen) {
          AppScreen.HOME -> HomeScreen(viewModel = viewModel)
          AppScreen.QUIZ -> QuizScreen(viewModel = viewModel)
          AppScreen.DEVOTIONAL -> DevotionalScreen(viewModel = viewModel)
          AppScreen.HYMNS -> HymnsScreen(viewModel = viewModel)
          AppScreen.MESSAGES -> BlessingsScreen(viewModel = viewModel)
        }
      }
    }
  }
}

data class NavItem(
  val screen: AppScreen,
  val label: String,
  val icon: ImageVector,
  val testTag: String
)

@Composable
fun AppBottomNavigationBar(
  currentScreen: AppScreen,
  onNavigate: (AppScreen) -> Unit
) {
  val items = listOf(
    NavItem(AppScreen.HOME, "Início", Icons.Default.Home, "nav_home"),
    NavItem(AppScreen.QUIZ, "Quiz", Icons.Default.Quiz, "nav_quiz"),
    NavItem(AppScreen.DEVOTIONAL, "Palavra", Icons.Default.MenuBook, "nav_devotional"),
    NavItem(AppScreen.HYMNS, "Hinos CCB", Icons.Default.MusicNote, "nav_hymns"),
    NavItem(AppScreen.MESSAGES, "Mensagens", Icons.Default.Image, "nav_messages")
  )

  NavigationBar(
    modifier = Modifier
      .windowInsetsPadding(WindowInsets.navigationBars)
      .testTag("bottom_nav_bar"),
    containerColor = MaterialTheme.colorScheme.surface,
    tonalElevation = 6.dp
  ) {
    items.forEach { item ->
      val selected = currentScreen == item.screen
      NavigationBarItem(
        selected = selected,
        onClick = { onNavigate(item.screen) },
        icon = {
          Icon(
            imageVector = item.icon,
            contentDescription = item.label
          )
        },
        label = {
          Text(
            text = item.label,
            style = MaterialTheme.typography.labelSmall
          )
        },
        colors = NavigationBarItemDefaults.colors(
          selectedIconColor = BibleGold,
          selectedTextColor = BibleNavyPrimary,
          indicatorColor = BibleGold.copy(alpha = 0.2f),
          unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
          unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant
        ),
        modifier = Modifier.testTag(item.testTag)
      )
    }
  }
}
