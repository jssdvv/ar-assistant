package com.jssdvv.ar_maintassist.machines.domain.usecases

import com.jssdvv.ar_maintassist.machines.domain.models.ActivityEntity
import com.jssdvv.ar_maintassist.machines.domain.models.InvalidActivityException
import com.jssdvv.ar_maintassist.machines.domain.models.InvalidMachineException
import com.jssdvv.ar_maintassist.machines.domain.repositories.ActivityRepository

class InsertActivity(
    private val repository: ActivityRepository
) {
    @Throws(InvalidActivityException::class)
    suspend operator fun invoke(entity: ActivityEntity) {
        if (entity.name.isBlank()) {
            throw InvalidMachineException("La máquina debe tener un nombre")
        }
        if (entity.description.isBlank()) {
            throw InvalidMachineException("La máquina debe tener un nombre")
        }
        repository.insertActivity(entity)
    }
}