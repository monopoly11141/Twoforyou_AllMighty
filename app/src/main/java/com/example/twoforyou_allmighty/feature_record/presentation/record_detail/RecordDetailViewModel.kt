package com.example.twoforyou_allmighty.feature_record.presentation.record_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.twoforyou_allmighty.feature_record.domain.use_case.RecordUseCases
import com.example.twoforyou_allmighty.feature_record.presentation.record.RecordEvent
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
        when(recordDetailEvent) {
            is RecordDetailEvent.InitRecord -> {
                initRecord(recordDetailEvent.id)
            }

            is RecordDetailEvent.AddRound -> {
                viewModelScope.launch(Dispatchers.IO) {
//                    recordUseCases.add(recordDetailEvent.round, _state.value.record)
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