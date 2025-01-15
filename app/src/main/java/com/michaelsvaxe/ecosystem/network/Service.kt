package com.michaelsvaxe.ecosystem.network

import Api
import android.util.Log
import com.michaelsvaxe.ecosystem.model.CardInfo

class Service {
    private val retrofit = RetrofitClient.getClient()
    private val api = retrofit.create(Api::class.java)

    fun successfulResponse(cardNumber: String) {
        val response = api.getData(cardNumber).execute()

        val successful = response.isSuccessful
        val httpStatusCode = response.code()
        val httpStatusMessage = response.message()
        val body: CardInfo? = response.body()
        val errorBody = response.errorBody()
        val headers = response.headers()
        val customHeaderValue = headers["custom-header"]

        Log.d("mine", "body: $body")
    }
}