package com.example.twoforyou_allmighty.feature_record.presentation.record_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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

    fun initRecord(id: Int) {
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