package com.jssdvv.ar_maintassist.inventory.domain.repositories

import com.jssdvv.ar_maintassist.inventory.domain.models.InventoryItemEntity
import kotlinx.coroutines.flow.Flow

interface InventoryItemRepository {
    fun getAllInventoryItemsByIdAsc(): Flow<List<InventoryItemEntity>>

    fun getAllInventoryItemsByIdDesc(): Flow<List<InventoryItemEntity>>

    fun getAllInventoryItemsByNameAsc(): Flow<List<InventoryItemEntity>>

    fun getAllInventoryItemsByNameDesc(): Flow<List<InventoryItemEntity>>

    fun getAllInventoryItemsByTimestampAsc(): Flow<List<InventoryItemEntity>>

    fun getAllInventoryItemsByTimestampDesc(): Flow<List<InventoryItemEntity>>

    suspend fun insertInventoryItem(entity: InventoryItemEntity)

    suspend fun updateInventoryItem(entity: InventoryItemEntity)

    suspend fun deleteInventoryItem(entity: InventoryItemEntity)
}