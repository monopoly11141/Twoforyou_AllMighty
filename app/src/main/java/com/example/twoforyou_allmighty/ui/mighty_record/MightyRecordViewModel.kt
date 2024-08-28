package com.example.twoforyou_allmighty.ui.mighty_record

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.twoforyou_allmighty.data.model.record.GameRecord
import com.example.twoforyou_allmighty.domain.mighty_record.MightyRecordRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MightyRecordViewModel @Inject constructor(
    private val repository: MightyRecordRepository
) : ViewModel() {

    private val _state = MutableStateFlow(MightyRecordUiState())
    val state = combine(
        repository.getAllGameRecord(),
        _state
    ) { array ->
        MightyRecordUiState(
            entireGameRecordList = array[0] as List<GameRecord>
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), _state.value)

    fun insertGameRecord(gameRecord: GameRecord) {
        viewModelScope.launch {
            repository.insertGameRecord(gameRecord)
        }
    }

    fun updateGameRecord(gameRecord: GameRecord) {
        viewModelScope.launch {
            repository.updateGameRecord(gameRecord)
        }
    }

    fun deleteGameRecord(gameRecord: GameRecord) {
        viewModelScope.launch {
            repository.deleteGameRecord(gameRecord)
        }
    }

    fun deleteAllGameRecord() {
        viewModelScope.launch {
            repository.deleteAllGameRecord()
        }
    }

}