package com.example.twoforyou_allmighty.ui.mighty_record

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.twoforyou_allmighty.feature_record.domain.model.record.Record
import com.example.twoforyou_allmighty.feature_record.domain.repository.RecordRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MightyRecordViewModel @Inject constructor(
    private val repository: RecordRepository
) : ViewModel() {

    private val _state = MutableStateFlow(MightyRecordUiState())
    val state = combine(
        repository.getAllRecord(),
        _state
    ) { array ->
        MightyRecordUiState(
            entireGameRecordList = array[0] as List<Record>
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), _state.value)

}