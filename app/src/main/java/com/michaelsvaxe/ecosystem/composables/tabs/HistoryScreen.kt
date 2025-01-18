package com.michaelsvaxe.ecosystem.composables.tabs

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.michaelsvaxe.ecosystem.R
import com.michaelsvaxe.ecosystem.network.data.CardInfo

@Composable
fun HistoryScreen(
    historyList: MutableList<CardInfo>,
    deleteHistory: () -> Unit
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
        items(historyList.size) {
            Card(
                elevation = CardDefaults.elevatedCardElevation(2.dp),
                colors = CardColors(Color.White, Color.Black, Color.White, Color.Blue),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(6.dp)
            ) {
                Column(
                    modifier = Modifier
                        .padding(12.dp)
                ) {
                    Row{
                        Text(
                            text = historyList[i].cardNumber.toString(),
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = historyList[i].countryEmoji.toString(),
                            modifier = Modifier
                                .padding(start = 12.dp)
                            
                        )
                    }
                    Row{
                        Text(
                            text = historyList[i].scheme.toString()
                        )
                        Text(
                            text = historyList[i].type.toString(),
                            modifier = Modifier
                                .padding(start = 12.dp)
                        )
                    }
                }
            }
            Log.d("mine", "i: $i")
            while (i < historyList.size - 1) i++
        }
        item {
            Text(
                text = stringResource(R.string.delete_history),
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                color = Color.Red,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { deleteHistory() }
                    .padding(12.dp)
            )
            Spacer(
                modifier = Modifier
                    .padding(vertical = 50.dp)
            )
        }
    }
}

