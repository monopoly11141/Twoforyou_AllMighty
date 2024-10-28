package com.example.twoforyou_allmighty.feature_record.presentation.record_detail

import com.example.twoforyou_allmighty.feature_record.domain.model.record.Round

sealed class RecordDetailEvent {
    data class InitRecord(val id: Int) : RecordDetailEvent()
    data class DeleteRound(val round: Round) : RecordDetailEvent()
}