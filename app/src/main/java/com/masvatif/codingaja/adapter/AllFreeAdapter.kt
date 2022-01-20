package com.masvatif.codingaja.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.masvatif.codingaja.FreeClass
import com.masvatif.codingaja.R

class AllFreeAdapter(private val context: Context, private val freeclass: List<FreeClass>, val listener: (FreeClass) -> Unit)
    : RecyclerView.Adapter<AllFreeAdapter.AllFreeViewHolder>() {

    class AllFreeViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val imgClass = view.findViewById<ImageView>(R.id.img_item_photo)
        val nameClass = view.findViewById<TextView>(R.id.tv_class_name)
        val levelClass = view.findViewById<TextView>(R.id.tv_class_level)
        val descClass = view.findViewById<TextView>(R.id.tv_class_description)

        fun bindView(freeclass: FreeClass, listener: (FreeClass) -> Unit) {
            imgClass.setImageResource(freeclass.imgClass)
            nameClass.text = freeclass.nameClass
            levelClass.text = freeclass.levelClass
            descClass.text = freeclass.descClass
            itemView.setOnClickListener{
                listener(freeclass)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllFreeViewHolder {
        return AllFreeViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_kelas_gratis_all, parent, false)
        )
    }

    override fun onBindViewHolder(holder: AllFreeViewHolder, position: Int) {
        holder.bindView(freeclass[position], listener)
    }

    override fun getItemCount(): Int = freeclass.size
    }

