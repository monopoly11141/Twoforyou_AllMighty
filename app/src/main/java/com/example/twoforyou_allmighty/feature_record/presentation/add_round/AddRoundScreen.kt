package com.example.twoforyou_allmighty.feature_record.presentation.add_round

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.twoforyou_allmighty.feature_record.presentation.add_round.component.PlayerRadioGroup
import com.example.twoforyou_allmighty.feature_record.presentation.add_round.component.TrickCounter
import com.example.twoforyou_allmighty.feature_record.presentation.add_round.component.TrumpSuitRadioGroup

@Composable
fun AddRoundScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    recordKey: Int,
    viewModel: AddRoundViewModel = hiltViewModel()
) {
    val addRoundUiState = viewModel.addRoundUiState
    val recordState = viewModel.recordState

    LaunchedEffect(key1 = true) {
        viewModel.onEvent(AddRoundEvent.InitRecord(recordKey))
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
        ) {
            PlayerRadioGroup(
                text = "마이티 플레이어: ",
                playerList = recordState.value.record.players,
                selectedPlayer = addRoundUiState.value.mightyPlayer,
                onClick = { player ->
                    viewModel.onEvent(AddRoundEvent.ChangedMightyPlayer(player))
                }
            )

            PlayerRadioGroup(
                text = "친구 플레이어: ",
                playerList = recordState.value.record.players,
                selectedPlayer = addRoundUiState.value.friendPlayer,
                onClick = { player ->
                    viewModel.onEvent(AddRoundEvent.ChangedFriendPlayer(player))
                }
            )

            TrickCounter(
                text = "공약 트릭 수 : ",
                trickNumber = addRoundUiState.value.pledgeTrickNumber,
                onPlusClick = {
                    viewModel.onEvent(AddRoundEvent.ChangedPledgeTrickNumber(addRoundUiState.value.pledgeTrickNumber + 1))
                },
                onMinusClick = {
                    if (addRoundUiState.value.pledgeTrickNumber > 0) {
                        viewModel.onEvent(AddRoundEvent.ChangedPledgeTrickNumber(addRoundUiState.value.pledgeTrickNumber - 1))
                    }
                }
            )

            TrickCounter(
                text = "실제 트릭 수 : ",
                trickNumber = addRoundUiState.value.actualTrickNumber,
                onPlusClick = {
                    viewModel.onEvent(AddRoundEvent.ChangedActualTrickNumber(addRoundUiState.value.actualTrickNumber + 1))
                },
                onMinusClick = {
                    if (addRoundUiState.value.actualTrickNumber > 0) {
                        viewModel.onEvent(AddRoundEvent.ChangedActualTrickNumber(addRoundUiState.value.actualTrickNumber - 1))
                    }
                },
            )

            TrumpSuitRadioGroup(
                text = "수트: ",
                selectedTrumpSuit = addRoundUiState.value.trumpSuit,
                onClick = { trumpSuit ->
                    viewModel.onEvent(AddRoundEvent.ChangedTrumpSuit(trumpSuit))
                }
            )

            Button(
                onClick = {
                    viewModel.onEvent(AddRoundEvent.SaveRound)
                    navController.popBackStack()
                }
            ) {
                Text(
                    text = "저장하기"
                )
            }

        }
    }
}

