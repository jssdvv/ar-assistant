package com.jssdvv.ar_maintassist.inventory.domain.usescases

import com.jssdvv.ar_maintassist.inventory.domain.models.InventoryItemEntity
import com.jssdvv.ar_maintassist.inventory.domain.repositories.InventoryItemRepository

class UpdateInventoryItem(
    private val repository: InventoryItemRepository
) {
    suspend operator fun invoke(entity: InventoryItemEntity) {
        repository.updateInventoryItem(entity)
    }
}