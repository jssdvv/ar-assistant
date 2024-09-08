package com.jssdvv.ar_maintassist.machines.domain.repositories

import com.jssdvv.ar_maintassist.machines.domain.models.ActivityEntity
import kotlinx.coroutines.flow.Flow

interface ActivityRepository {
    fun getAllActivitiesForMachineIdAsc(machineId: Int): Flow<List<ActivityEntity>>

    suspend fun insertActivity(entity: ActivityEntity)

    suspend fun updateActivity(entity: ActivityEntity)

    suspend fun deleteActivity(entity: ActivityEntity)
}