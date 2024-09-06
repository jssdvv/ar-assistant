package com.jssdvv.ar_maintassist.machines.domain.utils

import com.jssdvv.ar_maintassist.core.domain.utils.OrderType

sealed class MachineOrderKey(
    val orderType: OrderType
) {
    class Name(orderType: OrderType) : MachineOrderKey(orderType)
    class Category(orderType: OrderType) : MachineOrderKey(orderType)
    class Timestamp(orderType: OrderType) : MachineOrderKey(orderType)
}