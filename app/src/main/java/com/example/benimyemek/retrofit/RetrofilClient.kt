package com.example.benimyemek.retrofit


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofilClient {
    companion object{
        fun getClient(baseUrl:String) : Retrofit {
            return Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}