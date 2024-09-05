package com.jssdvv.ar_maintassist.machines.presentation.machines_list

import com.jssdvv.ar_maintassist.machines.domain.models.MachineEntity
import com.jssdvv.ar_maintassist.machines.domain.utils.MachineOrder


sealed class MachinesListEvent {
    data class Order(val machineOrder: MachineOrder) : MachinesListEvent()
    data class DeleteMachine(val machineEntity: MachineEntity) : MachinesListEvent()
    data object RestoreMachine: MachinesListEvent()
    data object ToggleOrderSectionVisibility: MachinesListEvent()
}