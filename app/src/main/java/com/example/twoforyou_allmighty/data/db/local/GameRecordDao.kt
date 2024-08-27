package com.example.twoforyou_allmighty.data.db.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.twoforyou_allmighty.data.model.record.GameRecord
import kotlinx.coroutines.flow.Flow

@Dao
interface GameRecordDao {

    @Query("SELECT * FROM game_record_database")
    fun getAllGameRecord() : Flow<List<GameRecord>>

    @Insert
    suspend fun insertGameRecord(gameRecord: GameRecord)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateGameRecord(gameRecord: GameRecord)

    @Delete
    suspend fun deleteGameRecord(gameRecord: GameRecord)

    @Query("DELETE FROM game_record_database")
    suspend fun deleteAllGameRecord()

}