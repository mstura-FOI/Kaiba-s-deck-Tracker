package com.kaiba.tracker.httpRequestManager

import com.kaiba.tracker.data.DataCard
import com.kaiba.tracker.data.YuGiOhCard
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
interface YugiService {
    @GET("api/v7/cardinfo.php")
    suspend fun getCards() : Response<DataCard>
    @GET("api/v7/cardinfo.php")
    suspend fun getCard(@Query("name") name:String) : Response<DataCard>
}

