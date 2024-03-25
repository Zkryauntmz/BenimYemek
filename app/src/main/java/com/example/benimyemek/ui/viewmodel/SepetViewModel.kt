package com.example.benimyemek.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.benimyemek.data.entity.Sepet
import com.example.benimyemek.data.repo.UrunlerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SepetViewModel @Inject constructor(var urepo : UrunlerRepository): ViewModel() {
    val kullanici_adi= "Zekeriya"
    var sepetListesi = MutableLiveData<List<Sepet>>()
    init {
        sepetYukle()
    }
    fun sepetYukle(){
        CoroutineScope(Dispatchers.Main).launch {
            try {
                sepetListesi.postValue( urepo.sepetYukle(kullanici_adi))
                Log.e("Sepet ","${sepetListesi} Sepet Yuklendi")
                 }catch (e:Exception){ }
        }
    }

     fun sil(urun_id:Int){
        CoroutineScope(Dispatchers.Main).launch {
            urepo.sil(urun_id,kullanici_adi)
            sepetYukle() }
    }
}