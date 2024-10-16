package com.example.twoforyou_allmighty.feature_record.presentation.add_round

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.twoforyou_allmighty.feature_record.domain.model.player.Player
import com.example.twoforyou_allmighty.feature_record.presentation.add_round.component.PlayerRadioButton

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
            Text(
                text = "마이티 플레이어 : "
            )
            Row() {
                recordState.value.record.players.forEach { player ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(vertical = 4.dp)
                    ) {
                        RadioButton(
                            selected = addRoundUiState.value.mightyPlayer == player,
                            onClick = {
                                viewModel.onEvent(AddRoundEvent.ChangedMightyPlayer(player))
                            }
                        )
                        Text(
                            text = player.name,
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.padding(start = 2.dp)
                        )
                    }
                }
            }

        }
    }
}