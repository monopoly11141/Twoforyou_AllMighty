package com.example.twoforyou_allmighty.feature_record.presentation.record.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.twoforyou_allmighty.feature_record.domain.model.record.Record

@Composable
fun RecordItem(
    record: Record,
    onClickItem : () -> Unit,
    onDeleteItemClicked : () -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClickItem() }
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            for(player in record.players) {
                Text("${player.name} : ${player.score}")
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        IconButton(
            onClick = onDeleteItemClicked,

            ) {
            Icon(
                imageVector = Icons.Default.Clear,
                contentDescription = "Delete",
                modifier = Modifier
                    .padding(4.dp)
            )
        }

    }
}