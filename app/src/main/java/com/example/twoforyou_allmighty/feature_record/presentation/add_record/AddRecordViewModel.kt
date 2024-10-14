package com.example.twoforyou_allmighty.feature_record.presentation.add_record

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.twoforyou_allmighty.feature_record.domain.model.player.Player
import com.example.twoforyou_allmighty.feature_record.domain.model.record.Record
import com.example.twoforyou_allmighty.feature_record.domain.model.record.Round
import com.example.twoforyou_allmighty.feature_record.domain.use_case.RecordUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddRecordViewModel @Inject constructor(
    private val recordUseCases: RecordUseCases
) : ViewModel() {

    private val _playerListState = mutableStateListOf(
        AddRecordPlayerTextFieldUiState(name = ""),
        AddRecordPlayerTextFieldUiState(name = ""),
        AddRecordPlayerTextFieldUiState(name = ""),
        AddRecordPlayerTextFieldUiState(name = ""),
        AddRecordPlayerTextFieldUiState(name = "")
    )

    val playerListState: SnapshotStateList<AddRecordPlayerTextFieldUiState> = _playerListState

    private val _titleState = mutableStateOf(
        AddRecordTitleUiState(
            title = ""
        )
    )
    val titleState: State<AddRecordTitleUiState> = _titleState

    fun onEvent(addRecordEvent: AddRecordEvent) {
        when (addRecordEvent) {
            is AddRecordEvent.ChangedPlayerName -> {
                _playerListState[addRecordEvent.playerIndex] = _playerListState[addRecordEvent.playerIndex].copy(
                    name = addRecordEvent.name
                )
            }

            is AddRecordEvent.ChangedPlayerScore -> {
                _playerListState[addRecordEvent.playerIndex] = _playerListState[addRecordEvent.playerIndex].copy(
                    score = addRecordEvent.score
                )
            }

            is AddRecordEvent.ChangedRecordTitle -> {
                _titleState.value = _titleState.value.copy(
                    title = addRecordEvent.title
                )
            }

            is AddRecordEvent.SaveRecord -> {
                val round = mutableListOf<Round>()

                for (i in 1..10) {
                    round.add(
                        Round()
                    )
                }

                viewModelScope.launch {
                    recordUseCases.addRecord(
                        Record(
                            id = 0,
                            title = _titleState.value.title,
                            players = _playerListState.toList().map { Player(it.name, it.score) },
                            round = round
                        )
                    )
                }
            }

        }
    }
}