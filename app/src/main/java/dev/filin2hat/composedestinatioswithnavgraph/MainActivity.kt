package dev.filin2hat.composedestinatioswithnavgraph

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.ramcosta.composedestinations.DestinationsNavHost
import dev.filin2hat.composedestinatioswithnavgraph.screen.NavGraphs
import dev.filin2hat.composedestinatioswithnavgraph.ui.theme.ComposeDestinatiosWithNavGraphTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDestinatiosWithNavGraphTheme {
                val navController = rememberNavController()

                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    DestinationsNavHost(navController = navController, navGraph = NavGraphs.root)
                }
            }
        }
    }
}
