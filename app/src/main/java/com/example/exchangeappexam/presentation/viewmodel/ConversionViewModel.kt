package com.example.exchangeappexam.presentation.viewmodel

import androidx.lifecycle.LiveData

interface ConversionViewModel {
    val backBtnLiveData: LiveData<Unit>
    val inputAmount: LiveData<String>
    val outputAmount: LiveData<String>

    fun backClicked()
    fun inputListener(text:String, amount:String)
}