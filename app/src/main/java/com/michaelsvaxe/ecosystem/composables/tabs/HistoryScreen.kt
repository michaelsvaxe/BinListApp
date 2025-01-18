package com.michaelsvaxe.ecosystem.composables.tabs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.michaelsvaxe.ecosystem.R
import com.michaelsvaxe.ecosystem.model.CardInfo

@Composable
fun HistoryScreen(
    historyList: MutableState<MutableList<CardInfo>>
) {
    LazyColumn(
        contentPadding = PaddingValues(12.dp),
        modifier = Modifier
            .fillMaxSize()
    ) {
        var i = 0
        item{
            Text(
                text = stringResource(R.string.history),
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(6.dp)
                    .fillMaxWidth()
            )
        }
        items(historyList.value.size) {
            Card(
                elevation = CardDefaults.elevatedCardElevation(2.dp),
                colors = CardColors(Color.White, Color.Black, Color.White, Color.Blue),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(6.dp)
            ) {
                Column {
                    Text(
                        text = historyList.value[i].cardNumber.toString(),
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = historyList.value[i].scheme.toString(),
                        modifier = Modifier
                            .padding(start = 12.dp)
                    )
                    Text(
                        text = historyList.value[i].type.toString(),
                    )
                }
            }
            while (i < historyList.value.size - 1) i++
        }
    }
}

