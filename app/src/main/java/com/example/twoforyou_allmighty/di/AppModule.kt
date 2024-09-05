package com.example.twoforyou_allmighty.di

import android.content.Context
import androidx.room.Room
import com.example.twoforyou_allmighty.feature_record.data.db.RecordDao
import com.example.twoforyou_allmighty.feature_record.data.db.RecordDb
import com.example.twoforyou_allmighty.feature_record.data.repository_impl.RecordRepositoryImpl
import com.example.twoforyou_allmighty.feature_record.domain.repository.RecordRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun providesRecordDao(recordDb: RecordDb): RecordDao = recordDb.recordDao

    @Provides
    @Singleton
    fun providesRecordDb(@ApplicationContext context: Context): RecordDb =
        Room.databaseBuilder(context, RecordDb::class.java, "record_database")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun providesRecordRepository(recordDao: RecordDao): RecordRepository = RecordRepositoryImpl(recordDao)


}