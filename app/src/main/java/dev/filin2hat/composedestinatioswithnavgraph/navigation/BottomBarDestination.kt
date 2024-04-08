package dev.filin2hat.composedestinatioswithnavgraph.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import dev.filin2hat.composedestinatioswithnavgraph.R
import dev.filin2hat.composedestinatioswithnavgraph.screen.destinations.CalendarScreenDestination
import dev.filin2hat.composedestinatioswithnavgraph.screen.destinations.ContactsScreenDestination
import dev.filin2hat.composedestinatioswithnavgraph.screen.destinations.DocumentsScreenDestination
import dev.filin2hat.composedestinatioswithnavgraph.screen.destinations.MainScreenDestination

enum class BottomBarDestination(
    val direction: String,
    val icon: ImageVector,
    @StringRes val label: Int
) {
    Main(
        direction = MainScreenDestination.route,
        icon = Icons.Filled.Home,
        label = R.string.main_screen,
    ),
    Calendar(
        direction = CalendarScreenDestination.route,
        icon = Icons.Default.Edit,
        label = R.string.calendar_screen
    ),
    Contacts(
        direction = ContactsScreenDestination.route,
        icon = Icons.Default.Person,
        label = R.string.contacts_screen
    ),
    Documents(
        direction = DocumentsScreenDestination.route,
        icon = Icons.Default.Call,
        label = R.string.documents_screen
    ),
}
