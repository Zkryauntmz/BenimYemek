package com.example.benimyemek.retrofit

class ApiUtils {

    companion object{
        val BASE_URL= "http://kasimadalan.pe.hu/"
        fun getUrunlerDao(): UrunlerDao{
            return RetrofilClient.getClient(BASE_URL).create(UrunlerDao::class.java)
        }
    }
}