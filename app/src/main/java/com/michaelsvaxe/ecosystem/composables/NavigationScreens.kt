package com.michaelsvaxe.ecosystem.composables

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.michaelsvaxe.ecosystem.composables.tabs.AboutScreen
import com.michaelsvaxe.ecosystem.composables.tabs.HistoryScreen
import com.michaelsvaxe.ecosystem.navigation.NavItem
import com.michaelsvaxe.ecosystem.composables.tabs.HomeScreen

@Composable
fun NavigationScreens(
    navController: NavHostController
) {
    NavHost(navController, startDestination = NavItem.Home.path) {
        composable(NavItem.Home.path) { HomeScreen() }
        composable(NavItem.About.path) { AboutScreen() }
        composable(NavItem.History.path) { HistoryScreen() }
    }
}