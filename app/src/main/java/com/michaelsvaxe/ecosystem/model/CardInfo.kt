package com.michaelsvaxe.ecosystem.model

data class CardInfo(
    var cardNumber: String? = "",
    var scheme: String? = "",
    var type: String? = "",
    var brand: String? = "",
    var prepaid: String? = "",
    var length: String? = "",
    var luhn: String? = "",
    var countryName: String? = "",
    var countryEmoji: String? = "",
    var latitude: Byte? = 0,
    var longitude: Byte? = 0,
    var bankName: String? = "",
    var bankCity: String? = "",
    var bankWebsite: String? = "",
    var bankPhone: String? = ""
)
