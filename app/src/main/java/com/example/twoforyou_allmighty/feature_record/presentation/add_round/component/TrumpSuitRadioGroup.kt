package com.example.twoforyou_allmighty.feature_record.presentation.add_round.component

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.twoforyou_allmighty.feature_record.domain.model.helper.Trump_Suit
import com.example.twoforyou_allmighty.feature_record.domain.model.player.Player
import com.example.twoforyou_allmighty.feature_record.presentation.add_round.AddRoundViewModel

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun TrumpSuitRadioGroup(
    text: String,
    selectedTrumpSuit: Trump_Suit,
    onClick: (Trump_Suit) -> Unit
) {
    Text(
        text = text,
    )
    FlowRow(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Trump_Suit.entries.forEach { trumpSuit ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(vertical = 4.dp)
            ) {
                RadioButton(
                    selected = selectedTrumpSuit == trumpSuit,
                    onClick = { onClick(trumpSuit) }
                )
                Text(
                    text = trumpSuit.name,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(start = 2.dp)
                )
            }
        }
    }
}