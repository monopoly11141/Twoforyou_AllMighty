package com.example.twoforyou_allmighty.feature_record.presentation.add_record

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.example.twoforyou_allmighty.MainCoroutineRule
import com.example.twoforyou_allmighty.feature_record.data.repository.FakeRecordRepository
import com.example.twoforyou_allmighty.feature_record.domain.model.record.Record
import com.example.twoforyou_allmighty.feature_record.domain.use_case.RecordUseCases
import com.example.twoforyou_allmighty.feature_record.domain.use_case.use_cases.AddRecord
import com.example.twoforyou_allmighty.feature_record.domain.use_case.use_cases.DeleteAllRecord
import com.example.twoforyou_allmighty.feature_record.domain.use_case.use_cases.DeleteRecord
import com.example.twoforyou_allmighty.feature_record.domain.use_case.use_cases.GetAllRecord
import com.example.twoforyou_allmighty.feature_record.domain.use_case.use_cases.GetRecordById
import com.example.twoforyou_allmighty.feature_record.presentation.record.RecordViewModel
import com.google.common.truth.Truth
import io.mockk.every
import io.mockk.mockk
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class AddRecordViewModelTest {
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private val recordUseCases = mockk<RecordUseCases>()

    private lateinit var record: Record

    @Before
    fun setUp() {

    }

    @Test
    fun `changed player name to Paul_name becomes Paul`() {
        val viewModel = AddRecordViewModel(recordUseCases)
        
        Truth.assertThat(viewModel.playerListState.toList()[0].name).isEqualTo("")

        viewModel.onEvent(AddRecordEvent.ChangedPlayerName(0, "Paul"))
        Truth.assertThat(viewModel.playerListState.toList()[0].name).isEqualTo("Paul")
    }
}