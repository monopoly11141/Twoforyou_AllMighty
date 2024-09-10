package com.example.twoforyou_allmighty.feature_record.presentation.add_record

import android.util.Log
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
    navController: NavController,
    viewModel: AddRecordViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {
    val state = viewModel.playerListState

    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            LazyColumn {
                Log.d("TAG", "AddRecordScreen : goes into ")
                items(state.size) { index ->
                    TextField(value = state.toList()[index].name, onValueChange = { name ->
                        viewModel.onEvent(AddRecordEvent.ChangedPlayerName(index, name))
                    })
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