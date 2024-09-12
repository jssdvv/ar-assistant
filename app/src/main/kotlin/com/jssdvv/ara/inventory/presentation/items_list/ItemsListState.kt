package com.jssdvv.ara.inventory.presentation.items_list

import com.jssdvv.ara.core.domain.utils.OrderType
import com.jssdvv.ara.inventory.domain.models.InventoryItemEntity
import com.jssdvv.ara.inventory.domain.utils.InventoryItemOrderKey

data class ItemsListState(
    val inventoryItems : List<InventoryItemEntity> = emptyList(),
    val inventoryItemOrderKey: InventoryItemOrderKey = InventoryItemOrderKey.Id(OrderType.ASCENDING),
    val isOrderSectionVisible: Boolean = false
)