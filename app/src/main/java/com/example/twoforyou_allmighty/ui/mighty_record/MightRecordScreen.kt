package com.example.twoforyou_allmighty.ui.mighty_record

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.twoforyou_allmighty.navigation.Screen

@Composable
fun MightyRecordScreen(
    navController: NavController,
    viewModel: MightyRecordViewModel = hiltViewModel()
) {
    Text(text = "Hello Mighty Screen")
}