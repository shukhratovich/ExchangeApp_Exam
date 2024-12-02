package com.example.exchangeappexam.presentation.viewmodel.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.exchangeappexam.presentation.viewmodel.ConversionViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ConversionViewModelImpl @Inject constructor() : ViewModel(), ConversionViewModel {
    override val backBtnLiveData = MutableLiveData<Unit>()
    override val inputAmount = MutableLiveData<String>()
    override val outputAmount = MutableLiveData<String>()

    override fun backClicked() {
        backBtnLiveData.value = Unit
    }

    override fun inputListener(text: String, amount: String) {
        if (text.isNotEmpty() && amount.isNotEmpty()){
            inputAmount.value = text
            outputAmount.value = "${text.toDouble() * amount.toDouble()}"
        }

    }
}