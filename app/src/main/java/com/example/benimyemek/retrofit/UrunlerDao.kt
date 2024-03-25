package com.example.benimyemek.retrofit

import com.example.benimyemek.data.entity.CRUDCevap
import com.example.benimyemek.data.entity.SepetCevap
import com.example.benimyemek.data.entity.UrunlerCevap
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface UrunlerDao {
    //http://kasimadalan.pe.hu/yemekler/tumYemekleriGetir.php
    //base url

    @GET("yemekler/tumYemekleriGetir.php")
    suspend fun urunleriYukle():UrunlerCevap

    //arama
    @POST("yemekler/tumYemekleriGetir.php")
    @FormUrlEncoded
    suspend fun ara(@Field("yemek_adi")aramaKelimesi:String):UrunlerCevap

    //Sepet Silme
    //url sepet url kullan
    @POST("yemekler/sepettenYemekSil.php")
    @FormUrlEncoded
   suspend fun sil(@Field("sepet_yemek_id")urun_id:Int,
                   @Field("kullanici_adi")kullanici_adi: String):CRUDCevap

    //Sepet Getir
    @POST("yemekler/sepettekiYemekleriGetir.php")
    @FormUrlEncoded
    suspend fun sepetYukle(@Field("kullanici_adi")kullanici_adi: String): SepetCevap

    //Sepet Ekle
    @POST("yemekler/sepeteYemekEkle.php")
    @FormUrlEncoded
    suspend fun sepetKaydet(@Field("yemek_adi")urun_ad:String,
                            @Field("yemek_resim_adi")urun_resim_adi:String,
                            @Field("yemek_fiyat")urun_fiyat:Int,
                            @Field("yemek_siparis_adet")urun_adet : Int,
                            @Field("kullanici_adi")kullanici_adi:String): CRUDCevap



}