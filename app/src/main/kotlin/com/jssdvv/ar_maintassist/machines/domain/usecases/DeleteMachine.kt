package com.jssdvv.ar_maintassist.machines.domain.usecases

import com.jssdvv.ar_maintassist.machines.domain.models.MachineEntity
import com.jssdvv.ar_maintassist.machines.domain.repositories.MachineRepository

class DeleteMachine(
    private val repository: MachineRepository
) {
    suspend operator fun invoke(machineEntity: MachineEntity) {
        repository.deleteMachine(machineEntity)
    }
}