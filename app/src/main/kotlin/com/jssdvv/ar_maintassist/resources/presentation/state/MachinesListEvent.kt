package com.jssdvv.ar_maintassist.resources.presentation.state

import com.jssdvv.ar_maintassist.resources.domain.models.MachineEntity
import com.jssdvv.ar_maintassist.resources.domain.util.MachineOrder


sealed class MachinesListEvent {
    data class Order(val machineOrder: MachineOrder) : MachinesListEvent()
    data class DeleteMachine(val machineEntity: MachineEntity) : MachinesListEvent()
    data object RestoreMachine: MachinesListEvent()
    data object ToggleOrderSection: MachinesListEvent()
}