package com.example.twoforyou_allmighty.feature_record.presentation.add_round

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun AddRoundScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    recordKey: Int,
    viewModel: AddRoundViewModel = hiltViewModel()
) {
    val addRoundUiState = viewModel.addRoundUiState
    val recordState = viewModel.recordState
    var isMightyPlayerDropdownMenuExpanded by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = true) {
        viewModel.onEvent(AddRoundEvent.InitRecord(recordKey))
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
        ) {

            //way to get input from user regarding number and player
            DropdownMenu(
                expanded = isMightyPlayerDropdownMenuExpanded,
                onDismissRequest = { /*TODO*/ }
            ) {

            }


        }
    }
}