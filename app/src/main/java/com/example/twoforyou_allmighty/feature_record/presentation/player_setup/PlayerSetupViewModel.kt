package com.example.twoforyou_allmighty.feature_record.presentation.player_setup

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.twoforyou_allmighty.feature_record.domain.model.player.Player
import com.example.twoforyou_allmighty.feature_record.presentation.record.RecordEvent
import com.example.twoforyou_allmighty.feature_record.presentation.record.RecordUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlayerSetupViewModel @Inject constructor() : ViewModel() {

    private val _state = mutableStateOf(PlayerSetupUiState("player", 0))
    val state : State<PlayerSetupUiState> = _state

    fun onEvent(playerSetupEvent: PlayerSetupEvent) {
        when (playerSetupEvent) {
            is PlayerSetupEvent.ChangedPlayerName -> {
                _state.value = _state.value.copy(
                    name = playerSetupEvent.name
                )
            }
            is PlayerSetupEvent.ChangedPlayerScore -> {
                _state.value = _state.value.copy(
                    score = playerSetupEvent.score
                )
            }
        }
    }
}