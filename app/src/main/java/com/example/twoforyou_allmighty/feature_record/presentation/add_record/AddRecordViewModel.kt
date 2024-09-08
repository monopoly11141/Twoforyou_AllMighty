package com.example.twoforyou_allmighty.feature_record.presentation.add_record

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.twoforyou_allmighty.feature_record.domain.model.player.Player
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddRecordViewModel @Inject constructor(): ViewModel() {
    private val _state = mutableStateOf(AddRecordUiState())

    val state: State<AddRecordUiState> = _state

    fun onEvent(addRecordEvent: AddRecordEvent) {
        when (addRecordEvent) {
            is AddRecordEvent.ChangedPlayerName -> {
                _state.value = _state.value.copy(
                    players = _state.value.players.also { players ->
                        players.find{it == addRecordEvent.player}?.copy(
                            name = addRecordEvent.name
                        )
                    }
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