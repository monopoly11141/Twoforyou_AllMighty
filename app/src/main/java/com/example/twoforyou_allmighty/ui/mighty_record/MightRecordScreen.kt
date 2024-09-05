package com.example.twoforyou_allmighty.ui.mighty_record

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun MightyRecordScreen(
    navController: NavController,
    viewModel: MightyRecordViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    Text("HELLO")

}