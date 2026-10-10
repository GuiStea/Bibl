package com.example.data

import android.content.Context
import android.content.SharedPreferences

class AppPreferences(context: Context) {
  private val prefs: SharedPreferences =
    context.getSharedPreferences("biblia_louvor_prefs", Context.MODE_PRIVATE)

  var totalQuizzesPlayed: Int
    get() = prefs.getInt("total_quizzes", 0)
    set(value) = prefs.edit().putInt("total_quizzes", value).apply()

  var bestScore: Int
    get() = prefs.getInt("best_score", 0)
    set(value) = prefs.edit().putInt("best_score", value).apply()

  var totalCorrectAnswers: Int
    get() = prefs.getInt("total_correct", 0)
    set(value) = prefs.edit().putInt("total_correct", value).apply()

  fun isHymnFavorite(number: Int): Boolean {
    val set = prefs.getStringSet("fav_hymns", emptySet()) ?: emptySet()
    return set.contains(number.toString())
  }

  fun toggleHymnFavorite(number: Int): Boolean {
    val set = (prefs.getStringSet("fav_hymns", emptySet()) ?: emptySet()).toMutableSet()
    val isFav = if (set.contains(number.toString())) {
      set.remove(number.toString())
      false
    } else {
      set.add(number.toString())
      true
    }
    prefs.edit().putStringSet("fav_hymns", set).apply()
    return isFav
  }

  fun isDevotionalFavorite(id: Int): Boolean {
    val set = prefs.getStringSet("fav_devotionals", emptySet()) ?: emptySet()
    return set.contains(id.toString())
  }

  fun toggleDevotionalFavorite(id: Int): Boolean {
    val set = (prefs.getStringSet("fav_devotionals", emptySet()) ?: emptySet()).toMutableSet()
    val isFav = if (set.contains(id.toString())) {
      set.remove(id.toString())
      false
    } else {
      set.add(id.toString())
      true
    }
    prefs.edit().putStringSet("fav_devotionals", set).apply()
    return isFav
  }

  fun isDevotionalRead(id: Int): Boolean {
    val set = prefs.getStringSet("read_devotionals", emptySet()) ?: emptySet()
    return set.contains(id.toString())
  }

  fun markDevotionalRead(id: Int, isRead: Boolean = true) {
    val set = (prefs.getStringSet("read_devotionals", emptySet()) ?: emptySet()).toMutableSet()
    if (isRead) set.add(id.toString()) else set.remove(id.toString())
    prefs.edit().putStringSet("read_devotionals", set).apply()
  }

  fun isBlessingFavorite(id: Int): Boolean {
    val set = prefs.getStringSet("fav_blessings", emptySet()) ?: emptySet()
    return set.contains(id.toString())
  }

  fun toggleBlessingFavorite(id: Int): Boolean {
    val set = (prefs.getStringSet("fav_blessings", emptySet()) ?: emptySet()).toMutableSet()
    val isFav = if (set.contains(id.toString())) {
      set.remove(id.toString())
      false
    } else {
      set.add(id.toString())
      true
    }
    prefs.edit().putStringSet("fav_blessings", set).apply()
    return isFav
  }
}
