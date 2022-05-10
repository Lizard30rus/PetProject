package com.example.petproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.bottomnavigation.DetailsRoute
import com.example.bottomnavigation.bottomNavigationEntries
import com.example.navigation.Navigator
import com.example.navigation.NavigatorEvent
import com.example.petproject.navigation.addBottomNavigationDestinations
import com.example.petproject.ui.theme.PetProjectTheme
import com.example.petproject.ui.theme.Shapes
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    @Inject
    lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PetProjectTheme {
                Surface(color = MaterialTheme.colors.background) {
                    PetProjectScaffold(navigator)
                }
            }
        }
    }
}

@Composable
fun PetProjectScaffold(navigator: Navigator) {
    val navController = rememberNavController()
    LaunchedEffect(navController) {
        navigator.destinations.collect {
            when (val event = it) {
                is NavigatorEvent.NavigateUp -> {
                    navController.navigateUp()
                }
                is NavigatorEvent.Directions -> {
                    navController.navigate(
                        event.destination,
                        event.builder
                    )
                }
                NavigatorEvent.PopBackStack -> {
                    navController.popBackStack()
                }
            }
        }
    }
    Scaffold(
        bottomBar = {
            PetProjectBottomBar(navController = navController)
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = DetailsRoute.route,
            modifier = Modifier.padding(paddingValues = it)
        ) {
            addBottomNavigationDestinations(navController)
        }
    }
}

@Composable
fun PetProjectBottomBar(
    navController: NavHostController
) {
    val navBackStackEntry by
    navController.currentBackStackEntryAsState()

    val currentRoute = navBackStackEntry?.destination?.route

    BottomNavigation {
        bottomNavigationEntries.forEach {
            BottomNavigationItem(
                selected = currentRoute == it.screen.route,
                onClick = {
                    navController.navigate(it.screen.route) {
                        restoreState = true
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                    }
                },
                label = {
                    Text(
                        text = it.screen.name,
                        modifier = Modifier.wrapContentSize(unbounded = true),
                        maxLines = 1,
                        textAlign = TextAlign.Center
                    )
                },
                icon = {
                    Icon(
                        imageVector = it.icon,
                        contentDescription = it.screen.name
                    )
                }
            )
        }
    }
}