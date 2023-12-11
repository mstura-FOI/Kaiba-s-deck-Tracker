package com.kaiba.tracker

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kaiba.tracker.data.DataCard
import com.kaiba.tracker.data.YuGiOhCard
import com.kaiba.tracker.httpRequestManager.RetrofitHelper
import com.kaiba.tracker.httpRequestManager.YugiService
import com.kaiba.tracker.ui.theme.KaibasTrackerTheme
import com.kaiba.tracker.uiComponents.CardInfo
import com.kaiba.tracker.uiComponents.ScrollableList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.isActive
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            var cards by remember {
                mutableStateOf<List<YuGiOhCard?>?>(null)
            }

            LaunchedEffect(true) {

                    cards = GetCard()
                    Log.i("yugi", cards.toString())

            }
            ScrollableList(cards = cards)


          }
        }
    }



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

    Log.i("yugi","w: ${result}")

    return result
}





