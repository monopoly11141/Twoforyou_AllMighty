package com.example.twoforyou_allmighty.feature_record.domain.use_case.use_cases

import com.example.twoforyou_allmighty.feature_record.domain.model.record.Record
import com.example.twoforyou_allmighty.feature_record.domain.model.record.Round
import com.example.twoforyou_allmighty.feature_record.domain.repository.RecordRepository

class UpdateRecord(
    private val recordRepository: RecordRepository
) {
    suspend operator fun invoke(record: Record) {
        recordRepository.updateRecord(record)
    }
}