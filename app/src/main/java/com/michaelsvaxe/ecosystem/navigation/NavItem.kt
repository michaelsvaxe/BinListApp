package com.michaelsvaxe.ecosystem.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info


sealed class NavItem {
    object Home : Item(path = NavPath.HOME.toString(), title = NavTitle.HOME, icon = Icons.Default.Home)
    object History: Item(path = NavPath.HISTORY.toString(), title = NavTitle.HISTORY, icon = Icons.Default.DateRange)
    object About: Item(path = NavPath.ABOUT.toString(), title = NavTitle.ABOUT, icon = Icons.Default.Info)
}