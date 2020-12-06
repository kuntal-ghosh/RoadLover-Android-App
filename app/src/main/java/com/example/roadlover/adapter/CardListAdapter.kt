package com.example.roadlover.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.roadlover.R
import com.example.roadlover.viewmodel.rcvCard

class CardListAdapter( var cards:List<rcvCard>) : RecyclerView.Adapter<CardListAdapter.CardListViewHolder>() {
    inner class CardListViewHolder(itemview:View):RecyclerView.ViewHolder(itemview)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardListViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.card_listitem,parent,false)
        return CardListViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardListViewHolder, position: Int) {
        holder.itemView.apply {
            val cardImage:ImageView=findViewById(R.id.rcvCardImage)
//            Glide.with(getContext()).load(item.getImages()).into(iconView);
            Glide.with(this).load(cards[position].image).placeholder(R.drawable.finance)
                .into(cardImage);
            Log.d("image",cards[position].image.toString())


        }
    }

    override fun getItemCount(): Int {
    return  cards.size
    }

}