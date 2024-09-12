package com.jssdvv.ara.machines.presentation.activities_list

import com.jssdvv.ara.machines.domain.models.ActivityEntity

data class ActivitiesListState(
    val activities: List<ActivityEntity> = emptyList(),
    val machineId: Int? = null
)