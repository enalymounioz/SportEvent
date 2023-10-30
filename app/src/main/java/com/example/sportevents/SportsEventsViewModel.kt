package com.example.sportevents

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class SportsEventsViewModel : ViewModel() {
    private val repository = SportsEventsRepository.getInstance()

    private val _sports  = MutableLiveData<List<ProcessedSportsData>>()
    val sports: LiveData<List<ProcessedSportsData>> get() = _sports

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    init {
        fetchSports()
    }

    private fun fetchSports() {
        viewModelScope.launch {
            try {
                Log.d("SportsEventsViewModel", "Initiating fetch...")
                val fetchedSports = repository.fetchSports()

                // Log the fetched data
                Log.d("SportsEventsViewModel", "Fetched sports count before processing: ${fetchedSports.size}")
                fetchedSports.forEachIndexed { index, sport ->
                    Log.d("SportsEventsViewModel", "Sport at position $index before processing: $sport")
                }

                // Process the fetched data
                val processedSports = processSportsData(fetchedSports)

                Log.d("SportsEventsViewModel", "Fetch completed. Data processed. Setting LiveData...")
                _sports.value = processedSports
            } catch (e: Exception) {
                Log.e("SportsEventsViewModel", "Error fetching sports: ${e.message}")
                _error.value = e.message
            }
        }
    }

    fun processSportsData(response: List<ResponseItem>): List<ProcessedSportsData> {
        val sportsData = mutableListOf<ProcessedSportsData>()

        // Handling the case with null sportName
        val itemsWithNullSportName = response.filter { it.sportName == null }
        itemsWithNullSportName.forEach { item ->
            item.nestedItems?.forEach { nestedItem ->
                val existingItem = sportsData.find { it.sportId == nestedItem.sportId }
                if (existingItem != null) {
                    existingItem.eventCount += nestedItem.activeEvents?.size ?: 0
                } else {
                    sportsData.add(
                        ProcessedSportsData(
                            nestedItem.sportId,
                            nestedItem.sportName ?: "Unknown",
                            nestedItem.activeEvents?.size ?: 0,
                            nestedItem.activeEvents  // Adding activeEvents to ProcessedSportsData
                        )
                    )
                }
            }
        }

        // Process non-null sportName items
        response.filter { it.sportName != null }.forEach { item ->
            val existingItem = sportsData.find { it.sportId == item.sportId }
            if (existingItem != null) {
                existingItem.eventCount += item.activeEvents?.size ?: 0
            } else {
                sportsData.add(
                    ProcessedSportsData(
                        item.sportId,
                        item.sportName ?: "Unknown",
                        item.activeEvents?.size ?: 0,
                        item.activeEvents  // Adding activeEvents to ProcessedSportsData
                    )
                )
            }
        }

        return sportsData
    }
}
