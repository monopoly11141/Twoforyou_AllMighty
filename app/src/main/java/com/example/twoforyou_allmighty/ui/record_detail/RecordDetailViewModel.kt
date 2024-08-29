package com.example.twoforyou_allmighty.ui.record_detail

import androidx.lifecycle.ViewModel
import com.example.twoforyou_allmighty.domain.record_detail.RecordDetailRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RecordDetailViewModel @Inject constructor(
    private val recordDetailRepository: RecordDetailRepository
) : ViewModel() {


}