package com.jssdvv.ara.machines.domain.usecases

import com.jssdvv.ara.machines.domain.models.ActivityEntity
import com.jssdvv.ara.machines.domain.models.InvalidActivityException
import com.jssdvv.ara.machines.domain.models.InvalidMachineException
import com.jssdvv.ara.machines.domain.repositories.ActivityRepository

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