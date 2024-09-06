package com.jssdvv.ar_maintassist.inventory.data.repositories

import com.jssdvv.ar_maintassist.inventory.data.local.InventoryItemDao
import com.jssdvv.ar_maintassist.inventory.domain.models.InventoryItemEntity
import com.jssdvv.ar_maintassist.inventory.domain.repositories.InventoryItemRepository
import kotlinx.coroutines.flow.Flow

class InventoryItemRepositoryImpl(
    private val dao: InventoryItemDao
) : InventoryItemRepository {
    override fun getAllInventoryItemsByIdAsc(): Flow<List<InventoryItemEntity>> {
        return dao.getAllInventoryItemsByCodeAsc()
    }

    override fun getAllInventoryItemsByIdDesc(): Flow<List<InventoryItemEntity>> {
        return dao.getAllInventoryItemsByCodeDesc()
    }

    override fun getAllInventoryItemsByNameAsc(): Flow<List<InventoryItemEntity>> {
        return dao.getAllInventoryItemsByNameAsc()
    }

    override fun getAllInventoryItemsByNameDesc(): Flow<List<InventoryItemEntity>> {
        return dao.getAllInventoryItemsByNameDesc()
    }

    override fun getAllInventoryItemsByTimestampAsc(): Flow<List<InventoryItemEntity>> {
        return dao.getAllInventoryItemsByTimestampAsc()
    }

    override fun getAllInventoryItemsByTimestampDesc(): Flow<List<InventoryItemEntity>> {
        return dao.getAllInventoryItemsByTimestampDesc()
    }

    override suspend fun insertInventoryItem(entity: InventoryItemEntity) {
        return dao.insertInventoryItem(entity)
    }

    override suspend fun updateInventoryItem(entity: InventoryItemEntity) {
        return dao.updateInventoryItem(entity)
    }

    override suspend fun deleteInventoryItem(entity: InventoryItemEntity) {
        return dao.deleteInventoryItem(entity)
    }
}