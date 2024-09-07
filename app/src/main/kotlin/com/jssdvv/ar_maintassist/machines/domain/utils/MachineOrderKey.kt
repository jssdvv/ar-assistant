package com.jssdvv.ar_maintassist.machines.domain.utils

import com.jssdvv.ar_maintassist.R
import com.jssdvv.ar_maintassist.core.domain.utils.OrderType

sealed class MachineOrderKey(
    val orderType: OrderType,
    val orderKeyName: Int
) {
    class Name(
        orderType: OrderType,
        orderKeyName: Int = R.string.machine_name_order_key_name
    ) : MachineOrderKey(orderType, orderKeyName)

    class Category(
        orderType: OrderType,
        orderKeyName: Int = R.string.machine_category_order_key_name
    ) : MachineOrderKey(orderType, orderKeyName)

    class Timestamp(
        orderType: OrderType,
        orderKeyName: Int = R.string.machine_timestamp_order_key_name
    ) : MachineOrderKey(orderType, orderKeyName)

    fun copy(orderType: OrderType): MachineOrderKey {
        return when (this) {
            is Name -> Name(orderType)
            is Category -> Category(orderType)
            is Timestamp -> Timestamp(orderType)
        }
    }
}