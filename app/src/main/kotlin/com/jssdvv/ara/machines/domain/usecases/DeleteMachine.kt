package com.jssdvv.ara.machines.domain.usecases

import com.jssdvv.ara.machines.domain.models.MachineEntity
import com.jssdvv.ara.machines.domain.repositories.MachineRepository

class DeleteMachine(
    private val repository: MachineRepository
) {
    suspend operator fun invoke(entity: MachineEntity) {
        repository.deleteMachine(entity)
    }
}