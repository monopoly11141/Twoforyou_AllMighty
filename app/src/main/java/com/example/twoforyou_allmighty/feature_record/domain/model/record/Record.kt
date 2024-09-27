package com.example.twoforyou_allmighty.feature_record.domain.model.record

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.twoforyou_allmighty.feature_record.domain.model.player.Player
import java.time.LocalDate

@Entity(tableName = "record_database")
data class Record(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String = "",
    val players : List<Player> = emptyList(),
    val round: List<Round> = listOf(),
    val currentRound: Int = 1,
    val maxRound : Int = 10,
    val timeStamp : Long = java.util.Date().time
)
