package com.example.benimyemek.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.benimyemek.databinding.FragmentYemekDetayBinding
import com.example.benimyemek.ui.viewmodel.UrunDetayViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
    class UrunDetayFragment : Fragment() {
    private lateinit var binding: FragmentYemekDetayBinding
    private lateinit var viewModel: UrunDetayViewModel
    var yemek_siparis_adet: Int = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
        ): View? {
        // Inflate the layout for this fragment

        binding= FragmentYemekDetayBinding.inflate(inflater,container,false)

        val bundle:UrunDetayFragmentArgs by navArgs()
        val gelenUrun = bundle.urun

        val url = "http://kasimadalan.pe.hu/yemekler/resimler/${gelenUrun.yemek_resim_adi}"
        Glide.with(this).load(url).override(850,470).into(binding.imageViewUrun)

        binding.textViewUrunAd.setText(gelenUrun.yemek_adi)
        binding.textViewUrunFiyat.setText(gelenUrun.yemek_fiyat+"  ₺")

        val kullanici_adi ="Zekeriya"

        binding.buttonSepetEkle.setOnClickListener {
        viewModel.sepeteKaydet(gelenUrun.yemek_adi,gelenUrun.yemek_resim_adi,gelenUrun.yemek_fiyat.toInt(),yemek_siparis_adet,kullanici_adi)
    //  Log.e("Sepet ","Sepete eklendi")
    //  Navigation.findNavController(it).navigate(com.example.benimyemek.R.id.sepetgit)
        }
     //   binding.imageViewBack.setOnClickListener { Navigation.findNavController(it).navigate() }
        binding.iVAdetArti.setOnClickListener { adetArti() }
        binding.iVAdetAzalt.setOnClickListener { adetEksi() }
        return binding.root
        }

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : UrunDetayViewModel by viewModels()
            viewModel= tempViewModel
         }

        fun adetArti(){
        if (yemek_siparis_adet<10) yemek_siparis_adet++
        binding.tVAdetGoster.text=yemek_siparis_adet.toString()
        }

        fun adetEksi(){
        if (yemek_siparis_adet>1) yemek_siparis_adet--
        binding.tVAdetGoster.text=yemek_siparis_adet.toString()
        }


}