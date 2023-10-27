package com.example.sportevents

data class Sport(
    val i: String,
    val d: Any,
    val e: List<Event>,
    var isExpanded: Boolean = false
)