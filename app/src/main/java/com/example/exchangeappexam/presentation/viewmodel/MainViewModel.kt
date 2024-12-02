package com.example.exchangeappexam.presentation.viewmodel

import androidx.lifecycle.LiveData
import com.example.exchangeappexam.data.model.CurrencyModel

interface MainViewModel {
    val dateLiveData: LiveData<String>
    val errorMessage: LiveData<String>
    val progressBar: LiveData<Boolean>
    val currencies: LiveData<List<CurrencyModel>>
    val openConversion: LiveData<CurrencyModel>

    fun itemClicked(currency: CurrencyModel)
    fun getAllCurrency()
}