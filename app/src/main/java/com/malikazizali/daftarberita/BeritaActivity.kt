package com.malikazizali.daftarberita

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_berita.*

class BeritaActivity : AppCompatActivity() {
    lateinit var bvm : BeritaViewModel
    lateinit var adapterBerita : BeritaAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_berita)

        dataStudent()
        bvm = ViewModelProvider(this).get(BeritaViewModel::class.java)
        bvm.getNews()
        bvm.berita.observe(this, Observer {
            adapterBerita.setDataStudent(it as ArrayList<DataBerita>)
        })

    }

    fun dataStudent(){
        adapterBerita = BeritaAdapter(ArrayList())

        val layMan = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_berita.layoutManager = layMan
        rv_berita.adapter = adapterBerita

        adapterBerita.clicked ={
            val i = Intent(this, DetailBerita::class.java )
            i.putExtra("dataBerita",it)
            startActivity(i)
        }

    }
}