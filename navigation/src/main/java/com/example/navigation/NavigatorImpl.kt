package com.example.navigation

import androidx.navigation.NavOptionsBuilder
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NavigatorImpl @Inject constructor() : Navigator {


    private val navigationEvents = Channel<NavigatorEvent>()

    override val destinations = navigationEvents.receiveAsFlow()
    override fun navigateUp(): Boolean {
        return navigationEvents.trySend(NavigatorEvent.NavigateUp).isSuccess
    }

    override fun popBackStack() {
        navigationEvents.trySend(NavigatorEvent.PopBackStack)
    }

    override fun navigate(route: String, builder: NavOptionsBuilder.() -> Unit): Boolean {
        return navigationEvents.trySend(NavigatorEvent.Directions(route, builder)).isSuccess
    }

}