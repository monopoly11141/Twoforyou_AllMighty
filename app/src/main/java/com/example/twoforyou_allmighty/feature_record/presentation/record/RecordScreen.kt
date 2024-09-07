package com.example.twoforyou_allmighty.feature_record.presentation.record

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.twoforyou_allmighty.feature_record.domain.model.player.Player
import com.example.twoforyou_allmighty.feature_record.domain.model.record.Record
import com.example.twoforyou_allmighty.feature_record.presentation.record.component.RecordItem

@Composable
fun RecordScreen(
    navController: NavController,
    viewModel: RecordViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val scope = rememberCoroutineScope()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    viewModel.onEvent(RecordEvent.AddRecord(Record(
                        players = listOf(Player("a"), Player("b"), Player("c"), Player("d"), Player("e"))
                    )))
                },
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add note")
            }
        },
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                items(state.entireRecord) { record ->
                    RecordItem(record, {}, { viewModel.onEvent(RecordEvent.DeleteRecord(record)) })
                    HorizontalDivider()
                }
            }
        }
    }

}