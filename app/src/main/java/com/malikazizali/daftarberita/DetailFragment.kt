package com.malikazizali.daftarberita

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getBeritaData()
    }

    fun getBeritaData(){
        val data = arguments?.getSerializable("dataBerita") as DataBerita
        detail_judul.text = data.judul
        detail_jurnalis.text = "Ditulis oleh ${data.jurnalis}"
        detail_gambar.setImageResource(data.gambar)
        detail_tgl_dan_isi.text = "${data.tanggal}, ${data.isi}"
    }

}