package com.jssdvv.ara.inventory.domain.usescases

import com.jssdvv.ara.inventory.domain.models.InventoryItemEntity
import com.jssdvv.ara.inventory.domain.repositories.InventoryItemRepository

class UpdateInventoryItem(
    private val repository: InventoryItemRepository
) {
    suspend operator fun invoke(entity: InventoryItemEntity) {
        repository.updateInventoryItem(entity)
    }
}