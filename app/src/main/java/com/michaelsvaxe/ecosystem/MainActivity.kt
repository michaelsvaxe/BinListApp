package com.michaelsvaxe.ecosystem

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.michaelsvaxe.ecosystem.composables.MainScreen
import com.michaelsvaxe.ecosystem.ui.theme.EcoSystemTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val cardNumber = mutableStateOf("0000 0000 0000 0000")

        setContent {
            EcoSystemTheme {
                val navController = rememberNavController()
                Surface(modifier = Modifier.fillMaxSize()) {
                    MainScreen(navController, cardNumber, onValueChange = { cardNumber.value = it })
                }
            }
        }
    }
}