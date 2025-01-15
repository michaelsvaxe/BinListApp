package com.michaelsvaxe.ecosystem

data class CardInfo(
    var scheme: String,
    var type: String,
    var brand: String,
    var prepaid: Boolean,
    var length: Byte,
    var luhn: Boolean,
    var countryName: String,
    var countryEmoji: String,
    var latitude: Short,
    var longitude: Short,
    var bankName: String,
    var bankURL: String,
    var bankPhone: String
)
