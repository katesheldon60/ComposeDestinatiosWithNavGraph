package dev.filin2hat.composedestinatioswithnavgraph.screen.home.bottom

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import dev.filin2hat.composedestinatioswithnavgraph.navigation.AppNavGraph

@AppNavGraph
@Destination
@Composable
fun CalendarScreen(
    id: String?,
    navigator: DestinationsNavigator
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Calendar")
    }
}
