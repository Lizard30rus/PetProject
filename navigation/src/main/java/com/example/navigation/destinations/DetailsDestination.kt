package com.example.navigation.destinations

import com.example.navigation.NavigationDestination

object DetailsDestination : NavigationDestination {

    override fun route(): String = DETAILS_ROUTE

    private const val DETAILS_ROUTE = "details_route"
}