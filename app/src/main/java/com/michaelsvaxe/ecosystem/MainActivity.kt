package com.michaelsvaxe.ecosystem

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.michaelsvaxe.ecosystem.composables.MainScreen
import com.michaelsvaxe.ecosystem.model.CardInfo
import com.michaelsvaxe.ecosystem.network.Service
import com.michaelsvaxe.ecosystem.ui.theme.EcoSystemTheme
import org.json.JSONObject

class MainActivity : ComponentActivity() {

    val cardInfo = CardInfo()

    val service: Service = Service()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val cardNumber = mutableStateOf("0000 0000")

        setContent {
            EcoSystemTheme {
                val navController = rememberNavController()
                Surface(modifier = Modifier.fillMaxSize()) {
                    MainScreen(
                        navController,
                        cardNumber,
                        onValueChange = { cardNumber.value = it },
                        onClick = { lookUp(cardNumber.value, this) })
                }
            }
        }
    }

    private fun lookUp(cardNumber: String, context: Context) {
        val url = "https://lookup.binlist.net/$cardNumber"
        val queue = Volley.newRequestQueue(context)
        val stringRequest = StringRequest(
            Request.Method.GET,
            url,
            { response ->
                val obj = JSONObject(response)
                Log.d("mine", "obj: $obj")
                val cardInfo = CardInfo(
                    obj.getString("scheme"),
                    "sdf",
                    "sdf",
                    false,
                    1,
                    false,
                    "",
                    "",
                    1,
                    1,
                    ""
                )
            },
            { error ->
                Log.d("mine", "error: ${error.message}")
            }
        )
        queue.add(stringRequest)
    }

    private fun getData() {

    }

}