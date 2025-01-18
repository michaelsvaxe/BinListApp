package com.michaelsvaxe.ecosystem.composables

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.michaelsvaxe.ecosystem.composables.tabs.AboutScreen
import com.michaelsvaxe.ecosystem.composables.tabs.HistoryScreen
import com.michaelsvaxe.ecosystem.navigation.NavItem
import com.michaelsvaxe.ecosystem.composables.tabs.HomeScreen
import com.michaelsvaxe.ecosystem.network.data.CardInfo

@Composable
fun NavigationScreens(
    navController: NavHostController,
    cardNumber: State<String>,
    onValueChange: (String) -> Unit,
    onClick: () -> Unit,
    cardInfo: MutableState<CardInfo>,
    explainText: MutableState<String>,
    historyList: MutableList<CardInfo>,
    deleteHistory: () -> Unit
) {
    NavHost(navController, startDestination = NavItem.Home.path) {
        composable(NavItem.About.path) { AboutScreen() }
        composable(NavItem.Home.path) { HomeScreen(cardNumber, onValueChange, onClick, cardInfo, explainText) }
        composable(NavItem.History.path) { HistoryScreen(historyList, deleteHistory) }
    }
}