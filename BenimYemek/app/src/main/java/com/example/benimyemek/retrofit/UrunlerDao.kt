package com.example.benimyemek.retrofit

import com.example.benimyemek.data.entity.CRUDCevap
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



@POST("yemekler/tumYemekleriGetir.php")
@FormUrlEncoded
suspend fun ara(@Field("urun_adi")aramaKelimesi:String):UrunlerCevap



//Sepet Silme
//url sepet url kullan
    @POST("yemekler/tumYemekleriGetir.php")
    @FormUrlEncoded
    suspend fun sil(@Field("urun_id")urun_id:Int):CRUDCevap
//Sepet Ekle
@POST("yemekler/tumYemekleriGetir.php")
@FormUrlEncoded
suspend fun kaydet(@Field("urun_adi")urun_ad:String,
                   @Field("urun_resim_adi")urun_resim_adi:String,
                   @Field("urun_fiyat")urun_fiyat:Int):CRUDCevap




}