package com.example.sportevents

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SportsEventsRepository {
    private val api = Retrofit.Builder()
        .baseUrl("https://618d3aa7fe09aa001744060a.mockapi.io/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(SportsEventsAPI::class.java)

    suspend fun fetchSports(): List<Sport> {
        return api.fetchSports()
    }
}
