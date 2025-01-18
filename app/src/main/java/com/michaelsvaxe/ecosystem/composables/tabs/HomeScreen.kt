package com.michaelsvaxe.ecosystem.composables.tabs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.michaelsvaxe.ecosystem.R
import com.michaelsvaxe.ecosystem.network.data.CardInfo
import com.michaelsvaxe.ecosystem.ui.theme.BlueButton

@Composable
fun HomeScreen(
    cardNumber: State<String>,
    onValueChange: (String) -> Unit,
    onClick: () -> Unit,
    cardInfo: MutableState<CardInfo>,
    explainText: MutableState<String>
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = stringResource(R.string.bank_info_screen_title),
                fontSize = 25.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 40.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
            ) {
                TextField(
                    value = cardNumber.value,
                    textStyle = TextStyle(fontSize = 20.sp),
                    onValueChange = onValueChange,
                    label = {
                        Text(
                            text = stringResource(R.string.text_field_label)
                        )
                    },
                    modifier = Modifier
                        .padding(12.dp)
                )
                Button(
                    onClick = onClick,
                    shape = ShapeDefaults.ExtraSmall,
                    colors = ButtonColors(BlueButton, Color.White, Color.Red, Color.White),
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                ) {
                    Text(
                        text = stringResource(R.string.btn_main)
                    )
                }
            }
            Text(
                text = explainText.value,
                fontSize = 14.sp,
                color = Color.Gray,
                modifier = Modifier
                    .padding(6.dp)
            )
            Card(
                elevation = CardDefaults.elevatedCardElevation(2.dp),
                colors = CardColors(Color.White, Color.Black, Color.White, Color.Blue),
                modifier = Modifier
                    .padding(6.dp)
            ) {
                BankInfoScreen(cardInfo)
            }
            Spacer(
                modifier = Modifier
                    .fillMaxHeight()
            )
            Text(
                text = "Version 1.2.0",
                fontSize = 16.sp,
                color = Color.Gray,
                modifier = Modifier
                    .padding(6.dp)
            )

        }
    }
}


@Composable
fun BankInfoScreen(cardInfo: MutableState<CardInfo>) {
    Box(
        modifier = Modifier
            .padding(start = 6.dp, end = 6.dp, top = 6.dp, bottom = 20.dp)
            .fillMaxWidth()
            .height(IntrinsicSize.Max)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(6.dp)
        ) {
            Text(
                text = cardInfo.value.cardNumber.toString(),
                textAlign = TextAlign.Center,
                fontSize = 25.sp,
                modifier = Modifier
                    .fillMaxWidth()
            )
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 6.dp)
            ) {
                Column {
                    Text(
                        stringResource(R.string.scheme),
                        fontWeight = FontWeight.Thin
                    )
                    Text(
                        text = cardInfo.value.scheme.toString(),
                        fontWeight = FontWeight.Bold
                    )
                }
                Column {
                    Text(
                        stringResource(R.string.type),
                        fontWeight = FontWeight.Thin
                    )
                    Text(
                        text = cardInfo.value.type.toString(),
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 6.dp)
            ) {
                Column {
                    Text(
                        text = stringResource(R.string.brand),
                        fontWeight = FontWeight.Thin
                    )
                    Text(
                        text = cardInfo.value.brand.toString(),
                        fontWeight = FontWeight.Bold
                    )
                }
                Column {
                    Text(
                        text = stringResource(R.string.prepaid),
                        fontWeight = FontWeight.Thin
                    )
                    Text(
                        text = when (cardInfo.value.prepaid) {
                            true.toString() -> "YES"
                            false.toString() -> "NO"
                            else -> "no data"
                        },
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            Text(
                text = stringResource(R.string.card_number),
                fontWeight = FontWeight.Light,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .padding(bottom = 6.dp)
                    .fillMaxWidth()
            ) {
                Column {
                    Text(
                        text = stringResource(R.string.length),
                        fontWeight = FontWeight.Thin
                    )
                    Text(
                        text = cardInfo.value.length.toString(),
                        fontWeight = FontWeight.Bold
                    )
                }
                Column {
                    Text(
                        text = stringResource(R.string.luhn),
                        fontWeight = FontWeight.Thin
                    )
                    Text(
                        text = when (cardInfo.value.luhn) {
                            false.toString() -> "NO"
                            true.toString() -> "YES"
                            else -> "no data"
                        },
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            Text(
                text = stringResource(R.string.bank),
                fontWeight = FontWeight.Light,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .padding(bottom = 6.dp)
                    .fillMaxWidth()
            ) {
                Column {
                    Text(
                        text = stringResource(R.string.bank_name),
                        fontWeight = FontWeight.Thin
                    )
                    Text(
                        text = cardInfo.value.bankName.toString(),
                        fontWeight = FontWeight.Bold
                    )
                }
                Column {
                    Text(
                        text = stringResource(R.string.bank_city),
                        fontWeight = FontWeight.Thin
                    )
                    Text(
                        text = cardInfo.value.bankCity.toString(),
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .padding(bottom = 6.dp)
                    .fillMaxWidth()
            ) {
                Column {
                    Text(
                        text = stringResource(R.string.bank_website),
                        fontWeight = FontWeight.Thin
                    )
                    Text(
                        text = cardInfo.value.bankWebsite.toString(),
                        fontWeight = FontWeight.Bold
                    )
                }
                Column {
                    Text(
                        text = stringResource(R.string.bank_phone),
                        fontWeight = FontWeight.Thin
                    )
                    Text(
                        text = cardInfo.value.bankPhone.toString(),
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            Text(
                text = stringResource(R.string.country),
                fontWeight = FontWeight.Light,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(cardInfo.value.countryEmoji.toString())
                Text(cardInfo.value.countryName.toString())
            }
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                Column {
                    Text(
                        text = stringResource(R.string.latitude),
                        fontWeight = FontWeight.Thin
                    )
                    Text(
                        text = cardInfo.value.longitude.toString(),
                        fontWeight = FontWeight.Bold
                    )
                }
                Column {
                    Text(
                        text = stringResource(R.string.longitude),
                        fontWeight = FontWeight.Thin
                    )
                    Text(
                        text = cardInfo.value.latitude.toString(),
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}