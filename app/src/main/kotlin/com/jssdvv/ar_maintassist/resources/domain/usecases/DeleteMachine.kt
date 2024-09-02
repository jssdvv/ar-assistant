package com.jssdvv.ar_maintassist.resources.domain.usecases

import com.jssdvv.ar_maintassist.resources.domain.models.MachineEntity
import com.jssdvv.ar_maintassist.resources.domain.repository.MachineRepository

class DeleteMachine(
    private val repository: MachineRepository
) {
    suspend operator fun invoke(machineEntity: MachineEntity) {
        repository.deleteMachine(machineEntity)
    }
}