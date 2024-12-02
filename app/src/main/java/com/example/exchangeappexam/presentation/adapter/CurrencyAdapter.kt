package com.example.exchangeappexam.presentation.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.exchangeappexam.R
import com.example.exchangeappexam.data.model.CurrencyModel
import com.example.exchangeappexam.databinding.ItemCurrencyBinding

class CurrencyAdapter : ListAdapter<CurrencyModel, CurrencyAdapter.CurrencyVH>(CurrencyDiffUtil) {

    private var onClickItemListener: ((CurrencyModel) -> Unit)? = null


    fun setOnClickItemListener(listener: (CurrencyModel) -> Unit) {
        onClickItemListener = listener
    }

    object CurrencyDiffUtil : DiffUtil.ItemCallback<CurrencyModel>() {
        override fun areContentsTheSame(oldItem: CurrencyModel, newItem: CurrencyModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areItemsTheSame(oldItem: CurrencyModel, newItem: CurrencyModel): Boolean {
            return oldItem == newItem
        }

    }

    inner class CurrencyVH(private val binding: ItemCurrencyBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                onClickItemListener?.invoke(currentList[adapterPosition])
            }
        }

        @SuppressLint("SetTextI18n")
        fun bind() {

            if (currentList[adapterPosition].code.equals("840")) {
                binding.ivFlag.setImageResource(R.drawable.ic_flag_usa)
            } else if (currentList[adapterPosition].code.equals("978")) {
                binding.ivFlag.setImageResource(R.drawable.ic_euro)
            } else if (currentList[adapterPosition].code.equals("643")) {
                binding.ivFlag.setImageResource(R.drawable.ic_rus)
            } else if (currentList[adapterPosition].code.equals("702")) {
                binding.ivFlag.setImageResource(R.drawable.ic_flag_singapore)
            }
            if (currentList[adapterPosition].diff!!.toDouble() > 0) binding.ivUpOrDown.setImageResource(
                R.drawable.ic_up
            ) else binding.ivUpOrDown.setImageResource(R.drawable.ic_down)
            binding.tvChangePercentage.text = currentList[adapterPosition].diff + "%"
            binding.tvCurrencyCode.text = currentList[adapterPosition].ccy
            binding.tvCurrencyName.text = currentList[adapterPosition].ccyNmUZ
            binding.tvExchangeRate.text = currentList[adapterPosition].rate + "UZS"
        }

    }

    override fun onBindViewHolder(holder: CurrencyVH, position: Int) {
        holder.bind()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyVH {
        return CurrencyVH(
            ItemCurrencyBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
}