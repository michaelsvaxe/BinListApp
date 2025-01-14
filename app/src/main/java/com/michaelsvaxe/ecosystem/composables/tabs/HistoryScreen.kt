package com.michaelsvaxe.ecosystem.composables.tabs

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.michaelsvaxe.ecosystem.R

@Composable
fun HistoryScreen() {
    Text(
        text = stringResource(R.string.history)
    )
}
