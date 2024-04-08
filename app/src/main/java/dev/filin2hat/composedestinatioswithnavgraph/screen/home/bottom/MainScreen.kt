package dev.filin2hat.composedestinatioswithnavgraph.screen.home.bottom

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import dev.filin2hat.composedestinatioswithnavgraph.model.User
import dev.filin2hat.composedestinatioswithnavgraph.navigation.AppNavGraph
import dev.filin2hat.composedestinatioswithnavgraph.screen.destinations.ContentScreenDestination
import java.time.LocalDateTime

@AppNavGraph(start = true)
@Destination
@Composable
fun MainScreen(
    navigator: DestinationsNavigator,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Main Screen")
        Spacer(modifier = Modifier.height(32.dp))
        Button(onClick = {
            navigator.navigate(ContentScreenDestination(
                User(
                    id = "2654584",
                    name = "John Doe",
                    createdAt = LocalDateTime.now()
                )
            ))
        }) {
            Text(text = "Go to Content Screen")
        }
    }
}
