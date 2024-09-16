package com.example.cryptotracker.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val BASE_RUL = //"https://api.coincap.io/v2/"
   "https://4e4fc2c0-1ffe-4bab-8f91-93eff6b286e4.mock.pstmn.io/v2/"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_RUL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val assetsService: AssetsService by lazy{
        retrofit.create(AssetsService::class.java)
    }
}