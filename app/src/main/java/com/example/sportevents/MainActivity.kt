package com.example.sportevents

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
class MainActivity : AppCompatActivity(), SportAdapter.ItemActionListener {

    private lateinit var viewModel: SportsEventsViewModel
    private lateinit var adapter: SportAdapter

    private lateinit var recyclerViewSports: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var textViewError: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        recyclerViewSports = findViewById(R.id.recyclerViewSports)
        progressBar = findViewById(R.id.progressBar)
        textViewError = findViewById(R.id.textViewError)

        // Initialize the adapter
        adapter = SportAdapter(mutableListOf(), this)
        recyclerViewSports.adapter = adapter

        // Set RecyclerView properties
        recyclerViewSports.layoutManager = LinearLayoutManager(this)

        viewModel = ViewModelProvider(this)[SportsEventsViewModel::class.java]
        Log.d("MainActivity", "ViewModel initialized")

        // Observe events
        viewModel.sports.observe(this) { sports ->
            Log.d("SportsEventsViewModel", "Received ${sports.size} sports")
            progressBar.visibility = View.GONE
            adapter.updateData(sports)  // Assuming you added an updateData method to the SportAdapter

            recyclerViewSports.visibility = View.VISIBLE
        }

        // Observe errors
        viewModel.error.observe(this) { error ->
            Log.d("MainActivity", "Error observed: $error")
            progressBar.visibility = View.GONE
            textViewError.visibility = View.VISIBLE
            textViewError.text = error

            recyclerViewSports.visibility = View.GONE
        }
    }

    override fun onSportToggle(position: Int) {
    }
}
