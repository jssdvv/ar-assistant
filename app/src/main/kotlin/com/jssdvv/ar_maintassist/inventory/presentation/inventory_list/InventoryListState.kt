package com.jssdvv.ar_maintassist.inventory.presentation.inventory_list

import com.jssdvv.ar_maintassist.core.domain.utils.OrderType
import com.jssdvv.ar_maintassist.inventory.domain.models.InventoryEntity
import com.jssdvv.ar_maintassist.inventory.domain.utils.InventoryOrder

data class InventoryListState(
    val inventoryItems : List<InventoryEntity> = emptyList(),
    val inventoryOrder: InventoryOrder = InventoryOrder.Code(OrderType.ASCENDING),
    val isOrderSectionVisible: Boolean = false
)