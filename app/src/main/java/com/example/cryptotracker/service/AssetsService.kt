package com.example.cryptotracker.service

import com.example.cryptotracker.model.AssetsResponse
import retrofit2.http.GET

interface AssetsService {
    @GET("assets")
    suspend fun getAssets(): AssetsResponse

    /*  @POST("path")
      suspend fun example(body): AssetsResponse*/
}

//ProductService
//CartService
//UserService