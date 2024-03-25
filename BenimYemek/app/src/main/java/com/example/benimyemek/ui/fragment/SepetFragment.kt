
package com.example.benimyemek.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.example.benimyemek.R
import com.example.benimyemek.databinding.FragmentAnasafaBinding
import com.example.benimyemek.databinding.FragmentSepetBinding
import com.example.benimyemek.ui.viewmodel.SepetViewModel
import com.example.benimyemek.ui.viewmodel.UrunDetayViewModel
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
        // Inflate the layout for this fragment
        var sepetEklenen = UrunDetayFragment()






        return binding.root
    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : SepetViewModel by viewModels()

        viewModel= tempViewModel
    }

}