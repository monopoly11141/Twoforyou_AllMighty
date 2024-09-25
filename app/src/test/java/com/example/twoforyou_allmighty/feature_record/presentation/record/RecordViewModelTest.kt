package com.example.twoforyou_allmighty.feature_record.presentation.record

import com.example.twoforyou_allmighty.MainCoroutineRule
import com.example.twoforyou_allmighty.feature_record.data.repository.FakeRecordRepository
import com.example.twoforyou_allmighty.feature_record.domain.model.record.Record
import com.example.twoforyou_allmighty.feature_record.domain.use_case.RecordUseCases
import com.example.twoforyou_allmighty.feature_record.domain.use_case.use_cases.AddRecord
import com.example.twoforyou_allmighty.feature_record.domain.use_case.use_cases.DeleteAllRecord
import com.example.twoforyou_allmighty.feature_record.domain.use_case.use_cases.DeleteRecord
import com.example.twoforyou_allmighty.feature_record.domain.use_case.use_cases.GetAllRecord
import com.example.twoforyou_allmighty.feature_record.domain.use_case.use_cases.GetRecordById
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
        every { recordUseCases.getRecordById } returns GetRecordById(fakeRecordRepository)
        every { recordUseCases.deleteRecord } returns DeleteRecord(fakeRecordRepository)
        every { recordUseCases.deleteAllRecord } returns DeleteAllRecord(fakeRecordRepository)

        record = Record(title = "abc")
    }

    @Test
    fun `added record_1 item added`() {
        val viewModel = RecordViewModel(recordUseCases)

        viewModel.onEvent(RecordEvent.AddRecord(record))
        runTest {
            Truth.assertThat(recordUseCases.getAllRecord().first()[0]).isEqualTo(record)
        }

    }

    @Test
    fun `deleted record_0 item left`() {
        val viewModel = RecordViewModel(recordUseCases)

        viewModel.onEvent(RecordEvent.AddRecord(record))
        runTest{
            Truth.assertThat(recordUseCases.getAllRecord().first()[0]).isEqualTo(record)
        }

        viewModel.onEvent(RecordEvent.DeleteRecord(record))
        runTest{
            Truth.assertThat(recordUseCases.getAllRecord().first().size).isEqualTo(0)
        }

    }

    @Test
    fun `delete all record_0 item left`() {
        val viewModel = RecordViewModel(recordUseCases)

        viewModel.onEvent(RecordEvent.AddRecord(record))
        runTest{
            Truth.assertThat(recordUseCases.getAllRecord().first()[0]).isEqualTo(record)
        }
        viewModel.onEvent(RecordEvent.AddRecord(record))
        runTest{
            Truth.assertThat(recordUseCases.getAllRecord().first()[1]).isEqualTo(record)
        }

        viewModel.onEvent(RecordEvent.DeleteAllRecord)
        runTest{
            Truth.assertThat(recordUseCases.getAllRecord().first().size).isEqualTo(0)
        }
    }
}