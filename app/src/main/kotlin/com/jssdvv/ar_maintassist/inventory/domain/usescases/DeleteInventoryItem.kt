package com.jssdvv.ar_maintassist.inventory.domain.usescases

import com.jssdvv.ar_maintassist.inventory.domain.models.InventoryEntity
import com.jssdvv.ar_maintassist.inventory.domain.repositories.InventoryRepository
import com.jssdvv.ar_maintassist.machines.domain.models.MachineEntity
import com.jssdvv.ar_maintassist.machines.domain.repositories.MachineRepository

class DeleteInventoryItem(
    private val repository: InventoryRepository
) {
    suspend operator fun invoke(inventoryItem: InventoryEntity) {
        repository.deleteItem(inventoryItem)
    }
}