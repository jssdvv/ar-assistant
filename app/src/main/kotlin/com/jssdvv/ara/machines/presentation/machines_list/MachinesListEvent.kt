package com.jssdvv.ara.machines.presentation.machines_list

import com.jssdvv.ara.machines.domain.models.MachineEntity
import com.jssdvv.ara.machines.domain.utils.MachineOrderKey

sealed class MachinesListEvent {
    data class OrderMachines(val orderKey: MachineOrderKey) : MachinesListEvent()
    data class DeleteMachine(val entity: MachineEntity) : MachinesListEvent()
    data object RestoreMachine: MachinesListEvent()
    data object ToggleOrderSectionVisibility: MachinesListEvent()
}