package com.kaiba.tracker.uiComponents

import android.util.Log
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import com.kaiba.tracker.api.GetCard
import com.kaiba.tracker.api.GetCards
import com.kaiba.tracker.data.YuGiOhCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardSearch(cards:List<YuGiOhCard?>?,onSearch: (List<YuGiOhCard?>)->Unit) {
    var text by remember { mutableStateOf("") }
    var cards by remember { mutableStateOf<List<YuGiOhCard?>?>(cards) }
    LaunchedEffect(text){
        if(text == ""){
            cards = GetCard()
        }else {
            cards =  GetCards(text)
        }


    }
    TextField(
        value = text,
        onValueChange = { text = it



        },
        label = { Text("Card Search") },
        placeholder = { Text("Enter a card name")}
    )
    ScrollableList(cards = cards){card->
        Log.i("card",card.toString())
        if (card != null) {
            // Do something with the clicked card
            Log.d("CardClick", "Clicked on card: ${card.name}")
        }
    }
}