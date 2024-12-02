package com.example.exchangeappexam.utils

import com.example.exchangeappexam.data.model.CurrencyModel
import com.example.exchangeappexam.data.source.remote.response.ExchangeRatesResponse


/**
val id: Int,
val code: String,
val ccy: String,
val ccyNmRU: String,
val ccyNmUZ: String,
val ccyNmUZC: String,
val ccyNmEN: String,
val nominal: String,
val rate: String,
val diff: String,
val date: String
 * */
fun ExchangeRatesResponse.toData() =
    CurrencyModel(id, Code, Ccy, CcyNm_RU, CcyNm_UZ, CcyNm_UZC, CcyNm_EN, Nominal, Rate, Diff, Date)