package com.example.benimyemek.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.OnQueryTextListener
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.benimyemek.data.entity.Urunler
import com.example.benimyemek.databinding.FragmentAnasafaBinding
import com.example.benimyemek.ui.adapter.UrunlerAdapter
import com.example.benimyemek.ui.viewmodel.AnasayfaViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnasafaFragment : Fragment() {
private lateinit var binding: FragmentAnasafaBinding
private lateinit var viewModel: AnasayfaViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding= FragmentAnasafaBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment

            viewModel.urunlerListesi.observe(viewLifecycleOwner){
            val urunlerAdapter = UrunlerAdapter(requireContext(),it,viewModel)
            binding.rvUrunler.adapter = urunlerAdapter
            binding.rvUrunler.layoutManager= StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        }







            binding.searchView.setOnQueryTextListener(object :OnQueryTextListener{
                override fun onQueryTextChange(newText: String): Boolean {
                    viewModel.ara(newText)
                    return true
                }

                override fun onQueryTextSubmit(query: String): Boolean {
                    viewModel.ara(query)
                    return true
                }

            } )














        return binding.root
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : AnasayfaViewModel by viewModels()

        viewModel= tempViewModel
    }

    override fun onResume() {
        super.onResume()
        viewModel.urunleriYukle()
    }

}