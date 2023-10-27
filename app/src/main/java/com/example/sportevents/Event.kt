package com.example.sportevents

data class Event(
    val i: String,
    val si: String,
    val d: String,
    val tt: Long,
    var isFavorite: Boolean = false
)