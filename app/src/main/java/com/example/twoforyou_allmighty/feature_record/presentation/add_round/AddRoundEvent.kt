package com.example.twoforyou_allmighty.feature_record.presentation.add_round

import com.example.twoforyou_allmighty.feature_record.domain.model.helper.Trump_Suit
import com.example.twoforyou_allmighty.feature_record.domain.model.player.Player

sealed class AddRoundEvent {
    data class Init(val recordKey: Int, val roundNumber: Int?) : AddRoundEvent()
    data object SaveRound : AddRoundEvent()
    data class ChangeRound(val roundNumber: Int) : AddRoundEvent()
    data class ChangedMightyPlayer(val mightyPlayer: Player) : AddRoundEvent()
    data class ChangedFriendPlayer(val friendPlayer: Player) : AddRoundEvent()
    data class ChangedPledgeTrickNumber(val pledgeTrickNumber: Int) : AddRoundEvent()
    data class ChangedActualTrickNumber(val actualTrickNumber: Int) : AddRoundEvent()
    data class ChangedTrumpSuit(val trumpSuit: Trump_Suit) : AddRoundEvent()
}