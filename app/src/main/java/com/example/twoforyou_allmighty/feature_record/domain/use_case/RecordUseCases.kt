package com.example.twoforyou_allmighty.feature_record.domain.use_case

import com.example.twoforyou_allmighty.feature_record.domain.use_case.use_cases.AddRecord
import com.example.twoforyou_allmighty.feature_record.domain.use_case.use_cases.DeleteAllRecord
import com.example.twoforyou_allmighty.feature_record.domain.use_case.use_cases.DeleteRecord
import com.example.twoforyou_allmighty.feature_record.domain.use_case.use_cases.GetAllRecord

data class RecordUseCases(
    val addRecord: AddRecord,
    val deleteAllRecord: DeleteAllRecord,
    val deleteRecord: DeleteRecord,
    val getAllRecord: GetAllRecord
)