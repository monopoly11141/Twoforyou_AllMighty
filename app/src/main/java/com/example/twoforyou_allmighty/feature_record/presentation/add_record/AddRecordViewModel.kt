package com.example.twoforyou_allmighty.feature_record.presentation.add_record

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotMutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddRecordViewModel @Inject constructor() : ViewModel() {

    private val _playerListState = mutableStateListOf(
        PlayerTextFieldUiState(
            hint = "플레이어 1"
        ),
        PlayerTextFieldUiState(
            hint = "플레이어 2"
        ),
        PlayerTextFieldUiState(
            hint = "플레이어 3"
        ),
        PlayerTextFieldUiState(
            hint = "플레이어 4"
        ),
        PlayerTextFieldUiState(
            hint = "플레이어 5"
        ),
    )
    val playerListState: SnapshotStateList<PlayerTextFieldUiState> = _playerListState

    fun onEvent(addRecordEvent: AddRecordEvent) {
        when (addRecordEvent) {
            is AddRecordEvent.ChangedPlayerName -> {
                _playerListState[addRecordEvent.playerIndex] = _playerListState[addRecordEvent.playerIndex].copy(
                    name = addRecordEvent.name
                )
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