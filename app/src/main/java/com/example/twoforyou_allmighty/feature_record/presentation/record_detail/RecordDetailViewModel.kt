package com.example.twoforyou_allmighty.feature_record.presentation.record_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.twoforyou_allmighty.feature_record.domain.model.record.Record
import com.example.twoforyou_allmighty.feature_record.domain.use_case.RecordUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecordDetailViewModel @Inject constructor(
    private val recordUseCases: RecordUseCases
) : ViewModel() {
    private val _state = mutableStateOf(RecordDetailUiState())
    val state: State<RecordDetailUiState> = _state

    fun onEvent(recordDetailEvent: RecordDetailEvent) {
        when (recordDetailEvent) {
            is RecordDetailEvent.InitRecord -> {
                initRecord(recordDetailEvent.id)
            }

            is RecordDetailEvent.AddRound -> {
                viewModelScope.launch(Dispatchers.IO) {
                    _state.value = _state.value.copy(
                        record = Record(
                            id = _state.value.record.id,
                            title = _state.value.record.title,
                            players = _state.value.record.players,
                            round = _state.value.record.round.plus(recordDetailEvent.round),
                            currentRound = _state.value.record.currentRound,
                            maxRound = _state.value.record.maxRound,
                            timeStamp = _state.value.record.timeStamp
                        )
                    )
                    recordUseCases.updateRecord(_state.value.record)
                }
            }

            is RecordDetailEvent.ChangeMightyPlayer -> {
                viewModelScope.launch(Dispatchers.IO) {
                    val round = _state.value.record.round[recordDetailEvent.roundNumber].copy(
                        mightyPlayer = recordDetailEvent.mightyPlayer
                    )
                    _state.value = _state.value.copy(
                        record = Record(
                            id = _state.value.record.id,
                            title = _state.value.record.title,
                            players = _state.value.record.players,
                            round = _state.value.record.round.mapIndexed { index, it ->
                                if (index + 1 == recordDetailEvent.roundNumber) {
                                    round
                                } else {
                                    it
                                }
                            },
                            currentRound = _state.value.record.currentRound,
                            maxRound = _state.value.record.maxRound,
                            timeStamp = _state.value.record.timeStamp
                        )
                    )
                    recordUseCases.updateRecord(_state.value.record)
                }
            }

            is RecordDetailEvent.DeleteRound -> {
                viewModelScope.launch(Dispatchers.IO) {
                    _state.value = _state.value.copy(
                        record = Record(
                            id = _state.value.record.id,
                            title = _state.value.record.title,
                            players = _state.value.record.players,
                            round = _state.value.record.round.minus(recordDetailEvent.round),
                            currentRound = _state.value.record.currentRound,
                            maxRound = _state.value.record.maxRound,
                            timeStamp = _state.value.record.timeStamp
                        )
                    )
                    recordUseCases.updateRecord(_state.value.record)
                }
            }
        }

    }

    private fun initRecord(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val record = recordUseCases.getRecordById(id)
            record?.let {
                _state.value = RecordDetailUiState(
                    record = record
                )
            }
        }
    }

}