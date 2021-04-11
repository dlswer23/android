package com.example.recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView

class Adapter(val context: Context,val dataList : ArrayList<Data>): RecyclerView.Adapter<Adapter.Holder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.activity_main, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Adapter.Holder, position: Int) {
        holder?.bind(dataList[position], context)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        val dataname = itemView?.findViewById<TextView>(R.id.name_tv)
        val dataage = itemView?.findViewById<TextView>(R.id.age_tv)
        val dataphoto = itemView?.findViewById<ImageView>(R.id.imageView)


        fun bind(data: Data, context: Context) {

            if(data.photo != ""){
                    val resourceId = context.resources.getIdentifier(data.photo, "drawable", context.packageName)
                    dataphoto?.setImageResource(resourceId)
                } else {
                    dataphoto?.setImageResource(R.mipmap.ic_launcher)
                }
            dataname?.text = data.name
            dataage?.text = data.age

            }
        }
    }
