package com.jssdvv.ar_maintassist.inventory.domain.repositories

import com.jssdvv.ar_maintassist.inventory.domain.models.InventoryEntity
import kotlinx.coroutines.flow.Flow

interface InventoryRepository {
    fun getAllItemsByNameAsc(): Flow<List<InventoryEntity>>

    fun getAllItemsByNameDesc(): Flow<List<InventoryEntity>>

    fun getAllItemsByCodeAsc(): Flow<List<InventoryEntity>>

    fun getAllItemsByCodeDesc(): Flow<List<InventoryEntity>>

    fun getAllItemsByTimestampAsc(): Flow<List<InventoryEntity>>

    fun getAllItemsByTimestampDesc(): Flow<List<InventoryEntity>>

    suspend fun insertItem(inventoryEntity: InventoryEntity)

    suspend fun deleteItem(inventoryEntity: InventoryEntity)

    suspend fun updateItem(inventoryEntity: InventoryEntity)
}