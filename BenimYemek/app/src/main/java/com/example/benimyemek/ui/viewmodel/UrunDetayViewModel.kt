package com.example.benimyemek.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.benimyemek.data.repo.UrunlerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UrunDetayViewModel @Inject constructor(var urepo : UrunlerRepository): ViewModel() {


     fun SepeteKaydet(urun_ad:String,urun_fiyati:String,urun_resima_adi:String){
         CoroutineScope(Dispatchers.Main).launch {
             urepo.SepeteKaydet(urun_ad, urun_fiyati, urun_resima_adi)
         }

     }

}