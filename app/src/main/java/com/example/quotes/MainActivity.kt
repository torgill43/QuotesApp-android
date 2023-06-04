package com.example.quotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quotes.data.Datasource
import com.example.quotes.model.Quote
import com.example.quotes.ui.theme.QuotesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuotesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    QuotesApp()
                }
            }
        }
    }
}

@Composable
fun QuotesApp() {
    QuotesList(
        quoteList = Datasource().loadQuotes(),
    )
}

@Composable
fun QuotesList(quoteList: List<Quote>, modifier: Modifier = Modifier) {
    LazyColumn (modifier = modifier) {
        items(quoteList) { quote ->
            QuoteCard(
                quote = quote,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
fun QuoteCard(quote: Quote, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Column {
            Text(
                text = LocalContext.current.getString(quote.stringResourceId01),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = LocalContext.current.getString(quote.stringResourceId02),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun QuoteCardPreview() {
    QuoteCard(Quote(R.string.quote01, R.string.author01))
}