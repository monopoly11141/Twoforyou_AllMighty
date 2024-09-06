package com.example.twoforyou_allmighty.feature_record.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.twoforyou_allmighty.feature_record.domain.model.record.Record
import kotlinx.coroutines.flow.Flow

@Dao
interface RecordDao {

    @Query("SELECT * FROM record_database")
    fun getAllRecord(): Flow<List<Record>>

    @Insert()
    suspend fun insertRecord(script: Record)

    @Delete()
    suspend fun deleteRecord(script: Record)

    @Query("DELETE FROM record_database")
    suspend fun deleteAllRecord()

    @Query("SELECT * FROM record_database WHERE  id = :id LIMIT 1")
    suspend fun getRecordById(id: Int): Record
}