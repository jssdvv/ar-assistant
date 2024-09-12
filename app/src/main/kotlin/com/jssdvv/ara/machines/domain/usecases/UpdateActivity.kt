package com.jssdvv.ara.machines.domain.usecases

import com.jssdvv.ara.machines.domain.models.ActivityEntity
import com.jssdvv.ara.machines.domain.repositories.ActivityRepository

class UpdateActivity(
    private val repository: ActivityRepository
) {
    suspend operator fun invoke(entity: ActivityEntity) {
        repository.updateActivity(entity)
    }
}