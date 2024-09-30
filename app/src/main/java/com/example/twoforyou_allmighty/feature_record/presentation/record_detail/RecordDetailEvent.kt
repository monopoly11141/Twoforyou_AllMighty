package com.example.twoforyou_allmighty.feature_record.presentation.record_detail

import com.example.twoforyou_allmighty.feature_record.domain.model.player.Player
import com.example.twoforyou_allmighty.feature_record.domain.model.record.Record
import com.example.twoforyou_allmighty.feature_record.domain.model.record.Round
import com.example.twoforyou_allmighty.feature_record.presentation.record.RecordEvent

sealed class RecordDetailEvent {
    data class InitRecord(val id: Int) : RecordDetailEvent()
    data class AddRound(val round: Round) : RecordDetailEvent()
    data class ChangeMightyPlayer(val roundNumber: Int, val mightyPlayer: Player) : RecordDetailEvent()
}