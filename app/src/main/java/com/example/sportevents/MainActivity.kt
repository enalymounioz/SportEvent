package com.example.sportevents

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), SportsEventsAdapter.ItemActionListener {

    private lateinit var viewModel: SportsEventsViewModel
    private lateinit var adapter: SportsEventsAdapter

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

        // Set RecyclerView properties
        recyclerViewSports.layoutManager = LinearLayoutManager(this)

        viewModel = ViewModelProvider(this)[SportsEventsViewModel::class.java]

        // Observe events
        viewModel.sports.observe(this) { sports ->
            progressBar.visibility = View.GONE
            adapter = SportsEventsAdapter(sports.toMutableList(), this)
            recyclerViewSports.adapter = adapter
        }

        // Observe errors
        viewModel.error.observe(this) { error ->
            progressBar.visibility = View.GONE
            textViewError.visibility = View.VISIBLE
            textViewError.text = error
        }


        // Fetch and display the data (this method will be implemented next)
        fetchData()


    }

    override fun onSportToggle(position: Int) {
        // Handle the sport toggle logic here
    }

    override fun onFavoriteToggle(position: Int) {
        // Handle favorite toggle logic for both Sport and Event here
    }

    // Placeholder method, to be filled in the next steps
    private fun fetchData() {
        // API call and data binding logic will go here
    }
}