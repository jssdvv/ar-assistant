package com.jssdvv.ar_maintassist.machines.presentation.machines_list

import com.jssdvv.ar_maintassist.machines.domain.models.MachineEntity
import com.jssdvv.ar_maintassist.machines.domain.utils.MachineOrderKey


sealed class MachinesListEvent {
    data class OrderMachines(val orderKey: MachineOrderKey) : MachinesListEvent()
    data class DeleteMachine(val entity: MachineEntity) : MachinesListEvent()
    data object RestoreMachine: MachinesListEvent()
    data object ToggleOrderSectionVisibility: MachinesListEvent()
}