package com.michaelsvaxe.ecosystem.composables.tabs

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.michaelsvaxe.ecosystem.R

@Composable
fun AboutScreen() {
    Column {
        Text(
            text = stringResource(R.string.about_title),
            fontSize = 26.sp
        )
        Text(
            text = stringResource(R.string.about_text),
            fontSize = 18.sp
        )
        Text(
            text = stringResource(R.string.bin_title),
            fontSize = 26.sp
        )
        Text(
            text = stringResource(R.string.bin_text),
            fontSize = 18.sp
        )
        Text(
            text = stringResource(R.string.data_title),
            fontSize = 26.sp
        )
        Text(
            text = stringResource(R.string.data_text),
            fontSize = 18.sp
        )
    }

}

