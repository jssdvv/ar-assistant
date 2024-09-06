package com.jssdvv.ar_maintassist.machines.domain.usecases

import com.jssdvv.ar_maintassist.machines.domain.models.MachineEntity
import com.jssdvv.ar_maintassist.machines.domain.repositories.MachineRepository

class UpdateMachine(
    private val repository: MachineRepository
) {
    suspend operator fun invoke(entity: MachineEntity) {
        repository.updateMachine(entity)
    }
}