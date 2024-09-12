package com.jssdvv.ara.machines.domain.usecases

import com.jssdvv.ara.machines.domain.models.ActivityEntity
import com.jssdvv.ara.machines.domain.repositories.ActivityRepository
import kotlinx.coroutines.flow.Flow

class GetActivities(
    private val repository: ActivityRepository
) {
    operator fun invoke(machineId: Int): Flow<List<ActivityEntity>> {
        return repository.getAllActivitiesForMachineIdAsc(machineId)
    }
}