package com.example.twoforyou_allmighty.feature_record.presentation.record

import com.example.twoforyou_allmighty.feature_record.domain.model.record.Record

data class RecordUiState(
    val entireRecord: List<Record> = emptyList()
)