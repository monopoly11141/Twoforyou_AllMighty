package com.example.twoforyou_allmighty.feature_record.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.twoforyou_allmighty.feature_record.data.db.converter.PlayerListConverter
import com.example.twoforyou_allmighty.feature_record.data.db.converter.RoundConverter
import com.example.twoforyou_allmighty.feature_record.domain.model.record.Record

@Database(
    entities = [Record::class],
    version = 3,
    exportSchema = false
)
@TypeConverters(
    RoundConverter::class,
    PlayerListConverter::class
)
abstract class RecordDb : RoomDatabase() {
    abstract val recordDao: RecordDao
}