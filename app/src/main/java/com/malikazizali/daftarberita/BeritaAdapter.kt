package com.malikazizali.daftarberita

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class BeritaAdapter (var listBerita: ArrayList<DataBerita>): RecyclerView.Adapter<BeritaAdapter.ViewHolder>(){
    var clicked : ((DataBerita)->Unit)? = null

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        var judul = view.findViewById<TextView>(R.id.tv_judul)
        var jurnalis = view.findViewById<TextView>(R.id.tv_jurnalis)
        var tanggal = view.findViewById<TextView>(R.id.tv_tanggal)
        var gambar = view.findViewById<ImageView>(R.id.img_berita)
        var isi = view.findViewById<TextView>(R.id.tv_isi)
        var card = view.findViewById<CardView>(R.id.cv_berita)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v  = LayoutInflater.from(parent.context).inflate(R.layout.item_berita, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.judul.text = listBerita[position].judul
        holder.jurnalis.text = listBerita[position].jurnalis
        holder.tanggal.text = listBerita[position].tanggal
        holder.isi.text = listBerita[position].isi
        holder.gambar.setImageResource(listBerita[position].gambar)
        holder.card.setOnClickListener {
            clicked?.invoke(listBerita[position])
        }
    }

    override fun getItemCount(): Int {
        return listBerita.size
    }

    fun setDataStudent(newsList : ArrayList<DataBerita>){
        this.listBerita = newsList
    }

}