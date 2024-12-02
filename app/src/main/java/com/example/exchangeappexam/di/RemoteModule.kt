package com.example.exchangeappexam.di

import android.content.Context
import androidx.room.Database
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.example.exchangeappexam.data.source.remote.api.CurrencyApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteModule {

    @[Provides Singleton]
    fun provideAppDatabase(@ApplicationContext context: Context): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(ChuckerInterceptor(context))
            .build()

    @[Provides Singleton]
    fun provideClientApi(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl("https://cbu.uz/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @[Provides Singleton]
    fun provideCurrencyApi(retrofit: Retrofit): CurrencyApi =
        retrofit.create(CurrencyApi::class.java)
}