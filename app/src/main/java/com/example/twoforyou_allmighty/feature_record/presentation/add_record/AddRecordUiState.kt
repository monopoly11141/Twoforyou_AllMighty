package com.example.twoforyou_allmighty.feature_record.presentation.add_record

import com.example.twoforyou_allmighty.feature_record.domain.model.player.Player

data class AddRecordUiState(
    val players: List<Player> = listOf<Player>().apply {
        repeat(5) { Player("a", 500) }
    }
)
