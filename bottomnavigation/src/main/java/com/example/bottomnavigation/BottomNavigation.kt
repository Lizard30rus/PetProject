package com.example.bottomnavigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings

object DetailsRoute : BottomNavigationEntry(DETAILS, "Details")
object SettingsRoute : BottomNavigationEntry(SETTINGS, "Settings")
object FavoritesRoute : BottomNavigationEntry(FAVORITES, "Favorites")

val bottomNavigationEntries =
    listOf(
        BottomNavigationUIEntry(
            DetailsRoute,
            Icons.Filled.List
        ),
        BottomNavigationUIEntry(
            SettingsRoute,
            Icons.Filled.Settings
        ),
        BottomNavigationUIEntry(
            FavoritesRoute,
            Icons.Filled.Favorite
        )
    )