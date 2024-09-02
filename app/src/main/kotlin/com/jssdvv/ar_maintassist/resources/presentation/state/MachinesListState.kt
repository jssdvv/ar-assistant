package com.jssdvv.ar_maintassist.resources.presentation.state

import com.jssdvv.ar_maintassist.resources.domain.models.MachineEntity
import com.jssdvv.ar_maintassist.resources.domain.util.MachineOrder
import com.jssdvv.ar_maintassist.resources.domain.util.OrderType

data class MachinesListState(
    val machines : List<MachineEntity> = emptyList(),
    val machineOrder: MachineOrder = MachineOrder.Timestamp(OrderType.ASCENDING),
    val isOrderSectionVisible : Boolean = false
)