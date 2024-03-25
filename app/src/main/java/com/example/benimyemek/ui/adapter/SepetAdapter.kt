package com.example.benimyemek.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.benimyemek.data.entity.Sepet
import com.example.benimyemek.databinding.SepetCardBinding
import com.example.benimyemek.ui.fragment.SepetFragment
import com.example.benimyemek.ui.viewmodel.SepetViewModel
import com.google.android.material.snackbar.Snackbar

class SepetAdapter(
    var mContext: Context,
    var sepetListesi: List<Sepet>,

    var viewModel: SepetViewModel ,
    var yemek_toplam_ucret : Int= 0

):

    RecyclerView.Adapter<SepetAdapter.CardTasarimSepet>() {
    private lateinit var binding: SepetFragment
    inner class CardTasarimSepet(var sepetTasarim:SepetCardBinding) : RecyclerView.ViewHolder(sepetTasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimSepet {
        val binding= SepetCardBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return CardTasarimSepet(binding)
    }
    override fun onBindViewHolder(holder: CardTasarimSepet, position: Int) {
        if (sepetListesi.isNotEmpty()) {
            val sepet = sepetListesi.get(position)
        val s = holder.sepetTasarim
        yemek_toplam_ucret = sepet.yemek_fiyat * sepet.yemek_siparis_adet


            s.textViewYad.text = sepet.yemek_adi
            s.textViewYFiyat.text = yemek_toplam_ucret.toString() + " ₺"
            s.textViewYAdet.text = sepet.yemek_siparis_adet.toString() + " Adet"
            // s.textViewYFiyat.text=toplamTutar.toString()+" ₺"

            val url = "http://kasimadalan.pe.hu/yemekler/resimler/${sepet.yemek_resim_adi}"
            Glide.with(mContext).load(url).override(150, 170).into(s.imageViewSResim)

            s.imageViewSil.setOnClickListener {
                Snackbar.make(
                    it,
                    "${sepet.yemek_adi} sepetten çıkarmak ister misiniz ? ",
                    Snackbar.LENGTH_SHORT
                )
                    .setAction("EVET") {
                        viewModel.sil(sepet.sepet_yemek_id)
                        viewModel.sepetYukle()
                    }.show()
            }

        }else{


        }
    }
     override fun getItemCount(): Int {
        return sepetListesi.size
     }



}