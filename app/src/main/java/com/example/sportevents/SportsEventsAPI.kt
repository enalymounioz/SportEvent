package com.example.sportevents

import retrofit2.http.GET

interface SportsEventsAPI {
    @GET("api/sports")
    suspend fun fetchSports(): List<ResponseItem>
}