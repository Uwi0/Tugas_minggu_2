package com.kakapo.tugas2.ui

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.kakapo.tugas2.R
import com.kakapo.tugas2.adapter.ListAdapter
import com.kakapo.tugas2.model.Anggota
import kotlinx.android.synthetic.main.activity_list_view.*

class ListView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)
        makeDialog()
    }

    fun makeList() : ArrayList<Anggota> {
        val list = ArrayList<Anggota>()
        list.apply {
            add(Anggota("Uwi", 899989, R.drawable.cat, "malang"))
            add(Anggota("Arul", 899989, R.drawable.cat, "malang"))
            add(Anggota("Aldo", 899989, R.drawable.cat, "malang"))
            add(Anggota("Riski", 899989, R.drawable.cat, "malang"))
        }

        return list
    }

    private fun makeDialog(){
        val listAnggota = makeList()
        val adapter = ListAdapter(listAnggota)
        list_view.adapter = adapter

        list_view.setOnItemClickListener { _, _, position, _ ->
            Dialog(this).apply {
                requestWindowFeature(Window.FEATURE_NO_TITLE)
                setCancelable(true)
                setContentView(R.layout.detail_list)

                val image: ImageView = this.findViewById(R.id.cat_image)
                val nama: TextView = this.findViewById(R.id.textName)
                val noHp: TextView = this.findViewById(R.id.textPhone)
                val alamat: TextView = this.findViewById(R.id.textAdrres)
                val close: Button = this.findViewById(R.id.close)

                val item = listAnggota[position]

                image.setImageResource(item.foto)
                nama.text = ("Nama : ${item.nama}")
                noHp.text = ("No Hp : ${item.noHP}")
                alamat.text = ("Alamat : ${item.alamat}")

                close.setOnClickListener{
                    this.dismiss()
                }
            }.show()
        }
    }

}