package com.example.twoforyou_allmighty.feature_record.data.db.converter

import androidx.room.TypeConverter
import com.example.twoforyou_allmighty.feature_record.domain.model.record.Round
import com.google.gson.Gson

class RoundConverter {

    @TypeConverter
    fun listToJson(value: List<Round>?): String? {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun jsonToList(value: String): List<Round>? {
        return Gson().fromJson(value, Array<Round>::class.java)?.toList()
    }

}