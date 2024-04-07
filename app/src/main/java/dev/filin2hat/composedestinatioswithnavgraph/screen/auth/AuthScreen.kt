package dev.filin2hat.composedestinatioswithnavgraph.screen.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.popUpTo
import dev.filin2hat.composedestinatioswithnavgraph.screen.NavGraphs
import dev.filin2hat.composedestinatioswithnavgraph.screen.destinations.HomeScreenDestination


@RootNavGraph(start = true)
@Destination
@Composable
fun AuthScreen(
    navigator: DestinationsNavigator
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
    ) {
        Text(text = "AuthScreen", color = Color.White)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            navigator.navigate(HomeScreenDestination) {
                popUpTo(NavGraphs.root.startRoute) { inclusive = true }
            }
        }) {
            Text(text = "Login")
        }
    }
}
