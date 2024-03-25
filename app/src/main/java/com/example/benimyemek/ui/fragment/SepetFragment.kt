
package com.example.benimyemek.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.benimyemek.databinding.FragmentSepetBinding
import com.example.benimyemek.ui.adapter.SepetAdapter
import com.example.benimyemek.ui.viewmodel.SepetViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
    class SepetFragment : Fragment() {
    private lateinit var binding: FragmentSepetBinding
    private lateinit var viewModel: SepetViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding= FragmentSepetBinding.inflate(inflater,container,false)
        viewModel.sepetListesi.observe(viewLifecycleOwner){
            val sepetAdapter = SepetAdapter(requireContext(),it,viewModel)
           binding.sepetRv.adapter=sepetAdapter
            binding.sepetRv.layoutManager=  LinearLayoutManager(requireContext())

            var toplam = 0
            for ( i in 0..sepetAdapter.sepetListesi.size-1)
            {
                Log.e("Sepet",sepetAdapter.sepetListesi[i].yemek_fiyat.toString())
                toplam  += sepetAdapter.sepetListesi[i].yemek_fiyat * sepetAdapter.sepetListesi[i].yemek_siparis_adet
            }
            binding.textViewSonuc.text=toplam.toString()





        }



        return binding.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : SepetViewModel by viewModels()

        viewModel= tempViewModel
    }
    override fun onResume() {
        super.onResume()
        viewModel.sepetYukle()
    }

}