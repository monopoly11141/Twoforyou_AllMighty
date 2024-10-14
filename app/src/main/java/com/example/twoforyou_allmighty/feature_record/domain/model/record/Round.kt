package com.example.twoforyou_allmighty.feature_record.domain.model.record

import com.example.twoforyou_allmighty.feature_record.domain.model.helper.Trump_Suit
import com.example.twoforyou_allmighty.feature_record.domain.model.player.Player

data class Round(
    val mightyPlayer : Player = Player(),
    val friendPlayer : Player = Player(),
    val pledgeTrickNumber : Int = 0,
    val actualTrickNumber : Int = 0,
    val trumpSuit : Trump_Suit = Trump_Suit.SPADE
)