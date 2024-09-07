package com.jssdvv.ar_maintassist.machines.presentation.machines_list

import com.jssdvv.ar_maintassist.core.domain.utils.OrderType
import com.jssdvv.ar_maintassist.machines.domain.models.MachineEntity
import com.jssdvv.ar_maintassist.machines.domain.utils.MachineOrderKey

data class MachinesListState(
    val machines : List<MachineEntity> = emptyList(),
    val machineOrderKey: MachineOrderKey = MachineOrderKey.Name(orderType = OrderType.ASCENDING),
    val isOrderSectionVisible : Boolean = false
)