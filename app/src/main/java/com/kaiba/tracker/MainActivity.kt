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
import androidx.compose.material3.Text
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
import androidx.compose.ui.unit.dp
import com.kaiba.tracker.api.GetCard
import com.kaiba.tracker.api.GetCards
import com.kaiba.tracker.data.YuGiOhCard
import com.kaiba.tracker.uiComponents.CardSearch
import com.kaiba.tracker.uiComponents.LoadingMainPage
import com.kaiba.tracker.uiComponents.ScrollableList
import kotlinx.coroutines.launch

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
                LoadingMainPage()
            }else{
                Column(modifier = Modifier.padding(12.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                    CardSearch(cards){searchedCards->
                    }
                }
            }
          }
        }
    }





