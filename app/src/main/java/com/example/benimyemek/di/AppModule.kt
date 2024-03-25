package com.example.benimyemek.di

import com.example.benimyemek.data.datasource.UrunlerDataSource
import com.example.benimyemek.data.repo.UrunlerRepository
import com.example.benimyemek.retrofit.ApiUtils
import com.example.benimyemek.retrofit.UrunlerDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


    @Module
    @InstallIn(SingletonComponent::class)
    class AppModule() {

    @Provides
    @Singleton
    fun provideUrunlerRepository(uds:UrunlerDataSource):UrunlerRepository{
        return UrunlerRepository(uds) }

    @Provides
    @Singleton
    fun provideUrunlerDataSource(udao : UrunlerDao):UrunlerDataSource{
        return UrunlerDataSource(udao) }

    @Provides
    @Singleton
    fun provideUrunlerDao(): UrunlerDao {

        return ApiUtils.getUrunlerDao() }
    }