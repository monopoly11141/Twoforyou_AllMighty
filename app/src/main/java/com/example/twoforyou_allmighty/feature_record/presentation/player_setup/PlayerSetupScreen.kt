package com.example.twoforyou_allmighty.feature_record.presentation.player_setup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun PlayerSetupScreen(
    navController: NavController,
    viewModel: PlayerSetupViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {

    val state = viewModel.state.value

    Scaffold { paddingValues ->
        Column(
            modifier = modifier
                .padding(paddingValues)
        ) {
            TextField(
                value = state.name,
                onValueChange = {
                    viewModel.onEvent(PlayerSetupEvent.ChangedPlayerName(state.name))
                }
            )
            TextField(
                value = state.score.toString(),
                onValueChange = {
                    viewModel.onEvent(PlayerSetupEvent.ChangedPlayerScore(state.score))
                }
            )
        }
    }
}