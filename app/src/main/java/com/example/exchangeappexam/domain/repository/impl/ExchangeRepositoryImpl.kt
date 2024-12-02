package com.example.exchangeappexam.domain.repository.impl

import com.example.exchangeappexam.data.model.CurrencyModel
import com.example.exchangeappexam.data.source.remote.api.CurrencyApi
import com.example.exchangeappexam.domain.repository.ExchangeRepository
import com.example.exchangeappexam.utils.toData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ExchangeRepositoryImpl @Inject constructor(
    private val currencyApi: CurrencyApi
) : ExchangeRepository {

    override fun getAllCurrencies(): Flow<Result<List<CurrencyModel>>> = flow {
        val result = currencyApi.getExchangeRates()
        if (result.isSuccessful) {
            emit(Result.success(result.body()!!.map { it.toData() }))
        }
    }

}



/**

override fun getAllCurrencies(): Flow<Result<List<CurrencyModel>>> = flow {
val result = currencyApi.getExchangeRates().toList().first()
if (result.isSuccessful) {
emit(Result.success(result.body()!!.map { it.toData() }))
}
}.flowOn(Dispatchers.IO).catch { emit(Result.failure(it)) }
 *  */