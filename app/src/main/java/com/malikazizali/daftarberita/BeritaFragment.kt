package com.malikazizali.daftarberita

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_berita.*


class BeritaFragment : Fragment() {
    lateinit var bvm : BeritaViewModel
    lateinit var adapterBerita : BeritaAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_berita, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataStudent(view)
        bvm = ViewModelProvider(this).get(BeritaViewModel::class.java)
        bvm.getNews()
        bvm.berita.observe(viewLifecycleOwner, Observer {
            adapterBerita.setDataStudent(it as ArrayList<DataBerita>)
        })


    }
    fun dataStudent(view : View) {
        adapterBerita = BeritaAdapter(ArrayList())

        val layMan = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rv_berita.layoutManager = layMan
        rv_berita.adapter = adapterBerita

        adapterBerita.clicked = {
            var bun = Bundle()
            bun.putSerializable("dataBerita", it)

            Navigation.findNavController(view).navigate(R.id.action_beritaFragment_to_detailFragment, bun)
        }
    }

}