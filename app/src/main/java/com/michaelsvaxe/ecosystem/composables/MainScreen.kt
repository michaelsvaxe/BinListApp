package com.michaelsvaxe.ecosystem.composables

import android.annotation.SuppressLint
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.navigation.NavHostController
import com.michaelsvaxe.ecosystem.network.data.CardInfo

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(
    navController: NavHostController,
    cardNumber: State<String>,
    onValueChange: (String) -> Unit,
    onClick: () -> Unit,
    cardInfo: MutableState<CardInfo>,
    explainText: MutableState<String>,
    historyList: MutableList<CardInfo>,
    deleteHistory: () -> Unit
) {
    Scaffold(
        bottomBar = {
            BottomAppBar {
                BottomNavigationBar(navController)
            }
        }
    ) {
        NavigationScreens(
            navController,
            cardNumber,
            onValueChange,
            onClick,
            cardInfo,
            explainText,
            historyList,
            deleteHistory
        )
    }
}