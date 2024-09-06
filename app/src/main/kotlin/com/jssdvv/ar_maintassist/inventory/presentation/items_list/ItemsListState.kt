package com.jssdvv.ar_maintassist.inventory.presentation.items_list

import com.jssdvv.ar_maintassist.core.domain.utils.OrderType
import com.jssdvv.ar_maintassist.inventory.domain.models.InventoryItemEntity
import com.jssdvv.ar_maintassist.inventory.domain.utils.InventoryItemOrderKey

data class ItemsListState(
    val inventoryItems : List<InventoryItemEntity> = emptyList(),
    val inventoryItemOrderKey: InventoryItemOrderKey = InventoryItemOrderKey.Id(OrderType.ASCENDING),
    val isOrderSectionVisible: Boolean = false
)