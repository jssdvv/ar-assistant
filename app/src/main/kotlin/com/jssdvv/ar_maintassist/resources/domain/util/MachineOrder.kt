package com.jssdvv.ar_maintassist.resources.domain.util

sealed class MachineOrder(
    val orderType: OrderType
) {
    class Name(orderType: OrderType): MachineOrder(orderType)
    class Category(orderType: OrderType): MachineOrder(orderType)
    class Timestamp(orderType: OrderType): MachineOrder(orderType)
}