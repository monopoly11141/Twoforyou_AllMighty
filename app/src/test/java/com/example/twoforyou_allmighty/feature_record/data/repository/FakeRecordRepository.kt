package com.example.twoforyou_allmighty.feature_record.data.repository

import com.example.twoforyou_allmighty.feature_record.domain.model.record.Record
import com.example.twoforyou_allmighty.feature_record.domain.repository.RecordRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeRecordRepository() : RecordRepository {

    private val recordList = mutableListOf<Record>()

    override fun getAllRecord(): Flow<List<Record>> {
        return flow { emit(recordList) }
    }

    override suspend fun getRecordById(id: Int): Record? {
        return recordList.find { it.id == id }
    }

    override suspend fun insertRecord(record: Record) {
        recordList.add(record)
    }

    override suspend fun deleteRecord(record: Record) {
        recordList.remove(record)
    }

    override suspend fun deleteAllRecord() {
        recordList.clear()
    }


}