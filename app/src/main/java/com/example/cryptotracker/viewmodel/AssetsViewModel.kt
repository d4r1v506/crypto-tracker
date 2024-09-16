package com.example.cryptotracker.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptotracker.data.AssetsRepository
import com.example.cryptotracker.model.Asset
import kotlinx.coroutines.launch

class AssetsViewModel : ViewModel() {
    private val assetsRepository = AssetsRepository()

    var assets = mutableStateListOf<Asset>()
    fun fetchAssets() {
        viewModelScope.launch {
            try {
                val response = assetsRepository.getAssets().data
                val assetsResponse = response.map { assetResponse ->
                    val price = assetResponse.priceUsd.format("%2f").toDouble()
                    val percentage =
                        assetResponse.changePercent24Hr?.format("%.2f")?.toDouble() ?: 0.0
                    Asset(
                        assetResponse.id,
                        assetResponse.name,
                        assetResponse.symbol,
                        price,
                        percentage
                    )
                }
                assets.addAll(assetsResponse)
            } catch (e: Exception) {
                Log.e("FetchAssets", e.message.toString())

            }
        }
    }
}