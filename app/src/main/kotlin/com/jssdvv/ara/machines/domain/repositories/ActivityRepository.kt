package com.jssdvv.ara.machines.domain.repositories

import com.jssdvv.ara.machines.domain.models.ActivityEntity
import kotlinx.coroutines.flow.Flow

interface ActivityRepository {
    fun getAllActivitiesForMachineIdAsc(machineId: Int): Flow<List<ActivityEntity>>

    suspend fun insertActivity(entity: ActivityEntity)

    suspend fun updateActivity(entity: ActivityEntity)

    suspend fun deleteActivity(entity: ActivityEntity)
}