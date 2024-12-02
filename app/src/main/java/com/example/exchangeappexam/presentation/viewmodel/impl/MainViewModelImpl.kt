package com.example.exchangeappexam.presentation.viewmodel.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.exchangeappexam.data.model.CurrencyModel
import com.example.exchangeappexam.domain.repository.ExchangeRepository
import com.example.exchangeappexam.presentation.viewmodel.MainViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModelImpl @Inject constructor(
    private val exchangeRepository: ExchangeRepository
) : ViewModel(), MainViewModel {
    override val dateLiveData = MutableLiveData<String>()
    override val errorMessage = MutableLiveData<String>()
    override val progressBar = MutableLiveData<Boolean>()
    override val currencies = MutableLiveData<List<CurrencyModel>>()
    override val openConversion = MutableLiveData<CurrencyModel>()

    init {
        getAllCurrency()
    }

    override fun itemClicked(currency: CurrencyModel) {
        openConversion.value = currency
    }

    override fun getAllCurrency() {
        exchangeRepository.getAllCurrencies().onEach {
            it.onSuccess { data ->
                progressBar.value = false
                currencies.value = data
                dateLiveData.value = "${data[0].date}"
            }
            it.onFailure { error -> errorMessage.value = error.message }
        }.launchIn(viewModelScope)
    }
}