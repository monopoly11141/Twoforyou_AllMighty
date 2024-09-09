package com.example.twoforyou_allmighty.feature_record.presentation.player_setup

sealed class PlayerSetupEvent {
    data class ChangedPlayerName(val name: String) : PlayerSetupEvent()
    data class ChangedPlayerScore(val score: Int) : PlayerSetupEvent()
}