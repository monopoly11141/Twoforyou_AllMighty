package com.example.twoforyou_allmighty.feature_record.presentation.add_record

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddRecordViewModel @Inject constructor() : ViewModel() {


    fun onEvent(addRecordEvent: AddRecordEvent) {
        when (addRecordEvent) {
            is AddRecordEvent.ChangedPlayerName -> {

            }

            is AddRecordEvent.ChangedPlayerScore -> {

            }

            is AddRecordEvent.ChangedRecordTitle -> {

            }

            is AddRecordEvent.SaveRecord -> {

            }
        }
    }
}