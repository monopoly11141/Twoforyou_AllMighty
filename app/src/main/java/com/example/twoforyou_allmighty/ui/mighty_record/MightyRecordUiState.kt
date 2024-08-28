package com.example.twoforyou_allmighty.ui.mighty_record

import com.example.twoforyou_allmighty.data.model.record.GameRecord

data class MightyRecordUiState(
    val entireGameRecordList: List<GameRecord> = emptyList()
)
