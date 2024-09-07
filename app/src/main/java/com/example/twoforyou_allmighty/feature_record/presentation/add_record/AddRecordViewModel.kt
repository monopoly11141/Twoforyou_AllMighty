package com.example.twoforyou_allmighty.feature_record.presentation.add_record

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.twoforyou_allmighty.feature_record.domain.model.player.Player
import com.example.twoforyou_allmighty.feature_record.domain.use_case.RecordUseCases
import com.example.twoforyou_allmighty.feature_record.presentation.record.RecordEvent
import com.example.twoforyou_allmighty.feature_record.presentation.record.RecordUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddRecordViewModel: ViewModel() {
    private val _state = mutableStateOf(AddRecordUiState())
    val state: State<AddRecordUiState> = _state

    fun onEvent(addRecordEvent: AddRecordEvent) {
        when(addRecordEvent) {
            is AddRecordEvent.ChangedPlayerName -> {
                _state.value.players.let {
                    _state.value.players.find { it == addRecordEvent.player }?.name == "fads"
                }
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