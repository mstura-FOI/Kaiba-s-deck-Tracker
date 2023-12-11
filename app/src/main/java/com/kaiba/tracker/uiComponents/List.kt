package com.kaiba.tracker.uiComponents

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kaiba.tracker.data.YuGiOhCard

@Composable
fun ScrollableList(
    cards: List<YuGiOhCard?>?,
    onItemClick: (YuGiOhCard?) -> Unit
) {
    LazyColumn(modifier = Modifier.fillMaxWidth().padding(12.dp)) {
        if (cards != null) {
            items(cards) { card ->
                CardInfo(
                    card = card,
                    modifier = Modifier
                        .clickable {
                            onItemClick(card)
                        }
                        .padding(8.dp)

                    )
            }
        }
    }
}
