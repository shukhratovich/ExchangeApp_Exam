package com.example.exchangeappexam.data.model

import java.io.Serializable

data class CurrencyModel(
    val id: Int,
    val code: String?,
    val ccy: String?,
    val ccyNmRU: String?,
    val ccyNmUZ: String?,
    val ccyNmUZC: String?,
    val ccyNmEN: String?,
    val nominal: String?,
    val rate: String?,
    val diff: String?,
    val date: String?
) : Serializable

/**
val ccy: String,        // Valyuta kodi
val ccyNmUZ: String,   // Valyuta nomi (o‘zbekcha)
val rate: String,       // Valyuta kursi (UZS)
val diff: String        // O‘zgarish foizi
 * */