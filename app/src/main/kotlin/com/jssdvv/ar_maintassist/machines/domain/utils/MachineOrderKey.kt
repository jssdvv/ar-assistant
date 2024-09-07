package com.jssdvv.ar_maintassist.machines.domain.utils

import com.jssdvv.ar_maintassist.core.domain.utils.OrderType

sealed class MachineOrderKey(
    val orderType: OrderType,
    val orderKeyName: String
) {
    class Name(
        orderType: OrderType,
        orderKeyName: String = "Name"
    ) : MachineOrderKey(orderType, orderKeyName)

    class Category(
        orderType: OrderType,
        orderKeyName: String = "Category"
    ) : MachineOrderKey(orderType, orderKeyName)

    class Timestamp(
        orderType: OrderType,
        orderKeyName: String = "Creation Date"
    ) : MachineOrderKey(orderType, orderKeyName)

    fun copy(orderType: OrderType): MachineOrderKey {
        return when (this) {
            is Name -> Name(orderType)
            is Category -> Category(orderType)
            is Timestamp -> Timestamp(orderType)
        }
    }
}