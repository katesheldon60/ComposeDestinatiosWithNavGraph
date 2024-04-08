package dev.filin2hat.composedestinatioswithnavgraph.screen.content

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
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import dev.filin2hat.composedestinatioswithnavgraph.model.User
import dev.filin2hat.composedestinatioswithnavgraph.navigation.AppNavGraph

@AppNavGraph
@Destination
@Composable
fun ContentScreen(
    user: User,
    navigator: DestinationsNavigator
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "${user.id}\n${user.name}\n${user.createdAt}")
        Spacer(modifier = Modifier.height(32.dp))
        Button(onClick = {
            navigator.popBackStack()
        }) {
            Text(text = "Go back")
        }
    }
}
