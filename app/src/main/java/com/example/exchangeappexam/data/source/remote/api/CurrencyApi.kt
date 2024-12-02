package com.example.exchangeappexam.data.source.remote.api

import com.example.exchangeappexam.data.source.remote.response.ExchangeRatesResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyApi {

    @GET("uz/arkhiv-kursov-valyut/json/")
    suspend fun getExchangeRates(): Response<List<ExchangeRatesResponse>>
}

//http://cbu.uz/uz/arkhiv-kursov-valyut/json/