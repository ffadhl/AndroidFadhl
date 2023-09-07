package com.dicoding.androidfadhl

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListMadridAdapter (private val listMadrid: ArrayList<Madrid>) : RecyclerView.Adapter<ListMadridAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_madrid, parent, false)
        return ListViewHolder(view)
    }


    override fun getItemCount(): Int = listMadrid.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listMadrid[position]
        holder.imgPhoto.setImageResource(photo)
        holder.madridName.text = name
        holder.madridDescription.text = description

        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailMadridActivity::class.java)
            intentDetail.putExtra("key_Madrid", listMadrid[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_madrid_photo)
        val madridName: TextView = itemView.findViewById(R.id.madrid_player_name)
        val madridDescription: TextView = itemView.findViewById(R.id.madrid_player_description)
    }
}