package dev.filin2hat.composedestinatioswithnavgraph.screen.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.popUpTo
import dev.filin2hat.composedestinatioswithnavgraph.screen.NavGraphs
import dev.filin2hat.composedestinatioswithnavgraph.screen.appCurrentDestinationAsState
import dev.filin2hat.composedestinatioswithnavgraph.screen.destinations.AuthScreenDestination
import dev.filin2hat.composedestinatioswithnavgraph.screen.destinations.HomeScreenDestination
import dev.filin2hat.composedestinatioswithnavgraph.screen.home.bottom.BottomBarDestination
import dev.filin2hat.composedestinatioswithnavgraph.screen.startAppDestination

@OptIn(ExperimentalMaterial3Api::class)
@RootNavGraph
@Destination
@Composable
fun HomeScreen(
    navigator: DestinationsNavigator
) {
    val navController = rememberNavController()
    var title by remember { mutableStateOf("") }

    // Обновление title при переключении экранов
    val currentDestination = navController.appCurrentDestinationAsState().value?.route
    BottomBarDestination.entries.forEach { destination ->
        if (currentDestination == destination.direction) {
            title = stringResource(destination.label)
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = title) },
                actions = {
                    IconButton(onClick = {
                        navigator.navigate(AuthScreenDestination) {
                            popUpTo(HomeScreenDestination) { inclusive = true }
                        }
                    }) {
                        Icon(Icons.AutoMirrored.Filled.ExitToApp, contentDescription = "")
                    }
                }
            )
        },
        bottomBar = { BottomBar(navController) }
    ) { paddingValues ->
        DestinationsNavHost(
            navController = navController,
            navGraph = NavGraphs.home,
            modifier = Modifier.padding(paddingValues)
        )
    }
}

@Composable
fun BottomBar(
    navController: NavController
) {
    val currentDestination = navController.appCurrentDestinationAsState().value?.route
        ?: NavGraphs.root.startAppDestination

    NavigationBar {
        BottomBarDestination.entries.forEach { destination ->
            NavigationBarItem(
                selected = currentDestination == destination.direction,
                onClick = {
                    navController.popBackStack(currentDestination.toString(), true)
                    navController.navigate(destination.direction) {
                        popUpTo(NavGraphs.home) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = { Icon(destination.icon, contentDescription = stringResource(destination.label)) },
                label = { Text(stringResource(destination.label)) },
            )
        }
    }
}
