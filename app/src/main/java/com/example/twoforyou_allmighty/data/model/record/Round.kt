package com.example.twoforyou_allmighty.data.model.record

import com.example.twoforyou_allmighty.data.model.helper.Trump_Suit
import com.example.twoforyou_allmighty.data.model.player.Player

data class Round(
    val players: List<Player> = listOf(),
    val mightyPlayer : Player,
    val friendPlayer : Player,
    val pledgeTrickNumber : Int,
    val actualTrickNumber : Int,
    val trumpSuit : Trump_Suit
)