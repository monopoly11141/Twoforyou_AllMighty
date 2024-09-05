package com.example.twoforyou_allmighty.feature_record.domain.use_case.use_cases

import com.example.twoforyou_allmighty.feature_record.domain.repository.RecordRepository

class DeleteAllRecord(
    private val recordRepository: RecordRepository
) {
    suspend operator fun invoke() {
        recordRepository.deleteAllRecord()
    }
}