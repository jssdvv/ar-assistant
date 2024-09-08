package com.jssdvv.ar_maintassist.machines.domain.usecases

import com.jssdvv.ar_maintassist.machines.domain.models.ActivityEntity
import com.jssdvv.ar_maintassist.machines.domain.repositories.ActivityRepository

class DeleteActivity(
    private val repository: ActivityRepository
) {
    suspend operator fun invoke(entity: ActivityEntity) {
        repository.deleteActivity(entity)
    }
}