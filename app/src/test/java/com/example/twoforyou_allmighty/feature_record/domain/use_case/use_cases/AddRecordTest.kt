package com.example.twoforyou_allmighty.feature_record.domain.use_case.use_cases

import androidx.compose.runtime.collectAsState
import com.example.twoforyou_allmighty.feature_record.data.repository.FakeRecordRepository
import com.example.twoforyou_allmighty.feature_record.domain.model.record.Record
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class AddRecordTest {
    private lateinit var addRecord: AddRecord
    private lateinit var fakeRecordRepository: FakeRecordRepository

    @Before
    fun setUp() {
        fakeRecordRepository = FakeRecordRepository()
        addRecord = AddRecord(
            recordRepository = fakeRecordRepository
        )

        val recordToInsert = mutableListOf<Record>()
        for(i in 1..100) {
            recordToInsert.add(Record(id = i))
        }

        runBlocking {
            recordToInsert.forEach { record ->
                fakeRecordRepository.insertRecord(record)
            }
        }
    }

    @Test
    fun `inserted correctly, 100 notes`() {
        runBlocking {
            val recordList = fakeRecordRepository.getAllRecord().first()
            assertThat(recordList.size).isEqualTo(100)
        }
    }
}