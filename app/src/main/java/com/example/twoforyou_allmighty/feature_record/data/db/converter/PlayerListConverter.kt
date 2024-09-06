package com.example.twoforyou_allmighty.feature_record.data.db.converter

import androidx.room.TypeConverter
import com.example.twoforyou_allmighty.feature_record.domain.model.player.Player
import com.example.twoforyou_allmighty.feature_record.domain.model.record.Round
import com.google.gson.Gson

class PlayerListConverter {

    @TypeConverter
    fun listToJson(value: List<Player>?): String? {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun jsonToList(value: String): List<Player>? {
        return Gson().fromJson(value, Array<Player>::class.java)?.toList()
    }

}