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
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class AddRecordViewModelTest {
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private lateinit var fakeRecordRepository: FakeRecordRepository

    private val recordUseCases = mockk<RecordUseCases>(relaxed = true)

    private lateinit var record: Record
    private lateinit var addRecordViewModel: AddRecordViewModel

    @Before
    fun setUp() {
        addRecordViewModel = AddRecordViewModel(recordUseCases)
        fakeRecordRepository = FakeRecordRepository()

        every { recordUseCases.addRecord } returns AddRecord(fakeRecordRepository)
        every { recordUseCases.getAllRecord } returns GetAllRecord(fakeRecordRepository)

    }

    @Test
    fun `changed player name to Paul_name becomes Paul`() {
        Truth.assertThat(addRecordViewModel.playerListState.toList()[0].name).isEqualTo("")

        addRecordViewModel.onEvent(AddRecordEvent.ChangedPlayerName(0, "Paul"))
        Truth.assertThat(addRecordViewModel.playerListState.toList()[0].name).isEqualTo("Paul")
    }

    @Test
    fun `changed player score to 100_score becomes 100`() {
        Truth.assertThat(addRecordViewModel.playerListState.toList()[0].score).isEqualTo(0)

        addRecordViewModel.onEvent(AddRecordEvent.ChangedPlayerScore(0, 5))
        Truth.assertThat(addRecordViewModel.playerListState.toList()[0].score).isEqualTo(5)
    }

    @Test
    fun `changed record title to newTitle_title becomes newTitle`() {
        Truth.assertThat(addRecordViewModel.titleState.value.title).isEqualTo("")

        addRecordViewModel.onEvent(AddRecordEvent.ChangedRecordTitle("newTitle"))
        Truth.assertThat(addRecordViewModel.titleState.value.title).isEqualTo("newTitle")
    }

    @Test
    fun `save record, number of record increased by 1`() {
        addRecordViewModel.onEvent(AddRecordEvent.SaveRecord)
        runTest{
            Truth.assertThat(recordUseCases.getAllRecord().first().size).isEqualTo(1)
        }
    }
}