package com.example.sportevents

data class ProcessedSportsData(
    val sportId: String,
    val sportName: String,
    var eventCount: Int,
    val activeEvents: List<Event>? = null  // Add this line
)