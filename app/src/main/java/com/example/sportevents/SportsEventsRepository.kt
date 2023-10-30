package com.example.sportevents

import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SportsEventsRepository private constructor() {

    // Use the default Gson instance, no custom deserializers
    private val gson = GsonBuilder()
        .registerTypeAdapter(ResponseItem::class.java, ResponseItemDeserializer())
        .create()


    private val logging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    private val client = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()

    private val api = Retrofit.Builder()
        .baseUrl("https://618d3aa7fe09aa001744060a.mockapi.io/")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create(gson)) // Use the default Gson instance
        .build()
        .create(SportsEventsAPI::class.java)

    suspend fun fetchSports(): List<ResponseItem> {
        return try {
            api.fetchSports()
        } catch (e: Exception) {
            Log.e("SportsEventsRepository", "Error fetching sports: ", e)
            // handle or log the exception
            emptyList()
        }
    }

    companion object {
        @Volatile private var instance: SportsEventsRepository? = null

        fun getInstance() =
            instance ?: synchronized(this) {
                instance ?: SportsEventsRepository().also { instance = it }
            }
    }
}
