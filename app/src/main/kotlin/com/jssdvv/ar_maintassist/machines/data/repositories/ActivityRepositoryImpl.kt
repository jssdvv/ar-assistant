package com.jssdvv.ar_maintassist.machines.data.repositories

import com.jssdvv.ar_maintassist.machines.data.local.ActivityDao
import com.jssdvv.ar_maintassist.machines.domain.models.ActivityEntity
import com.jssdvv.ar_maintassist.machines.domain.repositories.ActivityRepository
import kotlinx.coroutines.flow.Flow

class ActivityRepositoryImpl(
    private val dao: ActivityDao
) : ActivityRepository {
    override fun getAllActivitiesForMachineIdAsc(machineId: Int): Flow<List<ActivityEntity>> {
        return dao.getAllActivitiesForMachineIdAsc(machineId)
    }

    override suspend fun insertActivity(entity: ActivityEntity) {
        return dao.insertActivity(entity)
    }

    override suspend fun updateActivity(entity: ActivityEntity) {
        return dao.updateActivity(entity)
    }

    override suspend fun deleteActivity(entity: ActivityEntity) {
        return dao.deleteActivity(entity)
    }
}