package com.example.twoforyou_allmighty.domain.mighty_record

import com.example.twoforyou_allmighty.data.model.record.GameRecord
import kotlinx.coroutines.flow.Flow

interface MightyRecordRepository {

    fun getAllGameRecord() : Flow<List<GameRecord>>

    suspend fun insertGameRecord(gameRecord: GameRecord)

    suspend fun updateGameRecord(gameRecord: GameRecord)

    suspend fun deleteGameRecord(gameRecord: GameRecord)

    suspend fun deleteAllGameRecord()

}