package com.kaiba.tracker.httpRequestManager

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
object RetrofitHelper {
    val baseUrl = "https://db.ygoprodeck.com/"
    fun getInstance() : Retrofit{
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}