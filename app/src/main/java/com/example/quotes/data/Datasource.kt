package com.example.quotes.data

import com.example.quotes.R
import com.example.quotes.model.Quote

class Datasource() {
    fun loadQuotes(): List<Quote> {
        return listOf<Quote>(
            Quote(R.string.quote01, R.string.author01),
            Quote(R.string.quote02, R.string.author02),
            Quote(R.string.quote03, R.string.author03),
            Quote(R.string.quote04, R.string.author04),
            Quote(R.string.quote05, R.string.author05),
            Quote(R.string.quote06, R.string.author06),
            Quote(R.string.quote07, R.string.author07),
            Quote(R.string.quote08, R.string.author08),
            Quote(R.string.quote09, R.string.author09),
            Quote(R.string.quote10, R.string.author10),
        )
    }
}
