package com.example.twoforyou_allmighty.feature_record.presentation.record_detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.twoforyou_allmighty.feature_record.domain.model.record.Round

@Composable
fun RecordDetailScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    recordKey: Int,
    viewModel: RecordDetailViewModel = hiltViewModel()
) {
    LaunchedEffect(key1 = true) {
        viewModel.onEvent(RecordDetailEvent.InitRecord(recordKey))
    }

    Column {
        Text(text = viewModel.state.value.record.title)
        Text(text = viewModel.state.value.record.timeStamp.toString())

        LazyColumn {
            items(viewModel.state.value.record.round) { oneRound ->
                for (players in oneRound.players) {
                    Row {
                        Text(text = players.name)
                    }
                }
            }
        }

        Button(
            onClick = { viewModel.onEvent(RecordDetailEvent.AddRound(Round())) },
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text("라운드 추가")
        }
    }


}