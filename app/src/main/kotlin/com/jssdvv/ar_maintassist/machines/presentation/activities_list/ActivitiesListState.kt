package com.jssdvv.ar_maintassist.machines.presentation.activities_list

import com.jssdvv.ar_maintassist.machines.domain.models.ActivityEntity

data class ActivitiesListState(
    val activities: List<ActivityEntity> = emptyList(),
    val machineId: Int? = null
)