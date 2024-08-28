package com.example.twoforyou_allmighty.data.mighty_record

import com.example.twoforyou_allmighty.data.db.local.GameRecordDao
import com.example.twoforyou_allmighty.data.model.record.GameRecord
import com.example.twoforyou_allmighty.domain.mighty_record.MightyRecordRepository
import kotlinx.coroutines.flow.Flow

class MightyRecordRepositoryImpl(
    private val gameRecordDao: GameRecordDao
) : MightyRecordRepository {

    override fun getAllGameRecord(): Flow<List<GameRecord>> {
        return gameRecordDao.getAllGameRecord()
    }

    override suspend fun insertGameRecord(gameRecord: GameRecord) {
        gameRecordDao.insertGameRecord(gameRecord)
    }

    override suspend fun updateGameRecord(gameRecord: GameRecord) {
        gameRecordDao.updateGameRecord(gameRecord)
    }

    override suspend fun deleteGameRecord(gameRecord: GameRecord) {
        gameRecordDao.deleteGameRecord(gameRecord)
    }

    override suspend fun deleteAllGameRecord() {
        gameRecordDao.deleteAllGameRecord()
    }

}