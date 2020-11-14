package com.kakapo.tugas2.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.kakapo.tugas2.R
import com.kakapo.tugas2.model.Anggota

class ListAdapter(private val data: ArrayList<Anggota>?) : BaseAdapter(){
    override fun getCount(): Int = data?.size ?: 0

    override fun getItem(position: Int): Any {
        return data?.get(position) ?: ""
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.list_item, parent, false)

        val nama: TextView = view.findViewById(R.id.name_list)
        val foto: ImageView = view.findViewById(R.id.image)

        val item = data?.get(position)
        foto.setImageResource(item?.foto ?: 0)
        nama.text = item?.nama

        return view
    }

}