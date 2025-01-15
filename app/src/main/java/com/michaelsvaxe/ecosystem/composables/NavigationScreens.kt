package com.michaelsvaxe.ecosystem.composables

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.michaelsvaxe.ecosystem.composables.tabs.AboutScreen
import com.michaelsvaxe.ecosystem.composables.tabs.HistoryScreen
import com.michaelsvaxe.ecosystem.navigation.NavItem
import com.michaelsvaxe.ecosystem.composables.tabs.HomeScreen

@Composable
fun NavigationScreens(
    navController: NavHostController,
    cardNumber: State<String>,
    onValueChange: (String) -> Unit
) {
    NavHost(navController, startDestination = NavItem.Home.path) {
        composable(NavItem.About.path) { AboutScreen() }
        composable(NavItem.Home.path) { HomeScreen(cardNumber, onValueChange) }
        composable(NavItem.History.path) { HistoryScreen() }
    }
}