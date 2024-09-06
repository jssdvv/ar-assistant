package com.jssdvv.ar_maintassist.inventory.di

import android.app.Application
import androidx.room.Room
import com.jssdvv.ar_maintassist.inventory.data.local.InventoryItemDatabase
import com.jssdvv.ar_maintassist.inventory.data.repositories.InventoryItemRepositoryImpl
import com.jssdvv.ar_maintassist.inventory.domain.repositories.InventoryItemRepository
import com.jssdvv.ar_maintassist.inventory.domain.usescases.DeleteInventoryItem
import com.jssdvv.ar_maintassist.inventory.domain.usescases.GetInventoryItems
import com.jssdvv.ar_maintassist.inventory.domain.usescases.InsertInventoryItem
import com.jssdvv.ar_maintassist.inventory.domain.usescases.InventoryItemUseCases
import com.jssdvv.ar_maintassist.inventory.domain.usescases.UpdateInventoryItem
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
    fun provideInventoryDatabase(context: Application): InventoryItemDatabase {
        return Room.databaseBuilder(
            context = context,
            klass = InventoryItemDatabase::class.java,
            name = InventoryItemDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideInventoryRepository(database: InventoryItemDatabase): InventoryItemRepository {
        return InventoryItemRepositoryImpl(database.dao)
    }

    @Provides
    @Singleton
    fun provideInventoryUseCases(repository: InventoryItemRepository): InventoryItemUseCases {
        return InventoryItemUseCases(
            getInventoryItems = GetInventoryItems(repository),
            insertInventoryItem = InsertInventoryItem(repository),
            updateInventoryItem = UpdateInventoryItem(repository),
            deleteInventoryItem = DeleteInventoryItem(repository)
        )
    }
}