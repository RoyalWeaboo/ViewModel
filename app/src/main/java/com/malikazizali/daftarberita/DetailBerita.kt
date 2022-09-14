package com.malikazizali.daftarberita

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail_berita.*

class DetailBerita : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_berita)
        getBeritaData()
    }

    fun getBeritaData(){
        val data = intent.getSerializableExtra("dataBerita") as DataBerita
        detail_judul.text = data.judul
        detail_jurnalis.text = "Ditulis oleh ${data.jurnalis}"
        detail_gambar.setImageResource(data.gambar)
        detail_tgl_dan_isi.text = "${data.tanggal}, ${data.isi}"
    }
}