package com.jssdvv.ar_maintassist.machines.domain.repositories

import com.jssdvv.ar_maintassist.machines.domain.models.MachineEntity
import kotlinx.coroutines.flow.Flow

interface MachineRepository {
    fun getAllMachinesByNameAsc(): Flow<List<MachineEntity>>

    fun getAllMachinesByNameDesc(): Flow<List<MachineEntity>>

    fun getAllMachinesByCategoryAsc(): Flow<List<MachineEntity>>

    fun getAllMachinesByCategoryDesc(): Flow<List<MachineEntity>>

    fun getAllMachinesByTimestampAsc(): Flow<List<MachineEntity>>

    fun getAllMachinesByTimestampDesc(): Flow<List<MachineEntity>>

    suspend fun insertMachine(machineEntity: MachineEntity)

    suspend fun deleteMachine(machineEntity: MachineEntity)

    suspend fun updateMachine(machineEntity: MachineEntity)
}