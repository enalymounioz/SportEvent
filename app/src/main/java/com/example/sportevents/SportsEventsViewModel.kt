package com.example.sportevents

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class SportsEventsViewModel : ViewModel() {
    private val repository = SportsEventsRepository()

    private val _sports  = MutableLiveData<List<Sport>>()
    val sports: LiveData<List<Sport>> get() = _sports


    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    init {
        fetchSports()
    }

    private fun fetchSports() {
        viewModelScope.launch {
            try {
                val fetchedSports = repository.fetchSports()
                _sports.value = fetchedSports
            } catch (e: Exception) {
                _error.value = e.message
            }
        }
    }

}
