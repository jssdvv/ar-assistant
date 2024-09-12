package com.jssdvv.ara.machines.domain.usecases

data class MachineUseCases(
    val getMachines: GetMachines,
    val insertMachine: InsertMachine,
    val updateMachine: UpdateMachine,
    val deleteMachine: DeleteMachine
)