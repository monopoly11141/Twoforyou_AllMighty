package com.example.twoforyou_allmighty.feature_record.domain.use_case.use_cases

import com.example.twoforyou_allmighty.feature_record.data.repository.FakeRecordRepository
import com.example.twoforyou_allmighty.feature_record.domain.model.record.Record
import com.google.common.truth.Truth
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class DeleteRecordTest() {
    private lateinit var addRecord: AddRecord
    private lateinit var fakeRecordRepository: FakeRecordRepository
    private lateinit var recordToInsert: MutableList<Record>

    @Before
    fun setUp() {
        fakeRecordRepository = FakeRecordRepository()
        addRecord = AddRecord(
            recordRepository = fakeRecordRepository
        )

        recordToInsert = mutableListOf<Record>()
        for (i in 1..100) {
            recordToInsert.add(Record(id = i))
        }

        runBlocking {
            recordToInsert.forEach { record ->
                fakeRecordRepository.insertRecord(record)
            }
        }
    }

    @Test
    fun `delete 1 record, 99 records`() {

        runTest {
            val recordList = fakeRecordRepository.getAllRecord().first()
            Truth.assertThat(recordList.size).isEqualTo(100)
            fakeRecordRepository.deleteRecord(recordToInsert[0])
            Truth.assertThat(recordList.size).isEqualTo(99)
        }

    }
}