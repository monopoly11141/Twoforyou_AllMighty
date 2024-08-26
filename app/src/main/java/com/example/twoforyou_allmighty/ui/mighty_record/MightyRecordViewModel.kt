package com.example.twoforyou_allmighty.ui.mighty_record

import androidx.lifecycle.ViewModel
import com.example.twoforyou_allmighty.domain.mighty_record.MightyRecordRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MightyRecordViewModel @Inject constructor(
    private val repository: MightyRecordRepository
): ViewModel() {

}