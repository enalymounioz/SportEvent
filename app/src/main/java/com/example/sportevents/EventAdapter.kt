package com.example.sportevents

import android.os.CountDownTimer
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.concurrent.TimeUnit

class EventAdapter(
    private val events: List<Event>,
    private val listener: EventItemActionListener
) : RecyclerView.Adapter<EventAdapter.EventViewHolder>() {
    init {
        Log.d("EventAdapter", "Adapter initialized with ${events.size} events")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        Log.d("EventAdapter", "ViewHolder created for viewType: $viewType")
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_event, parent, false)
        return EventViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val event = events[position]
        Log.d("EventAdapter", "Binding event item at position: $position")

        holder.bind(event)
    }

    override fun getItemCount(): Int {
        Log.d("EventAdapter", "Fetching item count: ${events.size}")
        return events.size
    }




    interface EventItemActionListener {
        fun onFavoriteToggle(position: Int)

    }


    class EventViewHolder(itemView: View, private val listener: EventAdapter.EventItemActionListener) :
        RecyclerView.ViewHolder(itemView) {

        private val tvCompetitor1: TextView = itemView.findViewById(R.id.tvCompetitor1)
        private val tvCompetitor2: TextView = itemView.findViewById(R.id.tvCompetitor2)
        private val starImage: ImageView = itemView.findViewById(R.id.ivStar)
        private val countDown: TextView = itemView.findViewById(R.id.tvCountdown)

        var countDownTimer: CountDownTimer? = null
        var currentEvent: Event? = null


        fun bind(event: Event) {
            Log.d("EventViewHolder", "Binding event: $event")
            currentEvent = event

            // Stop any existing timer for this ViewHolder
            countDownTimer?.cancel()

            val currentTime = System.currentTimeMillis()
            val eventTime = event.eventStartTime * 1000L // Convert from seconds to milliseconds
            val countDownDuration = eventTime - currentTime

            countDownTimer = object : CountDownTimer(countDownDuration, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    val hours = TimeUnit.MILLISECONDS.toHours(millisUntilFinished)
                    val minutes = TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) % 60
                    val seconds = TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) % 60

                    countDown.text = String.format("%02d:%02d:%02d", hours, minutes, seconds)
                    Log.d("EventViewHolder", "Timer tick for event: ${currentEvent?.eventName}. Time left: ${countDown.text}")
                }

                override fun onFinish() {
                    countDown.text = "Event Started!"
                    Log.d("EventViewHolder", "Timer finished for event: ${currentEvent?.eventName}")
                }

            }.start()

            val competitors = event.eventName.split("-")
            if (competitors.size == 2) {
                tvCompetitor1.text = competitors[0].trim()
                tvCompetitor2.text = competitors[1].trim()
            }

            starImage.setImageResource(if (event.isFavorite) R.drawable.ic_star else R.drawable.ic_star_border) // Replace 'ic_star_filled' with your filled star drawable name
        }

        init {
            starImage.setOnClickListener {
                Log.d("EventViewHolder", "Star clicked for event: ${currentEvent?.eventName}")
                currentEvent?.let {
                    it.isFavorite = !it.isFavorite
                    listener.onFavoriteToggle(adapterPosition)  // Using the combined listener
                }
            }
        }
    }
}
