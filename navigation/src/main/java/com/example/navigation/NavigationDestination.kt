package com.example.navigation

import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NamedNavArgument


fun interface NavigationDestination {

    fun route(): String

    val arguments: List<NamedNavArgument>
        get() = emptyList()

    val dialogProperties: DialogProperties
        get() = DialogProperties()

}