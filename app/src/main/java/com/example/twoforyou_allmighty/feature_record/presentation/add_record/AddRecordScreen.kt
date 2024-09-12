package com.example.twoforyou_allmighty.feature_record.presentation.add_record

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun AddRecordScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: AddRecordViewModel = hiltViewModel()
) {
    val playerListState = viewModel.playerListState
    val titleState = viewModel.titleState

    Scaffold { paddingValues ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            TextField(
                value = titleState.value.title,
                onValueChange = { title ->
                    viewModel.onEvent(AddRecordEvent.ChangedRecordTitle(title))
                },
                label = {
                    Text("제목을 입력하세요.")
                }
            )
            LazyColumn {
                items(playerListState.size) { index ->
                    TextField(
                        value = playerListState.toList()[index].name,
                        onValueChange = { name ->
                            viewModel.onEvent(AddRecordEvent.ChangedPlayerName(index, name))
                        },
                        label = {
                            Text("플레이어${index.plus(1)} 이름을 입력하세요.")
                        }
                    )
                }
            }

            Button(onClick = {
                viewModel.onEvent(AddRecordEvent.SaveRecord)
                navController.popBackStack()
            }) {
                Text(text = "저장")
            }
        }
    }
}