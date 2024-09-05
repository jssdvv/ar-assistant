package com.jssdvv.ar_maintassist.machines.domain.utils

import com.jssdvv.ar_maintassist.core.domain.utils.OrderType

sealed class MachineOrder(
    val orderType: OrderType
) {
    class Name(orderType: OrderType): MachineOrder(orderType)
    class Category(orderType: OrderType): MachineOrder(orderType)
    class Timestamp(orderType: OrderType): MachineOrder(orderType)
}