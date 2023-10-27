package com.example.sportevents

import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.concurrent.TimeUnit

class SportsEventsAdapter(
    private val sportsEvents: List<Any>,
    private val listener: ItemActionListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val VIEW_TYPE_SPORT_HEADER = 1
        const val VIEW_TYPE_EVENT_ITEM = 2
    }

    override fun getItemViewType(position: Int): Int {
        return when (sportsEvents[position]) {
            is Sport -> VIEW_TYPE_SPORT_HEADER
            is Event -> VIEW_TYPE_EVENT_ITEM
            else -> throw IllegalArgumentException("Undefined view type at position $position")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            VIEW_TYPE_SPORT_HEADER -> {
                val view = inflater.inflate(R.layout.item_sport_header, parent, false)
                SportHeaderViewHolder(view, listener)  // Pass the listener
            }
            VIEW_TYPE_EVENT_ITEM -> {
                val view = inflater.inflate(R.layout.item_event, parent, false)
                EventItemViewHolder(view, listener)  // Pass the listener
            }
            else -> throw IllegalArgumentException("Undefined view type: $viewType")
        }
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = sportsEvents[position]) {
            is Sport -> {
                val sportHeaderHolder = holder as SportHeaderViewHolder
                sportHeaderHolder.bind(item)

                // Add listeners or other binding logic here for Sport
            }

            is Event -> {
                val eventItemHolder = holder as EventItemViewHolder
                eventItemHolder.bind(item)

                // Handle countdown logic and favorite button logic here for Event
            }
        }
    }

    override fun getItemCount(): Int = sportsEvents.size

    interface ItemActionListener {
        fun onSportToggle(position: Int)
        fun onFavoriteToggle(position: Int)
    }

    class SportHeaderViewHolder(itemView: View, private val listener: ItemActionListener) : RecyclerView.ViewHolder(itemView) {
        private val sportName: TextView = itemView.findViewById(R.id.tvSportName)

        fun bind(sport: Sport) {
            // Check the type of sport.d and set the text accordingly
            when (sport.d) {
                is String -> {
                    sportName.text = sport.d
                }

                is List<*> -> {
                    // If it's a list, you can join the items into a single string or handle it differently
                    sportName.text = (sport.d).joinToString(", ")
                }

                else -> {
                    // Handle unexpected type or set a default value
                    sportName.text = "Unknown"
                }
            }

            itemView.setOnClickListener {
                sport.isExpanded = !sport.isExpanded
                listener.onSportToggle(adapterPosition)  // Using the combined listener
            }
        }
    }


    class EventItemViewHolder(itemView: View, private val listener: ItemActionListener) : RecyclerView.ViewHolder(itemView) {
        // If your Event item has a TextView for its name
        private val eventName: TextView = itemView.findViewById(R.id.tvEventName)

        // The favorite button for your Event item
        private val favoriteButton: ImageButton = itemView.findViewById(R.id.btnFavorite)
        private val countDown: TextView = itemView.findViewById(R.id.tvCountdown)

        var countDownTimer: CountDownTimer? = null
        var currentEvent: Event? = null


        fun bind(event: Event) {
            currentEvent = event

            // Stop any existing timer for this ViewHolder
            countDownTimer?.cancel()

            val currentTime = System.currentTimeMillis()
            val eventTime = event.tt * 1000L // Convert from seconds to milliseconds
            val countDownDuration = eventTime - currentTime

            countDownTimer = object : CountDownTimer(countDownDuration, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    val hours = TimeUnit.MILLISECONDS.toHours(millisUntilFinished)
                    val minutes = TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) % 60
                    val seconds = TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) % 60

                    countDown.text = String.format("%02d:%02d:%02d", hours, minutes, seconds)
                }

                override fun onFinish() {
                    countDown.text = "Event Started!"
                }
            }.start()

            favoriteButton.isSelected = event.isFavorite
        }

        init {
            favoriteButton.setOnClickListener {
                currentEvent?.let {
                    it.isFavorite = !it.isFavorite
                    listener.onFavoriteToggle(adapterPosition)  // Using the combined listener
                }
            }
        }
    }
}
