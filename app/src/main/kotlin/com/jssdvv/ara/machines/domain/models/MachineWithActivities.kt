package com.jssdvv.ara.machines.domain.models

import androidx.room.Embedded
import androidx.room.Relation

data class MachineWithActivities(
    @Embedded val machine: MachineEntity,
    @Relation(
        parentColumn = "machineId",
        entityColumn = "machineId"
    )
    val activities: List<ActivityEntity>
)