package com.kakapo.tugas2.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kakapo.tugas2.R

import com.kakapo.tugas2.model.Anggota

class RecyclerViewAdapter(
    private val context: Context,
    private val data: ArrayList<Anggota>?,
    private val itemClick: RecyclerViewAdapter.OnClickListener
) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view){
        val foto: ImageView = view.findViewById(R.id.image)
        var nama: TextView = view.findViewById(R.id.name_list)
    }

    interface OnClickListener{
        fun detailData(item: Anggota?)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data?.get(position)

        holder.foto.setImageResource(item?.foto ?: 0)
        holder.nama.text = item?.nama

        holder.view.setOnClickListener {
            itemClick.detailData(item)
        }
    }

    override fun getItemCount(): Int = data?.size ?: 0

}