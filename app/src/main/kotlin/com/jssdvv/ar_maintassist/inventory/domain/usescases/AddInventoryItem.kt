package com.jssdvv.ar_maintassist.inventory.domain.usescases

import com.jssdvv.ar_maintassist.inventory.domain.models.InvalidInventoryItemException
import com.jssdvv.ar_maintassist.inventory.domain.models.InventoryEntity
import com.jssdvv.ar_maintassist.inventory.domain.repositories.InventoryRepository
import com.jssdvv.ar_maintassist.machines.domain.models.InvalidMachineException

class AddInventoryItem(
    private val repository: InventoryRepository
) {
    @Throws(InvalidInventoryItemException::class)
    suspend operator fun invoke(inventoryEntity: InventoryEntity) {
        if (inventoryEntity.name.isBlank()){
            throw InvalidMachineException("El ítem debe tener un nombre")
        }
        if (inventoryEntity.storageUnit.isBlank()){
            throw InvalidMachineException("El ítem debe tener un costo por unidad")
        }
        if (inventoryEntity.unitCost <= 0){
            throw InvalidMachineException("El costo por unidad no debe ser cero o negativo")
        }
        repository.insertItem(inventoryEntity)
    }
}