package com.michaelsvaxe.ecosystem.composables

import android.annotation.SuppressLint
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.navigation.NavHostController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(
    navController: NavHostController,
    cardNumber: State<String>,
    onValueChange: (String) -> Unit
) {
    Scaffold(
        bottomBar = {
            BottomAppBar {
                BottomNavigationBar(navController)
            }
        }
    ) {
        NavigationScreens(navController, cardNumber, onValueChange)
    }
}