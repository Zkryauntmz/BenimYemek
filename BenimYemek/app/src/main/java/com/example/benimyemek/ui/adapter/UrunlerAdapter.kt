package com.example.benimyemek.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.benimyemek.data.entity.Urunler
import com.example.benimyemek.databinding.CardTasarimBinding
import com.example.benimyemek.ui.fragment.AnasafaFragmentDirections
import com.example.benimyemek.ui.viewmodel.AnasayfaViewModel
import com.google.android.material.snackbar.Snackbar

class UrunlerAdapter(
    var mContext: Context,
    var urunlerListesi: List<Urunler>,
    viewModel: AnasayfaViewModel
):
RecyclerView.Adapter<UrunlerAdapter.CarTasarimTutucu>()
{

    inner class CarTasarimTutucu(var tasarim:CardTasarimBinding):RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarTasarimTutucu {

        val binding= CardTasarimBinding.inflate(LayoutInflater.from(mContext),parent,false)
return CarTasarimTutucu(binding)
    }



    override fun onBindViewHolder(holder: CarTasarimTutucu, position: Int) {

        val urun = urunlerListesi.get(position)
        val t = holder.tasarim




        t.textViewAd.text = urun.yemek_adi
        t.textViewFiyat.text = urun.yemek_fiyat


            t.cardView.setOnClickListener {
                val gecis = AnasafaFragmentDirections.urunDetay(urun = urun)
                Navigation.findNavController(it).navigate(gecis)
            }





            t.floatingActionButton.setOnClickListener {

                Snackbar.make(it, " ${urun.yemek_adi}  Sepete Eklendi...", Snackbar.LENGTH_SHORT)
                    .show()
            }






    }

    override fun getItemCount(): Int {
        return urunlerListesi.size
    }




}