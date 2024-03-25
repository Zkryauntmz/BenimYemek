package com.example.benimyemek.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.benimyemek.data.entity.Urunler
import com.example.benimyemek.databinding.CardTasarimBinding
import com.example.benimyemek.ui.fragment.AnasayfaFragmentDirections
import com.example.benimyemek.ui.viewmodel.AnasayfaViewModel


class UrunlerAdapter(
    var mContext: Context,
    var urunlerListesi: List<Urunler>,
    viewModel: AnasayfaViewModel):
RecyclerView.Adapter<UrunlerAdapter.CarTasarimTutucu>()
{    inner class CarTasarimTutucu(var tasarim:CardTasarimBinding):RecyclerView.ViewHolder(tasarim.root)
     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarTasarimTutucu {
        val binding= CardTasarimBinding.inflate(LayoutInflater.from(mContext),parent,false)
     return CarTasarimTutucu(binding) }

    override fun onBindViewHolder(holder: CarTasarimTutucu, position: Int) {
        val urun = urunlerListesi.get(position)
        val t = holder.tasarim

        t.textViewAd.text = urun.yemek_adi
        t.textViewFiyat.text = urun.yemek_fiyat+" ₺"
        val url = "http://kasimadalan.pe.hu/yemekler/resimler/${urun.yemek_resim_adi}"
        Glide.with(mContext).load(url).override(70,70).into(t.urunResim)
        t.cardView.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.urunDetay(urun = urun)
                Navigation.findNavController(it).navigate(gecis) }

                //Navigation.findNavController(it).navigate(com.example.benimyemek.R.id.sepetGecis)
    }
    override fun getItemCount(): Int {
        return urunlerListesi.size
    }
}