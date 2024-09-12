package com.jssdvv.ara.inventory.domain.usescases

import com.jssdvv.ara.inventory.domain.models.InvalidInventoryItemException
import com.jssdvv.ara.inventory.domain.models.InventoryItemEntity
import com.jssdvv.ara.inventory.domain.repositories.InventoryItemRepository
import com.jssdvv.ara.machines.domain.models.InvalidMachineException

class InsertInventoryItem(
    private val repository: InventoryItemRepository
) {
    @Throws(InvalidInventoryItemException::class)
    suspend operator fun invoke(entity: InventoryItemEntity) {
        if (entity.name.isBlank()) {
            throw InvalidMachineException("El ítem debe tener un nombre")
        }
        if (entity.storageUnit.isBlank()) {
            throw InvalidMachineException("El ítem debe tener un costo por unidad")
        }
        if (entity.unitCost < 0) {
            throw InvalidMachineException("El costo por unidad no debe ser menor que cero")
        }
        repository.insertInventoryItem(entity)
    }
}