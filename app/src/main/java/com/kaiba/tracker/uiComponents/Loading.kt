package com.kaiba.tracker.uiComponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.kaiba.tracker.R

@Composable
fun LoadingMainPage(){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(24.dp)
        ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://images.ygoprodeck.com/images/cards_cropped/89631146.jpg")
                .crossfade(true)
                .build(),
            placeholder = painterResource(R.drawable.baseline_incomplete_circle_24),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.padding(12.dp)
        )
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(24.dp)
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
}
