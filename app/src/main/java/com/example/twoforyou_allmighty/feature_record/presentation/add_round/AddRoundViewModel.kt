package com.example.twoforyou_allmighty.feature_record.presentation.add_round

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.twoforyou_allmighty.feature_record.domain.model.helper.Trump_Suit
import com.example.twoforyou_allmighty.feature_record.domain.model.player.Player
import com.example.twoforyou_allmighty.feature_record.domain.model.record.Record
import com.example.twoforyou_allmighty.feature_record.domain.model.record.Round
import com.example.twoforyou_allmighty.feature_record.domain.use_case.RecordUseCases
import com.example.twoforyou_allmighty.feature_record.presentation.util.PledgeUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddRoundViewModel @Inject constructor(
    private val recordUseCases: RecordUseCases,
) : ViewModel() {

    private val _addRoundUiState = mutableStateOf(
        AddRoundUiState(
            mightyPlayer = Player(),
            friendPlayer = Player(),
            pledgeTrickNumber = 0,
            actualTrickNumber = 0,
            trumpSuit = Trump_Suit.SPADE
        )
    )
    val addRoundUiState: State<AddRoundUiState> = _addRoundUiState

    private val _recordState = mutableStateOf(
        RecordUiState(
            record = Record()
        )
    )
    val recordState: State<RecordUiState> = _recordState

    fun onEvent(addRoundEvent: AddRoundEvent) {
        when (addRoundEvent) {

            is AddRoundEvent.Init -> {
                initRecord(addRoundEvent.recordKey, addRoundEvent.roundNumber)
            }

            is AddRoundEvent.ChangedActualTrickNumber -> {
                _addRoundUiState.value = _addRoundUiState.value.copy(
                    actualTrickNumber = addRoundEvent.actualTrickNumber
                )
            }

            is AddRoundEvent.ChangedFriendPlayer -> {
                _addRoundUiState.value = _addRoundUiState.value.copy(
                    friendPlayer = addRoundEvent.friendPlayer
                )
            }

            is AddRoundEvent.ChangedMightyPlayer -> {
                _addRoundUiState.value = _addRoundUiState.value.copy(
                    mightyPlayer = addRoundEvent.mightyPlayer
                )
            }

            is AddRoundEvent.ChangedPledgeTrickNumber -> {
                _addRoundUiState.value = _addRoundUiState.value.copy(
                    pledgeTrickNumber = addRoundEvent.pledgeTrickNumber
                )
            }

            is AddRoundEvent.ChangedTrumpSuit -> {
                _addRoundUiState.value = _addRoundUiState.value.copy(
                    trumpSuit = addRoundEvent.trumpSuit
                )
            }

            is AddRoundEvent.SaveRound -> {

                val round = Round(
                    mightyPlayer = _addRoundUiState.value.mightyPlayer,
                    friendPlayer = _addRoundUiState.value.friendPlayer,
                    pledgeTrickNumber = _addRoundUiState.value.pledgeTrickNumber,
                    actualTrickNumber = _addRoundUiState.value.actualTrickNumber,
                    trumpSuit = _addRoundUiState.value.trumpSuit,
                )

                val playersMutableList = _recordState.value.record.players.toMutableList()

                val pledgeTrickNumber = _addRoundUiState.value.pledgeTrickNumber
                val actualTrickNumber = _addRoundUiState.value.actualTrickNumber
                var score = 0

                val mightyPlayerIndex = playersMutableList.indexOf(_addRoundUiState.value.mightyPlayer)
                val friendPlayerIndex = playersMutableList.indexOf(_addRoundUiState.value.friendPlayer)

                if (actualTrickNumber >= pledgeTrickNumber) {
                    score = pledgeTrickNumber + actualTrickNumber - ((PledgeUtil.PLEDGE_DEFAULT_NUMBER - 1) * 2)

                    playersMutableList.forEachIndexed { index, player ->
                        when (index) {
                            mightyPlayerIndex -> {
                                playersMutableList[mightyPlayerIndex] = player.copy(
                                    score = _addRoundUiState.value.mightyPlayer.score.plus(score * 2)
                                )
                            }

                            friendPlayerIndex -> {
                                playersMutableList[friendPlayerIndex] = player.copy(
                                    score = _addRoundUiState.value.friendPlayer.score.plus(score)
                                )
                            }

                            else -> {
                                playersMutableList[index] = player.copy(
                                    score = player.score.minus(score)
                                )
                            }
                        }
                    }
                } else {
                    score = pledgeTrickNumber - actualTrickNumber

                    playersMutableList.forEachIndexed { index, player ->
                        when (index) {
                            mightyPlayerIndex -> {
                                playersMutableList[mightyPlayerIndex] = player.copy(
                                    score = _addRoundUiState.value.mightyPlayer.score.minus(score * 2)
                                )
                            }

                            friendPlayerIndex -> {
                                playersMutableList[friendPlayerIndex] = player.copy(
                                    score = _addRoundUiState.value.friendPlayer.score.minus(score)
                                )
                            }

                            else -> {
                                playersMutableList[index] = player.copy(
                                    score = player.score.plus(score)
                                )
                            }
                        }
                    }
                }
                viewModelScope.launch(Dispatchers.IO) {
                    _recordState.value = _recordState.value.copy(
                        record = Record(
                            id = _recordState.value.record.id,
                            title = _recordState.value.record.title,
                            players = playersMutableList,
                            round = _recordState.value.record.round.plus(round),
                            currentRound = _recordState.value.record.currentRound,
                            maxRound = _recordState.value.record.maxRound,
                            timeStamp = _recordState.value.record.timeStamp
                        )
                    )

                    Log.d("TAG", "${_recordState.value.record.players}")
                    recordUseCases.updateRecord(_recordState.value.record)
                }

            }

            is AddRoundEvent.ChangeRound -> {

            }


//                val round = Round(
//                    mightyPlayer = _addRoundUiState.value.mightyPlayer,
//                    friendPlayer = _addRoundUiState.value.friendPlayer,
//                    pledgeTrickNumber = _addRoundUiState.value.pledgeTrickNumber,
//                    actualTrickNumber = _addRoundUiState.value.actualTrickNumber,
//                    trumpSuit = _addRoundUiState.value.trumpSuit,
//                )
//
//                val roundMutableList = _recordState.value.record.round.toMutableList()
//                roundMutableList[addRoundEvent.roundNumber] = round
//
//                val playersMutableList = _recordState.value.record.players.toMutableList()
//
//                val pledgeTrickNumber = _addRoundUiState.value.pledgeTrickNumber
//                val actualTrickNumber = _addRoundUiState.value.actualTrickNumber
//                var score = 0
//
//                val mightyPlayerIndex = playersMutableList.indexOf(_addRoundUiState.value.mightyPlayer)
//                val friendPlayerIndex = playersMutableList.indexOf(_addRoundUiState.value.friendPlayer)
//
//                if (actualTrickNumber >= pledgeTrickNumber) {
//                    score = pledgeTrickNumber + actualTrickNumber - ((PledgeUtil.PLEDGE_DEFAULT_NUMBER - 1) * 2)
//
//                    playersMutableList[mightyPlayerIndex] = playersMutableList[mightyPlayerIndex].copy(
//                        name = _addRoundUiState.value.mightyPlayer.name,
//                        score = _addRoundUiState.value.mightyPlayer.score.plus(score * 2)
//                    )
//
//                    playersMutableList[friendPlayerIndex] = playersMutableList[friendPlayerIndex].copy(
//                        name = _addRoundUiState.value.friendPlayer.name,
//                        score = _addRoundUiState.value.friendPlayer.score.plus(score)
//                    )
//
//                    for (i in 0..4) {
//                        if (i == mightyPlayerIndex || i == friendPlayerIndex) {
//                            continue
//                        }
//                        playersMutableList[i] = playersMutableList[i].copy(
//                            name = playersMutableList[i].name,
//                            score = playersMutableList[i].score.minus(score)
//                        )
//                    }
//                } else {
//                    score = pledgeTrickNumber - actualTrickNumber
//
//                    playersMutableList[mightyPlayerIndex] = playersMutableList[mightyPlayerIndex].copy(
//                        name = _addRoundUiState.value.mightyPlayer.name,
//                        score = _addRoundUiState.value.mightyPlayer.score.minus(score * 2)
//                    )
//
//                    playersMutableList[friendPlayerIndex] = playersMutableList[friendPlayerIndex].copy(
//                        name = _addRoundUiState.value.friendPlayer.name,
//                        score = _addRoundUiState.value.friendPlayer.score.minus(score)
//                    )
//
//                    for (i in 0..4) {
//                        if (i == mightyPlayerIndex || i == friendPlayerIndex) {
//                            continue
//                        }
//                        playersMutableList[i] = playersMutableList[i].copy(
//                            name = playersMutableList[i].name,
//                            score = playersMutableList[i].score.plus(score)
//                        )
//                    }
//                }
//
//                viewModelScope.launch(Dispatchers.IO) {
//                    _recordState.value = _recordState.value.copy(
//                        record = Record(
//                            id = _recordState.value.record.id,
//                            title = _recordState.value.record.title,
//                            players = playersMutableList,
//                            round = roundMutableList,
//                            currentRound = _recordState.value.record.currentRound,
//                            maxRound = _recordState.value.record.maxRound,
//                            timeStamp = _recordState.value.record.timeStamp
//                        )
//                    )
//                    recordUseCases.updateRecord(_recordState.value.record)
//                }
        }
    }


    private fun initRecord(recordKey: Int, roundNumber: Int?) {
        viewModelScope.launch(Dispatchers.IO) {
            val record = recordUseCases.getRecordById(recordKey)
            record?.let {
                _recordState.value = RecordUiState(
                    record = record
                )
                roundNumber?.let {
                    val thisRound = record.round[roundNumber]
                    _addRoundUiState.value = AddRoundUiState(
                        mightyPlayer = thisRound.mightyPlayer,
                        friendPlayer = thisRound.friendPlayer,
                        pledgeTrickNumber = thisRound.pledgeTrickNumber,
                        actualTrickNumber = thisRound.actualTrickNumber,
                        trumpSuit = thisRound.trumpSuit
                    )
                }
            }

        }
    }

}