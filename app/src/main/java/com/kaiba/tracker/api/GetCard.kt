package com.kaiba.tracker.api

import android.annotation.SuppressLint
import android.util.Log
import com.kaiba.tracker.data.YuGiOhCard
import com.kaiba.tracker.httpRequestManager.RetrofitHelper
import com.kaiba.tracker.httpRequestManager.YugiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@SuppressLint("SuspiciousIndentation")
suspend fun GetCard(): List<YuGiOhCard?>? {
    var result: List<YuGiOhCard?>? = null


    withContext(Dispatchers.IO) {
        val cards = RetrofitHelper.getInstance().create(YugiService::class.java)
        val response = cards.getCards()

        if (response != null) {
            result = response.body()!!.data

        } else {
            result = null
        }
    }

    Log.i("yugi", "w: ${result}")

    return result
}
suspend fun GetCards(name: String): List<YuGiOhCard?>? {
    var result: List<YuGiOhCard?>? = null


    withContext(Dispatchers.IO) {
        val cards = RetrofitHelper.getInstance().create(YugiService::class.java)
        val response = cards.getCard(name)

        if (response != null) {
            result = response.body()?.data

        } else {
            result = null
        }
    }

    Log.i("yugi", "w: ${result}")

    return result
}