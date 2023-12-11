package com.kaiba.tracker

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
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
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher

class MainActivity : ComponentActivity() {
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            var cards by remember {
                mutableStateOf<List<YuGiOhCard?>?>(null)
            }
            var currentProgress by remember { mutableStateOf(0f) }
            var loading by remember { mutableStateOf(true) }
            val scope = rememberCoroutineScope()

            scope.launch{
                cards = GetCard()
                loading = false
            }
            if (loading){
                Column(modifier = Modifier.fillMaxSize().padding(24.dp)
                , verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                    CircularProgressIndicator(
                        modifier = Modifier.width(64.dp),
                        color = Color.DarkGray,

                        )
                    Spacer(modifier = Modifier.padding(0.dp,24.dp))
                    Text(text = stringResource(id = R.string.loading), fontWeight = FontWeight.Bold)
            }

            }else{

                ScrollableList(cards = cards){card->
                    Log.i("card",card.toString())
                    if (card != null) {
                        // Do something with the clicked card
                        Log.d("CardClick", "Clicked on card: ${card.name}")
                    }
                }
            }





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





