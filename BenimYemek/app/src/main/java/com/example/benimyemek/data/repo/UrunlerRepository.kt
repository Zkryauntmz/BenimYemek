package com.example.benimyemek.data.repo

import com.example.benimyemek.data.datasource.UrunlerDataSource
import com.example.benimyemek.data.entity.Urunler

class UrunlerRepository(   var uds :UrunlerDataSource) {


    suspend fun SepeteKaydet(urun_ad:String,urun_fiyati:String,urun_resim_adi:String) = uds.SepeteKaydet(urun_ad,urun_fiyati,urun_resim_adi)
    suspend fun sil(urun_id:Int) = uds.sil(urun_id)
    suspend fun urunleriYukle():List<Urunler> = uds.urunleriYukle()
    suspend fun ara(aramaKelimesi:String):List<Urunler> = uds.arama(aramaKelimesi)



}