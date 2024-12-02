package com.example.exchangeappexam.domain.repository

import com.example.exchangeappexam.data.model.CurrencyModel
import com.example.exchangeappexam.data.source.remote.response.ExchangeRatesResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface ExchangeRepository {
    fun getAllCurrencies(): Flow<Result<List<CurrencyModel>>>
}