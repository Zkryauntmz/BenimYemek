package com.example.benimyemek.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.benimyemek.data.entity.Urunler
import com.example.benimyemek.data.repo.UrunlerRepository
import dagger.Module
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnasayfaViewModel @Inject constructor(var urepo : UrunlerRepository):ViewModel() {

    var urunlerListesi = MutableLiveData<List<Urunler>>()

    init {
        urunleriYukle()
    }
fun sil(urun_id:Int){
    CoroutineScope(Dispatchers.Main).launch{
        urepo.sil(urun_id)
        urunleriYukle()
    }
}
    fun urunleriYukle(){
        CoroutineScope(Dispatchers.Main).launch {

          urunlerListesi.postValue( urepo.urunleriYukle())
        }
    }


    fun ara(aramakelimesi:String){
        CoroutineScope(Dispatchers.Main).launch {
            try {
                urunlerListesi.value=  urepo.ara(aramakelimesi)

            }catch (e:Exception){}
        }
    }


}