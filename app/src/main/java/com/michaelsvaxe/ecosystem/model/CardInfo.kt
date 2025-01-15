package com.michaelsvaxe.ecosystem.model

data class CardInfo(
    var scheme: String? = "hello",
    var type: String? = "hi",
    var brand: String? = "hi",
    var prepaid: Boolean? = false,
    var length: Byte? = 21,
    var luhn: Boolean? = false,
    var countryName: String? = "null",
    var countryEmoji: String? = "null",
    var latitude: Byte? = -21,
    var longitude: Byte? = 12,
    var bankName: String? = "null"
)
