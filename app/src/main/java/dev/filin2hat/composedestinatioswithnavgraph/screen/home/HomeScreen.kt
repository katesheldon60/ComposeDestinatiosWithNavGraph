package dev.filin2hat.composedestinatioswithnavgraph.screen.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.popUpTo
import dev.filin2hat.composedestinatioswithnavgraph.navigation.BottomBarDestination
import dev.filin2hat.composedestinatioswithnavgraph.screen.NavGraphs
import dev.filin2hat.composedestinatioswithnavgraph.screen.appCurrentDestinationAsState
import dev.filin2hat.composedestinatioswithnavgraph.screen.destinations.AuthScreenDestination
import dev.filin2hat.composedestinatioswithnavgraph.screen.destinations.HomeScreenDestination

@OptIn(ExperimentalMaterial3Api::class)
@Destination
@Composable
fun HomeScreen(
    navigator: DestinationsNavigator
) {
    val navController = rememberNavController()
    var title by remember { mutableStateOf("") }
    val currentDestination = navController.appCurrentDestinationAsState().value?.route

    BottomBarDestination.entries.forEach { destination ->
        if (currentDestination == destination.direction.toString()) {
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
            navGraph = NavGraphs.app,
            modifier = Modifier.padding(paddingValues)
        )
    }
}

@Composable
fun BottomBar(
    navController: NavHostController
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar {
        BottomBarDestination.entries.forEach { destination ->
            NavigationBarItem(
                selected = currentDestination?.hierarchy?.any {
                    it.route == destination.direction
                } == true,
                onClick = {
                    navController.navigate(destination.direction) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        destination.icon,
                        contentDescription = stringResource(destination.label)
                    )
                },
                label = { Text(stringResource(destination.label)) },
            )
        }
    }
}
