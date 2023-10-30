package com.example.sportevents

import com.google.gson.annotations.SerializedName
data class Event(
    @SerializedName("i") val eventId: String,
    @SerializedName("si") val sportId: String,
    @SerializedName("d") val eventName: String,
    @SerializedName("sh") val shortHeader: String,
    @SerializedName("tt") val eventStartTime: Long,
    var isFavorite: Boolean = false
)