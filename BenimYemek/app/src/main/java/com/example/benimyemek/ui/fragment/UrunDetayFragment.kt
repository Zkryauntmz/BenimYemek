package com.example.benimyemek.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels

import androidx.navigation.fragment.navArgs

import com.example.benimyemek.databinding.FragmentYemekDetayBinding
import com.example.benimyemek.ui.viewmodel.SepetViewModel
import com.example.benimyemek.ui.viewmodel.UrunDetayViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UrunDetayFragment : Fragment() {

private lateinit var binding: FragmentYemekDetayBinding

private lateinit var viewModel: UrunDetayViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding= FragmentYemekDetayBinding.inflate(inflater,container,false)

       val bundle:UrunDetayFragmentArgs by navArgs()
        val gelenUrun = bundle.urun



        binding.textViewUrunAd.setText(gelenUrun.yemek_adi)
        binding.textViewUrunFiyat.setText(gelenUrun.yemek_fiyat)
        binding.textViewUrunResim.setText(gelenUrun.yemek_resim_adi)
viewModel.SepeteKaydet(gelenUrun.yemek_adi,gelenUrun.yemek_fiyat.toString(),gelenUrun.yemek_resim_adi)















        return binding.root
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : UrunDetayViewModel by viewModels()

        viewModel= tempViewModel
    }

}