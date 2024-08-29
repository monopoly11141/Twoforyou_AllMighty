package com.example.twoforyou_allmighty.di

import android.content.Context
import androidx.room.Room
import com.example.twoforyou_allmighty.data.db.local.GameRecordDao
import com.example.twoforyou_allmighty.data.db.local.GameRecordDb
import com.example.twoforyou_allmighty.data.mighty_record.MightyRecordRepositoryImpl
import com.example.twoforyou_allmighty.data.record_detail.RecordDetailRepositoryImpl
import com.example.twoforyou_allmighty.domain.mighty_record.MightyRecordRepository
import com.example.twoforyou_allmighty.domain.record_detail.RecordDetailRepository
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
    fun providesMightyRecordRepository(
        gameRecordDao: GameRecordDao
    ): MightyRecordRepository {
        return MightyRecordRepositoryImpl(gameRecordDao)
    }

    @Provides
    @Singleton
    fun providesRecordDetailRepository() : RecordDetailRepository {
        return RecordDetailRepositoryImpl()
    }

    @Provides
    fun providesGameRecordDao(gameRecordDb: GameRecordDb): GameRecordDao = gameRecordDb.gameRecordDao

    @Provides
    @Singleton
    fun providesGameRecordDb(@ApplicationContext context: Context): GameRecordDb =
        Room.databaseBuilder(context, GameRecordDb::class.java, "game_record_database")
            .fallbackToDestructiveMigration()
            .build()

}