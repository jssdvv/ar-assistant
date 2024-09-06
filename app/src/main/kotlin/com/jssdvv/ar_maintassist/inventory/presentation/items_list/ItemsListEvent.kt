package com.jssdvv.ar_maintassist.inventory.presentation.items_list

import com.jssdvv.ar_maintassist.inventory.domain.models.InventoryItemEntity
import com.jssdvv.ar_maintassist.inventory.domain.utils.InventoryItemOrderKey

sealed class ItemsListEvent {
    data class OrderItems(val orderKey: InventoryItemOrderKey) : ItemsListEvent()
    data class DeleteItem(val entity: InventoryItemEntity) : ItemsListEvent()
    data class InsertItem(val entity: InventoryItemEntity) : ItemsListEvent()
    data object RestoreItem : ItemsListEvent()
    data object ToggleOrderSectionVisibility : ItemsListEvent()
}