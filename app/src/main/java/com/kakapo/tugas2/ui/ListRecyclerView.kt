package com.kakapo.tugas2.ui

import android.app.Dialog
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.kakapo.tugas2.R
import com.kakapo.tugas2.adapter.RecyclerViewAdapter
import com.kakapo.tugas2.model.Anggota
import kotlinx.android.synthetic.main.activity_list_recycler_view.*

class ListRecyclerView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_recycler_view)
        makeDialogRecyclerView()
    }


    private fun makeDialogRecyclerView(){
        val listAnggota = ListView().makeList()
        recycler_view.adapter =  RecyclerViewAdapter(this, listAnggota, object: RecyclerViewAdapter.OnClickListener{
            override fun detailData(item: Anggota?) {

                Dialog(this@ListRecyclerView).apply {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    setCancelable(true)
                    setContentView(R.layout.detail_list)


                    val image: ImageView = this.findViewById(R.id.cat_image)
                    val nama: TextView = this.findViewById(R.id.textName)
                    val noHp: TextView = this.findViewById(R.id.textPhone)
                    val alamat: TextView = this.findViewById(R.id.textAdrres)
                    val close: Button = this.findViewById(R.id.close)


                    image.setImageResource(item?.foto ?: 0)
                    nama.text = ("Nama : ${item?.nama}")
                    noHp.text = ("No Hp : ${item?.noHP}")
                    alamat.text = ("Alamat : ${item?.alamat}")

                    close.setOnClickListener {
                        this.dismiss()
                    }

                    close.setOnClickListener {
                        this.dismiss()
                    }
                }.show()
            }
        })
    }
}