package com.example.twoforyou_allmighty.feature_record.presentation.add_round

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.twoforyou_allmighty.feature_record.domain.model.helper.Trump_Suit
import com.example.twoforyou_allmighty.feature_record.presentation.add_round.component.NumberCounterGroup
import com.example.twoforyou_allmighty.feature_record.presentation.add_round.component.PlayerRadioGroup

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
                addRoundUiState.value.mightyPlayer,
                onClick = { player ->
                    viewModel.onEvent(AddRoundEvent.ChangedMightyPlayer(player))
                }
            )

            PlayerRadioGroup(
                text = "친구 플레이어: ",
                playerList = recordState.value.record.players,
                addRoundUiState.value.friendPlayer,
                onClick = { player ->
                    viewModel.onEvent(AddRoundEvent.ChangedFriendPlayer(player))
                }
            )

            NumberCounterGroup()

            NumberCounterGroup()

            var selectedTrumpSuitOption by remember { mutableStateOf(Trump_Suit.SPADE.name) }
            Row() {
                Trump_Suit.entries.forEach { trumpSuit ->
                    RadioButton(
                        selected = selectedTrumpSuitOption == trumpSuit.name,
                        onClick = { selectedTrumpSuitOption = trumpSuit.name }
                    )
                    Text(trumpSuit.name)
                }
            }

        }
    }
}

