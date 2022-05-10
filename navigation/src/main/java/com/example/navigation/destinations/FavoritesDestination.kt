package com.example.navigation.destinations

import com.example.navigation.NavigationDestination

object FavoritesDestination: NavigationDestination {

    override fun route(): String = FAVORITES_ROUTE

    private const val FAVORITES_ROUTE = "favorites_route"
}