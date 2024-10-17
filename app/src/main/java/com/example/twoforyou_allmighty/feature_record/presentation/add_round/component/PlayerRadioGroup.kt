package com.example.twoforyou_allmighty.feature_record.presentation.add_round.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.twoforyou_allmighty.feature_record.domain.model.player.Player
import com.example.twoforyou_allmighty.feature_record.presentation.add_round.AddRoundEvent
import com.example.twoforyou_allmighty.feature_record.presentation.add_round.AddRoundViewModel

@Composable
fun PlayerRadioGroup(
    text: String,
    playerList: List<Player>,
    selectedPlayer: Player,
    addRoundEvent: AddRoundEvent,
    viewModel: AddRoundViewModel = hiltViewModel()
) {
    Text(
        text = text,
    )
    Row() {
        playerList.forEach { player ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(vertical = 4.dp)
            ) {
                PlayerRadioButton(
                    selectedPlayer,
                    player
                ) {
                    addRoundEvent
                    viewModel.onEvent(AddRoundEvent.ChangedMightyPlayer(player))
                }
            }
        }
    }

}

@Composable
private fun PlayerRadioButton(
    selectedPlayer: Player,
    player: Player,
    onClick: () -> Unit
) {
    RadioButton(
        selected = selectedPlayer == player,
        onClick = { onClick() }
    )
    Text(
        text = player.name,
        style = MaterialTheme.typography.bodyLarge,
        modifier = Modifier.padding(start = 2.dp)
    )
}