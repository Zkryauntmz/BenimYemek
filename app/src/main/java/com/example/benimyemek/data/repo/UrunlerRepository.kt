package com.example.benimyemek.data.repo

import com.example.benimyemek.data.datasource.UrunlerDataSource
import com.example.benimyemek.data.entity.Sepet
import com.example.benimyemek.data.entity.Urunler

class UrunlerRepository(   var uds :UrunlerDataSource) {


    suspend fun SepeteKaydet(urun_ad:String,urun_resim_adi:String,urun_fiyati:Int,urun_adet:Int,kullanici_adi:String) = uds.SepeteKaydet(urun_ad,  urun_resim_adi,urun_fiyati, urun_adet, kullanici_adi)

    suspend fun sil(urun_id:Int,kullanici_adi: String) = uds.sil(urun_id, kullanici_adi )

    suspend fun urunleriYukle():List<Urunler> = uds.urunleriYukle()

    suspend fun ara(aramaKelimesi:String):List<Urunler> = uds.arama(aramaKelimesi)

    suspend fun sepetYukle(kullanici_adi: String):List<Sepet> =uds.sepetYukle(kullanici_adi)




}