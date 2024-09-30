package com.example.twoforyou_allmighty.feature_record.domain.use_case.use_cases

import com.example.twoforyou_allmighty.feature_record.data.repository.FakeRecordRepository
import com.example.twoforyou_allmighty.feature_record.domain.model.record.Record
import com.example.twoforyou_allmighty.feature_record.domain.model.record.Round
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class UpdateRecordTest {
    private lateinit var addRecord: AddRecord
    private lateinit var fakeRecordRepository: FakeRecordRepository
    private lateinit var updateRecord: UpdateRecord

    @Before
    fun setUp() {
        fakeRecordRepository = FakeRecordRepository()
        addRecord = AddRecord(
            recordRepository = fakeRecordRepository
        )
        updateRecord = UpdateRecord(
            recordRepository = fakeRecordRepository
        )

        val recordToInsert = mutableListOf<Record>()
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
    fun `changed record title to new record, update`() {
        runTest {
            val recordList = fakeRecordRepository.getAllRecord().first()

            val updatedTitle = "new record"

            assertThat(recordList[0].round.size).isEqualTo(0)
            val updatedRecord = recordList[0].copy(
                title = updatedTitle
            )

            fakeRecordRepository.updateRecord(updatedRecord)

            assertThat(recordList[0].title).isEqualTo(updatedTitle)
        }
    }
}