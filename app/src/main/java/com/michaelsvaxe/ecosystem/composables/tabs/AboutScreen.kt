package com.michaelsvaxe.ecosystem.composables.tabs

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.fromHtml
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun AboutScreenPreview() {
    AboutScreen()
}

@Composable
fun AboutScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        item {
            AnnotatedHtmlStringWithLink()
            Spacer(
                modifier = Modifier
                    .height(100.dp)
            )
        }
    }
}

@Composable
fun AnnotatedHtmlStringWithLink(
    htmlText: String = """
        <h1>About</h1><br>
        <p>binlist.net is a public web service for looking up credit and debit card meta data.</p><br>
        <h2>IIN / BIN.</h2><br>
        <p>The first 6 or 8 digits of a payment card number (credit cards, debit cards, etc.) are known as the Issuer Identification Numbers (IIN), previously known as Bank Identification Number (BIN). These identify the institution that issued the card to the card holder.</p><br>
        <h2>Data</h2><br>
        <p>The data backing this service is not a table of card number prefixes. That would be unreliable and provide you with too little information. The data is sourced from multiple places, filtered, prioritized, and combined to form the data you eventually see. Some data is formed based on assumptions we make by looking at adjoining cards.</p><br>
        <p>Although this service is very accurate, don't expect it to be perfect.</p><br>
        <p><b>Dataset downloads, caching and scraping</b></p><br>
        <p>For the reasons above, we do not provide a static database dump; it is either terribly imprecise or you would need specialized software to compile the results.<p><br>
        <h2>Got corrections?</h2><br>
        <p>We welcome pull requests on <a href="https://github.com/binlist/data">github.com/binlist/data</a>.</p> 
    """.trimIndent()
) {
    Text(
        AnnotatedString.fromHtml(
            htmlText,
            linkStyles = TextLinkStyles(
                style = SpanStyle(
                    textDecoration = TextDecoration.Underline,
                    fontStyle = FontStyle.Italic,
                    color = Color.Blue
                )
            )
        )
    )
}

