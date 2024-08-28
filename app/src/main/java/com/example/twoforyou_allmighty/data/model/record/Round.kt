package com.example.twoforyou_allmighty.data.model.record

import com.example.twoforyou_allmighty.data.model.helper.Trump_Suit
import com.example.twoforyou_allmighty.data.model.player.Player

data class Round(
    val players: List<Player> = listOf(),
    val mightyPlayer : Player = Player(),
    val friendPlayer : Player = Player(),
    val pledgeTrickNumber : Int = 0,
    val actualTrickNumber : Int = 0,
    val trumpSuit : Trump_Suit = Trump_Suit.SPADE
)