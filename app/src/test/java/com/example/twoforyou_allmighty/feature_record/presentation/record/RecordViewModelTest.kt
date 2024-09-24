package com.example.twoforyou_allmighty.feature_record.presentation.record

import com.example.twoforyou_allmighty.feature_record.data.repository.FakeRecordRepository
import com.example.twoforyou_allmighty.feature_record.domain.model.record.Record
import com.example.twoforyou_allmighty.feature_record.domain.use_case.RecordUseCases
import com.example.twoforyou_allmighty.feature_record.domain.use_case.use_cases.AddRecord
import com.example.twoforyou_allmighty.feature_record.domain.use_case.use_cases.GetAllRecord
import com.google.common.truth.Truth
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class RecordViewModelTest {

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private lateinit var fakeRecordRepository: FakeRecordRepository

    private val recordUseCases = mockk<RecordUseCases>()

    private lateinit var record: Record

    @Before
    fun setUp() {
        fakeRecordRepository = FakeRecordRepository()

        every { recordUseCases.addRecord } returns AddRecord(fakeRecordRepository)
        every { recordUseCases.getAllRecord } returns GetAllRecord(fakeRecordRepository)

        record = Record(title = "abc")
    }

    @Test
    fun `added record_successfully added`() {
        val viewModel = RecordViewModel(recordUseCases)

        viewModel.onEvent(RecordEvent.AddRecord(record))
        runTest {
            Truth.assertThat(fakeRecordRepository.getAllRecord().first().size).isEqualTo(1)
        }

    }

}