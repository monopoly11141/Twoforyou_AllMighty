package com.example.twoforyou_allmighty.data.model.record

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "game_record_database")
data class GameRecord(
    @PrimaryKey(autoGenerate = true)
    val key: Int,
    val round: List<Round>,
    val currentRound: Int,
)
