package com.example.sportevents

import android.util.Log
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class ResponseItemDeserializer : JsonDeserializer<ResponseItem> {
    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): ResponseItem {
        val jsonObject = json.asJsonObject

        // Extract common properties
        val sportId = jsonObject["i"]?.asString ?: ""
        val activeEvents = jsonObject["e"]?.let { context.deserialize<List<Event>>(it, object : TypeToken<List<Event>>() {}.type) }
        val id = jsonObject["id"]?.asString ?: ""
        val dElement = jsonObject["d"]


        return if (dElement.isJsonArray) {
            Log.d("Deserializer", "d is an array for sportId: $sportId")
            // If "d" is an array, deserialize it as a list of ResponseItem
            val nestedItems = context.deserialize<List<ResponseItem>>(dElement, object : TypeToken<List<ResponseItem>>() {}.type)
            ResponseItem(sportId = sportId, nestedItems = nestedItems, activeEvents = activeEvents, id = id)
        } else {
            Log.d("Deserializer", "d is a string for sportId: $sportId and sportName: ${dElement.asString}")
            // Otherwise, deserialize "d" as sportName
            val sportName = dElement.asString
            ResponseItem(sportId = sportId, sportName = sportName, activeEvents = activeEvents, id = id)
        }
    }
}
