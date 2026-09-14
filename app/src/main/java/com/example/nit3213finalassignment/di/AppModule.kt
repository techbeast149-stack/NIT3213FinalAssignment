package com.example.nit3213finalassignment.di

import com.example.nit3213finalassignment.data.ApiService
import com.example.nit3213finalassignment.data.Nit3213RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideApiService(): ApiService {
        return Nit3213RetrofitClient().apiService
    }

}