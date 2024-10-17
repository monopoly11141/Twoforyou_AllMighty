package com.example.twoforyou_allmighty.feature_record.presentation.add_round

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.twoforyou_allmighty.feature_record.domain.model.player.Player
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
                addRoundEvent = AddRoundEvent.ChangedMightyPlayer(addRoundUiState.value.mightyPlayer)
            )



//            PlayerRadioGroup(
//                text = "친구 플레이어: ",
//                playerList = recordState.value.record.players,
//                addRoundUiState.value.friendPlayer
//            )


        }
    }
}

