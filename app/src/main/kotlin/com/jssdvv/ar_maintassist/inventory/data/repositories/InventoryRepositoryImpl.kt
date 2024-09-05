package com.jssdvv.ar_maintassist.inventory.data.repositories

import com.jssdvv.ar_maintassist.inventory.data.local.InventoryDao
import com.jssdvv.ar_maintassist.inventory.domain.models.InventoryEntity
import com.jssdvv.ar_maintassist.inventory.domain.repositories.InventoryRepository
import kotlinx.coroutines.flow.Flow

class InventoryRepositoryImpl(
    private val dao: InventoryDao
): InventoryRepository {
    override fun getAllItemsByNameAsc(): Flow<List<InventoryEntity>> {
        return dao.getAllItemsByNameAsc()
    }

    override fun getAllItemsByNameDesc(): Flow<List<InventoryEntity>> {
        return dao.getAllItemsByNameDesc()
    }

    override fun getAllItemsByCodeAsc(): Flow<List<InventoryEntity>> {
        return dao.getAllItemsByCodeAsc()
    }

    override fun getAllItemsByCodeDesc(): Flow<List<InventoryEntity>> {
        return dao.getAllItemsByCodeDesc()
    }

    override fun getAllItemsByTimestampAsc(): Flow<List<InventoryEntity>> {
        return dao.getAllItemsByTimestampAsc()
    }

    override fun getAllItemsByTimestampDesc(): Flow<List<InventoryEntity>> {
        return dao.getAllItemsByTimestampDesc()
    }

    override suspend fun insertItem(inventoryEntity: InventoryEntity) {
        return dao.insertItem(inventoryEntity)
    }

    override suspend fun deleteItem(inventoryEntity: InventoryEntity) {
        return dao.deleteItem(inventoryEntity)
    }

    override suspend fun updateItem(inventoryEntity: InventoryEntity) {
        return dao.updateItem(inventoryEntity)
    }
}