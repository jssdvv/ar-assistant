package com.jssdvv.ar_maintassist.machines.domain.usecases

data class MachineUseCases(
    val getMachines: GetMachines,
    val insertMachine: InsertMachine,
    val updateMachine: UpdateMachine,
    val deleteMachine: DeleteMachine
)