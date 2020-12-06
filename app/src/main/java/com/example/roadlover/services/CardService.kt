package com.example.roadlover.services

import com.example.roadlover.models.BankJson
import com.example.roadlover.models.Card.Cards
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface CardService {

    @Headers("accept: application/json")
    @GET("Card/GetAllCardList")
    suspend  fun getAllCardList(): Response<Cards>
}