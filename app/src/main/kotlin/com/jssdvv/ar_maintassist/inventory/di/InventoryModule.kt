package com.jssdvv.ar_maintassist.inventory.di

import android.app.Application
import androidx.room.Room
import com.jssdvv.ar_maintassist.inventory.data.local.InventoryDatabase
import com.jssdvv.ar_maintassist.inventory.data.repositories.InventoryRepositoryImpl
import com.jssdvv.ar_maintassist.inventory.domain.repositories.InventoryRepository
import com.jssdvv.ar_maintassist.inventory.domain.usescases.AddInventoryItem
import com.jssdvv.ar_maintassist.inventory.domain.usescases.DeleteInventoryItem
import com.jssdvv.ar_maintassist.inventory.domain.usescases.GetInventoryItems
import com.jssdvv.ar_maintassist.inventory.domain.usescases.InventoryUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object InventoryModule {
    @Provides
    @Singleton
    fun provideInventoryDatabase(context: Application): InventoryDatabase {
        return Room.databaseBuilder(
            context = context,
            klass = InventoryDatabase::class.java,
            name = InventoryDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideInventoryRepository(database: InventoryDatabase): InventoryRepository {
        return InventoryRepositoryImpl(database.dao)
    }

    @Provides
    @Singleton
    fun provideInventoryUseCases(repository: InventoryRepository): InventoryUseCases {
        return InventoryUseCases(
            getInventoryItems = GetInventoryItems(repository),
            deleteInventoryItem = DeleteInventoryItem(repository),
            addInventoryItem = AddInventoryItem(repository)
        )
    }
}