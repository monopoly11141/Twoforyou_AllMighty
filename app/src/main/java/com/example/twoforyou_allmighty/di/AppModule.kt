package com.example.twoforyou_allmighty.di

import com.example.twoforyou_allmighty.data.mighty_record.MightyRecordRepositoryImpl
import com.example.twoforyou_allmighty.domain.mighty_record.MightyRecordRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun providesMightyRecordRepository() : MightyRecordRepository {
        return MightyRecordRepositoryImpl()
    }

}