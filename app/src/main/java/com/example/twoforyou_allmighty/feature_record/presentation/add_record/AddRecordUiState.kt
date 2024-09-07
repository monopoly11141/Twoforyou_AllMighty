package com.example.twoforyou_allmighty.feature_record.presentation.add_record

import com.example.twoforyou_allmighty.feature_record.domain.model.player.Player

data class AddRecordUiState(
    var players: List<Player> = listOf<Player>().apply {
        repeat(5) { Player() }
    }
)
