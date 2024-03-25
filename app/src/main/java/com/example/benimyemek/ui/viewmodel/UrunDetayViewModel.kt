package com.example.benimyemek.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.benimyemek.data.entity.Sepet
import com.example.benimyemek.data.repo.UrunlerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UrunDetayViewModel @Inject constructor(var urepo : UrunlerRepository): ViewModel() {

    val kullanici_adi ="Zekeriya"
 //   val urun_adet=5

    //fun SepeteKaydet(urun_ad:String,urun_resim_adi:String,urun_fiyati:Int,urun_adet:Int){
   //     CoroutineScope(Dispatchers.Main).launch {
     //       Log.e("Sepet","Sepete kaydedildi")
      //      urepo.SepeteKaydet(urun_ad,  urun_resim_adi, urun_fiyati,urun_adet, kullanici_adi)
      //  }




    fun sepeteKaydet(yemek_adi:String,
                     yemek_resim_adi:String,
                     yemek_fiyat:Int,
                     yemek_siparis_adet:Int,
                     kullanici_adi:String){
        CoroutineScope(Dispatchers.Main).launch {
            var nesne: Sepet? = null
            try {
                val sepetListesi = urepo.sepetYukle(kullanici_adi)
                for (it in sepetListesi){
                    if (it.yemek_adi == yemek_adi){
                        nesne = it
                        break
                    }
                }
                if(nesne != null){
                    val yeniAdet = nesne.yemek_siparis_adet+yemek_siparis_adet
                    urepo.sil(nesne.sepet_yemek_id,kullanici_adi)
                    urepo.SepeteKaydet(yemek_adi,yemek_resim_adi,yemek_fiyat,yeniAdet,kullanici_adi)
                }else{
                    urepo.SepeteKaydet(
                        yemek_adi,
                        yemek_resim_adi,
                        yemek_fiyat,
                        yemek_siparis_adet,
                        kullanici_adi)
                }
            }catch (e:Exception){
                Log.e("Hata","Catche Girdi")
                urepo.SepeteKaydet(
                    yemek_adi,
                    yemek_resim_adi,
                    yemek_fiyat,
                    yemek_siparis_adet,
                    kullanici_adi)
            }

        }

    }
    }



