package com.example.exchangeappexam.presentation.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exchangeappexam.databinding.ScreenMainBinding
import com.example.exchangeappexam.presentation.adapter.CurrencyAdapter
import com.example.exchangeappexam.presentation.viewmodel.MainViewModel
import com.example.exchangeappexam.presentation.viewmodel.impl.MainViewModelImpl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainScreen : Fragment() {
    private val viewModel: MainViewModel by viewModels<MainViewModelImpl>()
    private lateinit var currencyAdapter: CurrencyAdapter
    private var _binding: ScreenMainBinding? = null
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
        _binding = ScreenMainBinding.inflate(inflater)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        currencyAdapter = CurrencyAdapter()
        viewModel.currencies.observe(this) {
            currencyAdapter.submitList(it)
        }
        viewModel.progressBar.observe(this) {}
        viewModel.errorMessage.observe(this) {
            Log.d("TTT", "onCreate: $it")
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }
        viewModel.openConversion.observe(this) {
            findNavController().navigate(MainScreenDirections.actionMainScreenToConversionScreen(it))
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvCurrencyList.layoutManager = LinearLayoutManager(requireContext())
        binding.rvCurrencyList.adapter = currencyAdapter
        viewModel.dateLiveData.observe(viewLifecycleOwner) {
            binding.tvDate.text = it
        }
        currencyAdapter.setOnClickItemListener {
            viewModel.itemClicked(it)
        }
    }
}