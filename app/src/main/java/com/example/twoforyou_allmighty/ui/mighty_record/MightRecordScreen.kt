package com.example.twoforyou_allmighty.ui.mighty_record

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.twoforyou_allmighty.data.model.record.GameRecord
import com.example.twoforyou_allmighty.navigation.Screen

@Composable
fun MightyRecordScreen(
    navController: NavController,
    viewModel: MightyRecordViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column {
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .padding(it)
            ) {
                items(state.entireGameRecordList) { record ->
                    Text(
                        text = "${record.key}",
                        modifier = Modifier
                            .clickable {
                                navController.navigate("${Screen.RecordDetailScreen.route}/${record.key}")
                            }
                    )
                    Icon(
                        imageVector = Icons.Filled.Delete,
                        contentDescription = "기록 지우기",
                        modifier = Modifier
                            .clickable {
                                viewModel.deleteGameRecord(record)
                            }
                    )
                    HorizontalDivider(color = Color.Black)
                }

            }
            FloatingActionButton(
                onClick = {
                    viewModel.insertGameRecord(GameRecord())
                },
                modifier = Modifier
                    .weight(0.2f)
            ) {
                Text(
                    text = "추가",
                    modifier = Modifier
                        .padding(4.dp)

                )
            }


        }

    }
}