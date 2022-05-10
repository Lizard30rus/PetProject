package com.example.bottomnavigation


sealed class BottomNavigationEntry(val route : String, val name : String) {
    companion object {
        const val SETTINGS = "settings"
        const val FAVORITES = "favorites"
        const val DETAILS = "details"
    }
}
