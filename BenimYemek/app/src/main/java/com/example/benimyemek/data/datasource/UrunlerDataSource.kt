package com.example.benimyemek.data.datasource

import com.example.benimyemek.data.entity.Urunler
import com.example.benimyemek.retrofit.UrunlerDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UrunlerDataSource(var udao :UrunlerDao) {

    suspend fun SepeteKaydet(urun_ad:String,urun_fiyati:String,urun_resima_adi:String){

    }


    suspend fun sil(urun_id:Int){

    }

    suspend fun urunleriYukle():List<Urunler> =
        withContext(Dispatchers.IO){

            return@withContext udao.urunleriYukle().yemekler
    }

  suspend fun arama(aramaKelimesi:String):List<Urunler> =
   withContext(Dispatchers.IO)
   {

        return@withContext udao.ara(aramaKelimesi).yemekler

    }

}