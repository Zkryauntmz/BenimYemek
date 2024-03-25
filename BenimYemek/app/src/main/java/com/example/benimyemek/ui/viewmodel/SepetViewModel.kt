package com.example.benimyemek.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.benimyemek.data.repo.UrunlerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SepetViewModel @Inject constructor(var urepo : UrunlerRepository): ViewModel() {


    suspend fun sil(urun_id:Int){
        CoroutineScope(Dispatchers.Main).launch {
            urepo.sil(urun_id)
        }
    }
}