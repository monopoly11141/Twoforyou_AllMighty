package com.example.twoforyou_allmighty.ui.record_detail

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.twoforyou_allmighty.ui.mighty_record.MightyRecordViewModel

@Composable
fun RecordDetailScreen(
    navController: NavController,
    recordKey: Int,
    viewModel: RecordDetailViewModel = hiltViewModel()
) {
    Text("Record Detail Screen with key : $recordKey")
}