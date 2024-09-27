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
    fun `inserted round to 0th record, 1 record`() {
        runTest {
            val recordList = fakeRecordRepository.getAllRecord().first()

            assertThat(recordList[0].round.size).isEqualTo(0)

            recordList[0].round.add(Round())
            fakeRecordRepository.updateRecord(recordList[0])
            assertThat(recordList[0].round.size).isEqualTo(1)
        }
    }
}