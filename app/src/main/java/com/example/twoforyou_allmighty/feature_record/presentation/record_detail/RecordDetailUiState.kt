package com.example.twoforyou_allmighty.feature_record.presentation.record_detail

import com.example.twoforyou_allmighty.feature_record.domain.model.record.Record

data class RecordDetailUiState (
    val record : Record = Record()
)