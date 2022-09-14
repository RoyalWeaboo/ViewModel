package com.malikazizali.daftarberita

import java.io.Serializable

data class DataBerita(var gambar : Int, var judul : String, var jurnalis : String, var tanggal : String, var isi : String) : Serializable {
}