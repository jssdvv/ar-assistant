package com.jssdvv.ara.machines.presentation.activities_list

import com.jssdvv.ara.machines.domain.models.ActivityEntity

sealed class ActivitiesListEvent {
    data class GetMachineId(val machineId: Int): ActivitiesListEvent()
    data class InsertActivity(val entity: ActivityEntity) : ActivitiesListEvent()
    data class UpdateActivity(val entity: ActivityEntity) : ActivitiesListEvent()
    data class DeleteActivity(val entity: ActivityEntity) : ActivitiesListEvent()
    data object RestoreActivity: ActivitiesListEvent()
}