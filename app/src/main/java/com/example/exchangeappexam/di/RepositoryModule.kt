package com.example.exchangeappexam.di

import com.example.exchangeappexam.domain.repository.ExchangeRepository
import com.example.exchangeappexam.domain.repository.impl.ExchangeRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindExchangeRepository(impl: ExchangeRepositoryImpl): ExchangeRepository
}