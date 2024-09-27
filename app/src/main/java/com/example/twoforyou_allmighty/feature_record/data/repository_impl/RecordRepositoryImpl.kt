package com.example.twoforyou_allmighty.feature_record.data.repository_impl

import com.example.twoforyou_allmighty.feature_record.data.db.RecordDao
import com.example.twoforyou_allmighty.feature_record.domain.model.record.Record
import com.example.twoforyou_allmighty.feature_record.domain.model.record.Round
import com.example.twoforyou_allmighty.feature_record.domain.repository.RecordRepository
import kotlinx.coroutines.flow.Flow

class RecordRepositoryImpl(
    private val recordDao: RecordDao
) : RecordRepository {

    override fun getAllRecord(): Flow<List<Record>> {
        return recordDao.getAllRecord()
    }

    override suspend fun getRecordById(id: Int): Record? {
        return recordDao.getRecordById(id)
    }

    override suspend fun insertRecord(record: Record) {
        recordDao.insertRecord(record)
    }

    override suspend fun deleteRecord(record: Record) {
        recordDao.deleteRecord(record)
    }

    override suspend fun deleteAllRecord() {
        recordDao.deleteAllRecord()
    }

    override suspend fun updateRecord(record: Record) {
        recordDao.updateRecord(record)
    }

}