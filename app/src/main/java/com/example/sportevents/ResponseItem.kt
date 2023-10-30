package com.example.sportevents

import com.google.gson.annotations.SerializedName

data class ResponseItem(
    @SerializedName("i") val sportId: String,
    @SerializedName("d")
    var sportName: String? = null,
    @SerializedName("d")
    var nestedItems: List<ResponseItem>? = null,
    @SerializedName("e") var activeEvents: List<Event>?,
    @SerializedName("id") val id: String? = null,
    var isExpanded: Boolean = false
) {
    companion object {
        fun getSportNameForEvent(responseItems: List<ResponseItem>, eventId: String): String? {
            // Create a map of sport id to sport name
            val sportIdToNameMap =
                responseItems.filter { it.sportId.isNotEmpty() && it.sportName != null }
                    .associate { it.sportId to it.sportName }

            // Search for the event and return its sport name using the map
            for (responseItem in responseItems) {
                responseItem.activeEvents?.let { events ->
                    for (event in events) {
                        if (event.eventId == eventId) {
                            return sportIdToNameMap[event.sportId]
                        }
                    }
                }
            }
            return null
        }
    }
}

//// Test
//val dataList: List<ResponseItem> = /* your decoded data list */
//val sportName = ResponseItem.getSportNameForEvent(dataList, "22911144")
//println(sportName)  // This should print "SOCCER"