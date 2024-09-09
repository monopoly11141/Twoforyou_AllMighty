package com.example.twoforyou_allmighty.feature_record.presentation.add_record

import com.example.twoforyou_allmighty.feature_record.domain.model.player.Player

sealed class AddRecordEvent {
    data object SaveRecord : AddRecordEvent()
    data class ChangedPlayerName(val playerIndex: Int, val name: String) : AddRecordEvent()
    data class ChangedPlayerScore(val player: Player, val score: Int) : AddRecordEvent()
    data class ChangedRecordTitle(val title: String) : AddRecordEvent()
}