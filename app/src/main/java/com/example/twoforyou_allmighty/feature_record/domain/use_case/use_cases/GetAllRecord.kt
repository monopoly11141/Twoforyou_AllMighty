package com.example.twoforyou_allmighty.feature_record.domain.use_case.use_cases

import com.example.twoforyou_allmighty.feature_record.domain.model.record.Record
import com.example.twoforyou_allmighty.feature_record.domain.repository.RecordRepository
import kotlinx.coroutines.flow.Flow

class GetAllRecord(
    private val recordRepository: RecordRepository
) {
    operator fun invoke(): Flow<List<Record>> {
        return recordRepository.getAllRecord()
    }
}