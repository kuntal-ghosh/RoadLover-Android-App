package com.example.roadlover.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.roadlover.Item
import com.example.roadlover.R
import org.w3c.dom.Text

class RecyclerViewAdapter(var items:List<Item>): RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>() {

    inner class RecyclerViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.recycler_item,parent,false)
        return  RecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.itemView.apply {
            val textView:TextView=findViewById(R.id.textView3)

            textView.text=items[position].text
        }
    }

    override fun getItemCount(): Int {
       return  items.size
    }
}