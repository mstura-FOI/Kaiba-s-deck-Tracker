package com.kaiba.tracker.uiComponents


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kaiba.tracker.R
import com.kaiba.tracker.data.YuGiOhCard
 var yuGiOhCard:YuGiOhCard? = null
@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun CardInfo(
    card : YuGiOhCard?
){
    Card(
        elevation  = CardDefaults.cardElevation(
            defaultElevation = 12.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xff3d3e51),
        ),
        modifier = Modifier
            .size(width = 240.dp, height = 100.dp)

    ) {
        Row(
            modifier = Modifier.fillMaxSize()
        ) {
           Column {
               Text(
                   text = if(card == null) "Nema karte" else card.name,
                   modifier = Modifier
                       .padding(16.dp),
                   textAlign = TextAlign.Center,
                   color = Color.White
               )
               Text(text = if(card == null) "Nema karte" else "Type:${card.type}",
                   modifier = Modifier.padding(16.dp,0.dp,0.dp,0.dp),
                   textAlign = TextAlign.Center,
                   color = Color.White
               )
           }
            Spacer(modifier = Modifier.padding(10.dp))
            Image(painter = painterResource(id = R.drawable.img), contentDescription = null, contentScale = ContentScale.Crop, modifier = Modifier.padding(12.dp))
        }



    }
}

@Composable
@Preview
fun CardPreview(){
    CardInfo(yuGiOhCard)
}