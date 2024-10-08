package com.example.twoforyou_allmighty.feature_record.presentation.record_detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.twoforyou_allmighty.feature_record.domain.model.record.Round
import com.example.twoforyou_allmighty.feature_record.presentation.util.TimeUtil

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

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
        ) {
            val record = viewModel.state.value.record
            Text(text = record.title)

            Text(text = TimeUtil.timeStampToTimeString(record.timeStamp))

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
            ) {
                items(record.round) { oneRound ->
                    Row {
                        Text(
                            text = "라운드 ${oneRound.roundNumber}",
                        )
                        for (players in record.players) {
                            Text(text = players.name)
                            Spacer(
                                modifier = Modifier
                                    .size(4.dp)
                            )
                        }
                    }
                }


            }

            Button(
                onClick = {
                    viewModel.onEvent(
                        RecordDetailEvent.AddRound(
                            Round(
                                roundNumber = record.round.size + 1
                            )
                        )
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text("라운드 추가")
            }
        }
    }

}