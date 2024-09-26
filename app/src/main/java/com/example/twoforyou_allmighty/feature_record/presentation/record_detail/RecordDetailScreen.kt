package com.example.twoforyou_allmighty.feature_record.presentation.record_detail

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.twoforyou_allmighty.feature_record.presentation.add_record.AddRecordViewModel

@Composable
fun RecordDetailScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    recordKey: Int,
    viewModel: RecordDetailViewModel = hiltViewModel()
) {
    LaunchedEffect(key1 = true) {
        viewModel.initRecord(recordKey)
    }

    Column {
        Text(text = viewModel.state.value.record.title)
        Text(text = viewModel.state.value.record.timeStamp.toString())
    }

}