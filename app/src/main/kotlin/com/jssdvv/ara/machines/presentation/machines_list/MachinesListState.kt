package com.jssdvv.ara.machines.presentation.machines_list

import androidx.compose.runtime.Stable
import com.jssdvv.ara.core.domain.utils.OrderType
import com.jssdvv.ara.machines.domain.models.MachineEntity
import com.jssdvv.ara.machines.domain.utils.MachineOrderKey

@Stable
data class MachinesListState(
    val machines: List<MachineEntity> = emptyList(),
    val machineOrderKey: MachineOrderKey = MachineOrderKey.Name(orderType = OrderType.ASCENDING),
    val isOrderSectionVisible: Boolean = false
)