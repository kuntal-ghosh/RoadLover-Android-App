package com.example.roadlover

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.roadlover.adapter.RecyclerViewAdapter
import com.example.roadlover.services.Bankervice
import kotlinx.coroutines.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

const val BASE_URL="http://192.144.82.82:8081/api/"

class RecyclerViewActivity : AppCompatActivity() {
    val TAG = "RecyclerActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        val api:Bankervice = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Bankervice::class.java)

        GlobalScope.launch(Dispatchers.IO) {
//            Log.d("response","get response")
            val response = api.getAllBanks()
            if(response.isSuccessful)
            {
                Log.d("response","get response")
                var bankContent = response.body()?.get(0)?.content?.get(0)?.bankName
                Log.d("response",bankContent.toString())

            }


        }

        val itemList = mutableListOf<Item>(
            Item("arnob"),
            Item("arnob"),
            Item("arnob"),
            Item("arnob"),
            Item("arnob"),
            Item("arnob"),

            )

        val adapter = RecyclerViewAdapter(itemList)
        val recyclerView: RecyclerView = findViewById(R.id.rcView)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = (LinearLayoutManager(this))

//        Launched a  corutine and calling network  in kotlin project

//        GlobalScope.launch(Dispatchers.IO) {
//            Log.d(TAG,"this is from thread ${Thread.currentThread().name}")
//            val answer=networkCall()
////            launch {
////                val answer2=networkCall()
////                Log.d(TAG,"this is answer2")
////
////            }
//            withContext(Dispatchers.Main){
//                Log.d(TAG,"this is from thread ${Thread.currentThread().name}")
//                Log.d(TAG,"this is from thread ${answer}")
//
//            }
//        }
//        Log.d(TAG,"this is from thread ${Thread.currentThread().name}")
//
//
//
//    }
//
//  a suspend function for coroutine


//    suspend fun networkCall(): String {
//        delay(3000L)
//        return "This is the result"
//    }
    }
  private fun  getAllBanks(){
        val api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Bankervice::class.java)

      GlobalScope.launch(Dispatchers.IO) {
          val banks  = api.getAllBanks()

          println(banks)


      }
    }
}


