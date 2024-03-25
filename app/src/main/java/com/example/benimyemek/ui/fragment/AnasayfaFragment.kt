package com.example.benimyemek.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.benimyemek.LogInActivity
import com.example.benimyemek.databinding.FragmentAnasayfaBinding
import com.example.benimyemek.ui.adapter.UrunlerAdapter
import com.example.benimyemek.ui.viewmodel.AnasayfaViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnasayfaFragment : Fragment() {
private lateinit var binding: FragmentAnasayfaBinding
private lateinit var viewModel: AnasayfaViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentAnasayfaBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment

            viewModel.urunlerListesi.observe(viewLifecycleOwner){
            val urunlerAdapter = UrunlerAdapter(requireContext(),it,viewModel)
            binding.rvUrunler.adapter = urunlerAdapter
            binding.rvUrunler.layoutManager= StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        }
                   /* binding.searchView.setOnQueryTextListener(object :OnQueryTextListener{
                override fun onQueryTextChange(newText: String): Boolean {
                    viewModel.ara(newText)
                    return true
                }

                override fun onQueryTextSubmit(query: String): Boolean {
                    viewModel.ara(query)
                    return true
                }

            } )


*/            binding.imageView4.setOnClickListener {

            Snackbar.make(
                it,
                "Indirim Kodunuz : ZEK100  ",
                Snackbar.LENGTH_SHORT
            ).show()

        }

        binding.imageViewLogOut.setOnClickListener {
            val intent = Intent(requireContext(), LogInActivity::class.java)
            startActivity(intent)
        }




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