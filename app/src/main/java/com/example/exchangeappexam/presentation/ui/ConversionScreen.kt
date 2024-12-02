package com.example.exchangeappexam.presentation.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.exchangeappexam.databinding.ScreenConversionBinding
import com.example.exchangeappexam.presentation.viewmodel.ConversionViewModel
import com.example.exchangeappexam.presentation.viewmodel.impl.ConversionViewModelImpl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ConversionScreen : Fragment() {
    private val args: ConversionScreenArgs by navArgs()
    private val viewModel: ConversionViewModel by viewModels<ConversionViewModelImpl>()
    private var _binding: ScreenConversionBinding? = null
    private val binding get() = _binding!!
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ScreenConversionBinding.inflate(inflater)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.backBtnLiveData.observe(this) {
            findNavController().popBackStack()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.ivBack.setOnClickListener { viewModel.backClicked() }
        loadView()
        init()
    }

    private fun loadView() {
        val item = args.currency
        binding.itemCCY.text = item.ccy
//        binding.icItemFlag.setImageResource()
        binding.tvItemPrice.text = "1 ${item.ccy} = ${item.rate} UZS"
        binding.outputAmount.text = item.rate

        binding.inputAmount.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(
                charSequence: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) {

            }

            override fun onTextChanged(
                charSequence: CharSequence?,
                start: Int,
                before: Int,
                count: Int
            ) {
                // Matn o'zgartirilayotganda bajariladi
            }

            override fun afterTextChanged(editable: Editable?) {
                viewModel.inputListener(editable.toString(), args.currency.rate!!)
            }
        })

        viewModel.outputAmount.observe(viewLifecycleOwner) {
            binding.outputAmount.text = it
        }
    }

    private fun init() {
    }
}