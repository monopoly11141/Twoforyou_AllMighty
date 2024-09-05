package com.example.twoforyou_allmighty.ui.mighty_record

import com.example.twoforyou_allmighty.feature_record.domain.model.record.Record

data class MightyRecordUiState(
    val entireGameRecordList: List<Record> = emptyList()
)
