package com.jssdvv.ar_maintassist.machines.presentation.machines_list

import com.jssdvv.ar_maintassist.machines.domain.models.MachineEntity
import com.jssdvv.ar_maintassist.machines.domain.utils.MachineOrder
import com.jssdvv.ar_maintassist.core.domain.utils.OrderType

data class MachinesListState(
    val machines : List<MachineEntity> = emptyList(),
    val machineOrder: MachineOrder = MachineOrder.Timestamp(OrderType.ASCENDING),
    val isOrderSectionVisible : Boolean = false
)