package com.example.twoforyou_allmighty.feature_record.presentation.add_round

import com.example.twoforyou_allmighty.feature_record.domain.model.helper.Trump_Suit
import com.example.twoforyou_allmighty.feature_record.domain.model.player.Player
import com.example.twoforyou_allmighty.feature_record.domain.model.record.Round

data class AddRoundUiState(
    val mightyPlayer : Player,
    val friendPlayer : Player,
    val pledgeTrickNumber : Int,
    val actualTrickNumber : Int,
    val trumpSuit : Trump_Suit,
)