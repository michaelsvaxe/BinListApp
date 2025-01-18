package com.michaelsvaxe.ecosystem

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.michaelsvaxe.ecosystem.composables.MainScreen
import com.michaelsvaxe.ecosystem.network.data.CardInfo
import com.michaelsvaxe.ecosystem.ui.theme.EcoSystemTheme
import io.paperdb.Paper
import org.json.JSONObject

class MainActivity : ComponentActivity() {

    private var cardInfoInstance = CardInfo()

    private var historyList: MutableList<CardInfo>  = mutableListOf()

    private val cardNumberInput = mutableStateOf("0000 0000")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Paper.init(this)

        setContent {

            val cardInfo = remember { mutableStateOf(CardInfo()) }

            val explainText = remember { mutableStateOf(getString(R.string.bank_info_screen_explain)) }

            EcoSystemTheme {
                val navController = rememberNavController()
                Surface(modifier = Modifier.fillMaxSize()) {
                    MainScreen(
                        navController,
                        cardNumberInput,
                        { cardNumberInput.value = it },
                        { lookUp(cardNumberInput.value, this, cardInfo, explainText) },
                        cardInfo,
                        explainText,
                        historyList,
                        { deleteHistory() }
                    )
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        historyList = Paper.book().read("history", mutableListOf())!!
    }

    private fun lookUp(
        cardNumber: String,
        context: Context,
        cardInfo: MutableState<CardInfo>,
        explainText: MutableState<String>
    ) {
        val url = "https://lookup.binlist.net/$cardNumber"
        val queue = Volley.newRequestQueue(context)
        val stringRequest = StringRequest(
            Request.Method.GET,
            url,
            { response ->
                Log.d("mine", "response: $response")
                val info = getInfo(response, cardInfoInstance)
                cardInfo.value = info
                saveToHistory(cardInfoInstance)
            },
            { error ->
                Log.d("mine", "error: ${error.message}")
                explainText.value = getString(R.string.too_many_requests)
            }
        )
        queue.add(stringRequest)
    }

    private fun getInfo(response: String, cardInfo: CardInfo): CardInfo {
        if (response.isEmpty()) return CardInfo()
        val obj = JSONObject(response)

        with(cardInfoInstance) {
            cardNumber = cardNumberInput.value
            scheme = obj.getString("scheme")
            type = obj.getString("type")
            brand = obj.getString("brand")
            prepaid = "no data" // Сервер не выдаёт данные по картам Сбера. Нужно обработать ошибку
            length = "no data" // Сервер не выдаёт данные
            luhn = "no data" // Сервер не выдаёт данные
            countryName = obj.getJSONObject("country").getString("name")
            countryEmoji = obj.getJSONObject("country").getString("emoji")
            latitude = obj.getJSONObject("country").getInt("latitude").toByte()
            longitude = obj.getJSONObject("country").getInt("longitude").toByte()
            bankName = obj.getJSONObject("bank").getString("name")
            bankWebsite = "no data" // Сервер не выдаёт данные
            bankPhone = "no data" // Сервер не выдаёт данные
        }
        return cardInfo
    }

    private fun saveToHistory(info: CardInfo) {
        historyList.add(info)
        Paper.book().write("history", historyList)
        Log.d("mine", "history: $historyList")
    }

    private fun deleteHistory() {
        historyList.clear()
        Paper.book().write("history", historyList)
        Log.d("mine", "history: $historyList")
    }
}