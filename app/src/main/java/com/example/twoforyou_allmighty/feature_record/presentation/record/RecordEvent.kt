package com.example.twoforyou_allmighty.feature_record.presentation.record

import com.example.twoforyou_allmighty.feature_record.domain.model.record.Record

sealed class RecordEvent {
    data class AddRecord(val record: Record) : RecordEvent()
    data class DeleteRecord(val record: Record) : RecordEvent()
}