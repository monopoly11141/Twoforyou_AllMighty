package com.example.twoforyou_allmighty.data.db.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.twoforyou_allmighty.data.db.local.helper.RoundListConverter
import com.example.twoforyou_allmighty.data.model.record.GameRecord

@Database(
    entities = [GameRecord::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(
    RoundListConverter::class
)
abstract class GameRecordDb: RoomDatabase() {
    abstract val gameRecordDao: GameRecordDao
}