package com.example.sportevents

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SportAdapter(
    private val sports: MutableList<ProcessedSportsData>,
    private val listener: ItemActionListener
) : RecyclerView.Adapter<SportAdapter.SportViewHolder>() {

    interface ItemActionListener {
        fun onSportToggle(position: Int)
    }

    class SportViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val sportName: TextView = itemView.findViewById(R.id.tvSportName)
        val eventsRecyclerView: RecyclerView = itemView.findViewById(R.id.rvEvents)
        val headerLayout: LinearLayout = itemView.findViewById(R.id.headerLayout)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SportViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_sport_header, parent, false)
        return SportViewHolder(view)
    }


    override fun onBindViewHolder(holder: SportViewHolder, position: Int) {
        val sport = sports[position]
        Log.d("SportAdapter", "Binding sport item at position: $position")

        // Set Sport name
        holder.sportName.text = sport.sportName
        Log.d("SportAdapter", "Sport name set: ${sport.sportName}")

        // Set up the nested RecyclerView for events
        sport.activeEvents?.let { events ->
            Log.d("SportAdapter", "There are ${events.size} events for sport at position: $position")
            val eventAdapter = EventAdapter(events, object : EventAdapter.EventItemActionListener {
                override fun onFavoriteToggle(position: Int) {
                    // Handle the event toggle here, if needed
                }
            })
            holder.eventsRecyclerView.adapter = eventAdapter
            val gridLayoutManager = GridLayoutManager(holder.itemView.context, 4)
            holder.eventsRecyclerView.layoutManager = gridLayoutManager
            holder.eventsRecyclerView.isNestedScrollingEnabled = false
        }?: run {
            Log.d("SportAdapter", "No active events found for sport at position: $position")
        }

        // Click listener for the header layout
        holder.headerLayout.setOnClickListener {
            if (holder.eventsRecyclerView.visibility == View.VISIBLE) {
                holder.eventsRecyclerView.visibility = View.GONE
            } else {
                holder.eventsRecyclerView.visibility = View.VISIBLE
            }
            listener.onSportToggle(position)
        }
    }


    fun updateData(newData: List<ProcessedSportsData>) {
        Log.d("SportAdapter", "Updating data with ${sports.size} items")
        sports.clear()
        sports.addAll(newData)
        notifyDataSetChanged()
    }

    override fun getItemCount() = sports.size


}
