package com.jssdvv.ar_maintassist.inventory.domain.utils

import com.jssdvv.ar_maintassist.core.domain.utils.OrderType

sealed class InventoryOrder(
    val orderType: OrderType
) {
    class Code(orderType: OrderType): InventoryOrder(orderType)
    class Name(orderType: OrderType): InventoryOrder(orderType)
    class Timestamp(orderType: OrderType): InventoryOrder(orderType)
}