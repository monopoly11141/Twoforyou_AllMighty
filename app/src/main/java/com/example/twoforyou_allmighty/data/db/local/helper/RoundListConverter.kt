package com.example.twoforyou_allmighty.data.db.local.helper

import androidx.room.TypeConverter
import com.example.twoforyou_allmighty.data.model.record.Round
import com.google.gson.Gson

class RoundListConverter {
        @TypeConverter
        fun listToJson(value: List<Round>?): String? {
            return Gson().toJson(value)
        }

        @TypeConverter
        fun jsonToList(value: String): List<Round>? {
            return Gson().fromJson(value, Array<Round>::class.java)?.toList()
        }

}