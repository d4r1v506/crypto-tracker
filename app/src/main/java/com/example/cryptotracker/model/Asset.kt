package com.example.cryptotracker.model

data class Asset (
    val id: String,
    val name: String,
    val symbol: String,
    val price: Double,
    val percentage: Double
)