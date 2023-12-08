package com.kaiba.tracker

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import com.kaiba.tracker.data.DataCard
import com.kaiba.tracker.data.YuGiOhCard
import com.kaiba.tracker.httpRequestManager.RetrofitHelper
import com.kaiba.tracker.httpRequestManager.YugiService
import com.kaiba.tracker.ui.theme.KaibasTrackerTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            var card by remember {
                mutableStateOf<YuGiOhCard?>(null)
            }

            LaunchedEffect(true) {
               var card = GetCard()
            }

          }
        }
    }



@SuppressLint("SuspiciousIndentation")
suspend fun GetCard(): YuGiOhCard? {
    var result: YuGiOhCard? = null


          withContext(Dispatchers.IO) {
            val cards = RetrofitHelper.getInstance().create(YugiService::class.java)
            val response = cards.getCard("Dark Magician")

            if (response != null) {
               result = response.body()!!.data[0]

            } else {
               result = null
            }
        }



    return result
}





