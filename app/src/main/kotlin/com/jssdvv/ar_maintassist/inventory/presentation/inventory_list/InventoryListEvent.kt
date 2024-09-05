package com.jssdvv.ar_maintassist.inventory.presentation.inventory_list

import com.jssdvv.ar_maintassist.inventory.domain.models.InventoryEntity
import com.jssdvv.ar_maintassist.inventory.domain.utils.InventoryOrder

sealed class InventoryListEvent {
    data class Order(val inventoryOrder: InventoryOrder) : InventoryListEvent()
    data class DeleteItem(val inventoryEntity: InventoryEntity) : InventoryListEvent()
    data class AddItem(val inventoryEntity: InventoryEntity): InventoryListEvent()
    data object RestoreItem: InventoryListEvent()
    data object ToggleOrderSectionVisibility: InventoryListEvent()
}