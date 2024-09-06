package com.example.twoforyou_allmighty.feature_record.domain.repository

import com.example.twoforyou_allmighty.feature_record.domain.model.record.Record
import kotlinx.coroutines.flow.Flow

interface RecordRepository {
    fun getAllRecord(): Flow<List<Record>>

    suspend fun getRecordById(id: Int) : Record?

    suspend fun insertRecord(record: Record)

    suspend fun deleteRecord(record: Record)

    suspend fun deleteAllRecord()

}