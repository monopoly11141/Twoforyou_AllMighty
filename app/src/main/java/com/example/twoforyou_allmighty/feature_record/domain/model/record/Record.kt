package com.example.twoforyou_allmighty.feature_record.domain.model.record

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "record_database")
data class Record(
    @PrimaryKey(autoGenerate = true)
    val key: Int = 0,
    val round: List<Round> = emptyList(),
    val currentRound: Int = 1,
)
