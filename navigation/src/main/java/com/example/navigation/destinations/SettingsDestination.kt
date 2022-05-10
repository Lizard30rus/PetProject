package com.example.navigation.destinations

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.navigation.NavigationDestination

object SettingsDestination : NavigationDestination {

    override fun route(): String = SETTINGS_ROUTE
    override val arguments: List<NamedNavArgument>
        get() = listOf(
            navArgument(SETTINGS_PARAM) {
                type = NavType.IntType
            }
        )

    const val SETTINGS_PARAM = "settings_param"

    private const val SETTINGS_ROUTE = "settings_route"
    private const val SETTINGS_NEXT_SCREEN_ROUTE = "$SETTINGS_ROUTE/$SETTINGS_PARAM"
}