package com.jssdvv.ar_maintassist.inventory.domain.usescases

import com.jssdvv.ar_maintassist.inventory.domain.repositories.InventoryRepository
import com.jssdvv.ar_maintassist.machines.domain.models.MachineEntity
import com.jssdvv.ar_maintassist.machines.domain.utils.MachineOrder
import com.jssdvv.ar_maintassist.core.domain.utils.OrderType
import com.jssdvv.ar_maintassist.inventory.domain.models.InventoryEntity
import com.jssdvv.ar_maintassist.inventory.domain.utils.InventoryOrder
import kotlinx.coroutines.flow.Flow

class GetInventoryItems(
    private val repository: InventoryRepository
) {
    operator fun invoke(
        inventoryOrder: InventoryOrder = InventoryOrder.Code(OrderType.ASCENDING),
    ): Flow<List<InventoryEntity>> {
        return when (inventoryOrder.orderType) {
            OrderType.ASCENDING -> when (inventoryOrder) {
                is InventoryOrder.Code -> repository.getAllItemsByCodeAsc()
                is InventoryOrder.Name -> repository.getAllItemsByNameAsc()
                is InventoryOrder.Timestamp -> repository.getAllItemsByTimestampAsc()
            }

            OrderType.DESCENDING -> when (inventoryOrder) {
                is InventoryOrder.Code -> repository.getAllItemsByCodeDesc()
                is InventoryOrder.Name -> repository.getAllItemsByNameDesc()
                is InventoryOrder.Timestamp -> repository.getAllItemsByTimestampDesc()
            }
        }
    }
}