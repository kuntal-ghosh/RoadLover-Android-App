package com.example.roadlover

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.roadlover.adapter.CardListAdapter
import com.example.roadlover.services.Bankervice
import com.example.roadlover.services.CardService
import com.example.roadlover.viewmodel.rcvCard
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CardListRecyclerView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_list_recycler_view)

        var itemList =mutableListOf<rcvCard>()

        val adapter=CardListAdapter(itemList)
        val recyclerView:RecyclerView=findViewById(R.id.cardImageRecyclerView)
        recyclerView.adapter=adapter
        recyclerView.layoutManager=LinearLayoutManager(this)


        val api: CardService = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CardService::class.java)


//        = mutableListOf<rcvCard>(
//            rcvCard("arnob"),
//            rcvCard("arnob"),
//            rcvCard("arnob"),
//            rcvCard("arnob"),
//            rcvCard("arnob"),
//            rcvCard("arnob"),
//
//            )

        lifecycleScope.launch(Dispatchers.IO) {
//            Log.d("response","get response")
            val response = api.getAllCardList()
            if(response.isSuccessful)
            {
                Log.d("response","get response")
                var cardContent = response.body()?.get(0)?.content
                Log.d("response",cardContent.toString())

                for (card in cardContent!!)
                {
                    Log.d("card",card.regUserProductImage.toString())
                    itemList.add(rcvCard(card.regUserProductImage.toString()))
                }

                withContext(Dispatchers.Main){
                    adapter.notifyDataSetChanged()

                }

                Log.d("response",itemList.toString())


            }


        }


        Log.d("before adapter",itemList.toString())


    }
}