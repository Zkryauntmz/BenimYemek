package com.example.benimyemek.data.datasource

import com.example.benimyemek.data.entity.Sepet
import com.example.benimyemek.data.entity.Urunler
import com.example.benimyemek.retrofit.UrunlerDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UrunlerDataSource(var udao :UrunlerDao ) {

    suspend fun SepeteKaydet(urun_ad:String,urun_resim_adi:String,urun_fiyati:Int,urun_adet:Int,kullanici_adi:String)=
        udao.sepetKaydet(urun_ad,urun_resim_adi,urun_fiyati,urun_adet, kullanici_adi)

    suspend fun sil(urun_id:Int, kullanici_adi: String)=udao.sil(urun_id,kullanici_adi)

    suspend fun urunleriYukle():List<Urunler> =
        withContext(Dispatchers.IO){
            return@withContext udao.urunleriYukle().yemekler }

    suspend fun arama(aramaKelimesi:String):List<Urunler> =
    withContext(Dispatchers.IO)
     {
        return@withContext udao.ara(aramaKelimesi).yemekler  }


    suspend fun sepetYukle(kullanici_adi: String):List<Sepet> =
        withContext(Dispatchers.IO){
        return@withContext udao.sepetYukle(kullanici_adi).sepet_yemekler }

}