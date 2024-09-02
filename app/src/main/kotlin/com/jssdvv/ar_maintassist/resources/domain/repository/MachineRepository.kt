package com.jssdvv.ar_maintassist.resources.domain.repository

import com.jssdvv.ar_maintassist.resources.domain.models.MachineEntity
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