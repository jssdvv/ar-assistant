package com.jssdvv.ara.machines.domain.usecases

data class ActivityUseCases(
    val getActivities: GetActivities,
    val insertActivity: InsertActivity,
    val updateActivity: UpdateActivity,
    val deleteActivity: DeleteActivity
)