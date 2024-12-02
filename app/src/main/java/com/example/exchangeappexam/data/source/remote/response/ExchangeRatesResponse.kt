package com.example.exchangeappexam.data.source.remote.response

data class ExchangeRatesResponse(
    val id: Int,
    val Code: String?,
    val Ccy: String?,
    val CcyNm_RU: String?,
    val CcyNm_UZ: String?,
    val CcyNm_UZC: String?,
    val CcyNm_EN: String?,
    val Nominal: String?,
    val Rate: String?,
    val Diff: String?,
    val Date: String?
)


/*

"id": 69,
    "Code": "840",
    "Ccy": "USD",
    "CcyNm_RU": "Доллар США",
    "CcyNm_UZ": "AQSH dollari",
    "CcyNm_UZC": "АҚШ доллари",
    "CcyNm_EN": "US Dollar",
    "Nominal": "1",
    "Rate": "12865.05",
    "Diff": "16.67",
    "Date": "29.11.2024"
* */