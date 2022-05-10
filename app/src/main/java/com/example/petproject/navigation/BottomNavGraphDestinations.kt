package com.example.petproject.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.bottomnavigation.BottomNavigationEntry
import com.example.bottomnavigation.DetailsRoute
import com.example.bottomnavigation.FavoritesRoute
import com.example.bottomnavigation.SettingsRoute
import com.example.details.DetailsUI
import com.example.favorites.FavoritesUI
import com.example.settings.SettingsUI

@OptIn
private val destinationsBottomNav: Map<BottomNavigationEntry, @Composable (NavHostController) -> Unit> =
    mapOf(
        DetailsRoute to {
            DetailsUI()
        },
        SettingsRoute to {
            SettingsUI()
        },
        FavoritesRoute to {
            FavoritesUI()
        }
    )

fun NavGraphBuilder.addBottomNavigationDestinations(navController: NavHostController) {
    destinationsBottomNav.forEach { entry ->
        val destination = entry.key
        composable(destination.route) {
            entry.value(navController)
        }
    }
}