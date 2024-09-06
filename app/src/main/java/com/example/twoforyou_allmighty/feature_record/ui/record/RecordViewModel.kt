package com.example.twoforyou_allmighty.feature_record.ui.record

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.twoforyou_allmighty.feature_record.domain.use_case.RecordUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecordViewModel @Inject constructor(
    private val recordUseCases: RecordUseCases
) : ViewModel() {
    private val _state = mutableStateOf(RecordUiState())
    val state: State<RecordUiState> = _state

    private var getRecordJob: Job? = null

    init {
        getAllRecords()
    }

    fun onEvent(recordEvent: RecordEvent) {
        when (recordEvent) {
            is RecordEvent.AddRecord -> {
                viewModelScope.launch {
                    recordUseCases.addRecord(recordEvent.record)
                }
            }
            is RecordEvent.DeleteRecord -> {
                viewModelScope.launch {
                    recordUseCases.deleteRecord(recordEvent.record)
                }
            }
            is RecordEvent.DeleteAllRecord -> {
                viewModelScope.launch {
                    recordUseCases.deleteAllRecord()
                }
            }
        }
    }

    private fun getAllRecords() {
        getRecordJob?.cancel()
        getRecordJob = recordUseCases.getAllRecord()
            .onEach { record ->
                _state.value = state.value.copy(
                    entireRecord = record
                )
            }
            .launchIn(viewModelScope)
    }
}