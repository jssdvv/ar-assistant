package com.jssdvv.ar_maintassist.inventory.domain.utils

import com.jssdvv.ar_maintassist.core.domain.utils.OrderType

sealed class InventoryItemOrderKey(
    val orderType: OrderType
) {
    class Id(orderType: OrderType): InventoryItemOrderKey(orderType)
    class Name(orderType: OrderType): InventoryItemOrderKey(orderType)
    class Timestamp(orderType: OrderType): InventoryItemOrderKey(orderType)
}