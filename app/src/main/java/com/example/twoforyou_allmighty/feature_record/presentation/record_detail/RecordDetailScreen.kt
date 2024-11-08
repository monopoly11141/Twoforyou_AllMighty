package com.example.twoforyou_allmighty.feature_record.presentation.record_detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.twoforyou_allmighty.feature_record.presentation.screen.Screen
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
                itemsIndexed(record.round) { i, oneRound ->
                    Row {
                        Text(
                            text = "라운드 ${i + 1}",
                        )
                        for (player in record.players) {
                            Text(
                                text = player.name,
                                color = when (player) {
                                    oneRound.mightyPlayer -> {
                                        Color.Red
                                    }

                                    oneRound.friendPlayer -> {
                                        Color.Yellow
                                    }

                                    else -> Color.Black
                                }
                            )
                            Spacer(
                                modifier = Modifier
                                    .size(4.dp)
                            )
                        }

                        IconButton(
                            onClick = {
                                navController.navigate("${Screen.AddRoundScreen.route}/${recordKey}/${i}")
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Edit,
                                contentDescription = "라운드 바꾸기"
                            )
                        }

                        IconButton(onClick = { viewModel.onEvent(RecordDetailEvent.DeleteRound(oneRound)) }) {
                            Icon(
                                imageVector = Icons.Filled.Clear,
                                contentDescription = "라운드 없애기"
                            )
                        }
                    }
                }

            }

            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                items(viewModel.state.value.record.players) { player ->
                    Text(
                        text = "${player.score}"
                    )
                }
            }

            Button(
                onClick = {
                    navController.navigate("${Screen.AddRoundScreen.route}/${recordKey}")
                },
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text("라운드 추가")
            }
        }
    }

}