package com.jssdvv.ara.machines.domain.repositories

import com.jssdvv.ara.machines.domain.models.MachineEntity
import kotlinx.coroutines.flow.Flow

interface MachineRepository {
    fun getAllMachinesByNameAsc(): Flow<List<MachineEntity>>

    fun getAllMachinesByNameDesc(): Flow<List<MachineEntity>>

    fun getAllMachinesByCategoryAsc(): Flow<List<MachineEntity>>

    fun getAllMachinesByCategoryDesc(): Flow<List<MachineEntity>>

    fun getAllMachinesByTimestampAsc(): Flow<List<MachineEntity>>

    fun getAllMachinesByTimestampDesc(): Flow<List<MachineEntity>>

    suspend fun insertMachine(entity: MachineEntity)

    suspend fun updateMachine(entity: MachineEntity)

    suspend fun deleteMachine(entity: MachineEntity)
}