package com.example.roadlover.services

import com.example.roadlover.models.BankJson
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface Bankervice {
    @Headers("accept: application/json")
    @GET("Bank/GetAllBankList")
  suspend  fun getAllBanks(): Response<BankJson>
}