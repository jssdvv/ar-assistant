package com.jssdvv.ar_maintassist.machines.data.repositories

import com.jssdvv.ar_maintassist.machines.data.local.MachineDao
import com.jssdvv.ar_maintassist.machines.domain.models.MachineEntity
import com.jssdvv.ar_maintassist.machines.domain.repositories.MachineRepository
import kotlinx.coroutines.flow.Flow

class MachineRepositoryImpl(
    private val dao: MachineDao
) : MachineRepository {
    override fun getAllMachinesByNameAsc(): Flow<List<MachineEntity>> {
        return dao.getAllMachinesByNameAsc()
    }

    override fun getAllMachinesByNameDesc(): Flow<List<MachineEntity>> {
        return dao.getAllMachinesByNameDesc()
    }

    override fun getAllMachinesByCategoryAsc(): Flow<List<MachineEntity>> {
        return dao.getAllMachinesByCategoryAsc()
    }

    override fun getAllMachinesByCategoryDesc(): Flow<List<MachineEntity>> {
        return dao.getAllMachinesByCategoryDesc()
    }

    override fun getAllMachinesByTimestampAsc(): Flow<List<MachineEntity>> {
        return dao.getAllMachinesByTimestampAsc()
    }

    override fun getAllMachinesByTimestampDesc(): Flow<List<MachineEntity>> {
        return dao.getAllMachinesByTimestampDesc()
    }

    override suspend fun insertMachine(machineEntity: MachineEntity) {
        return dao.insertMachine(machineEntity)
    }

    override suspend fun deleteMachine(machineEntity: MachineEntity) {
        return dao.deleteMachine(machineEntity)
    }

    override suspend fun updateMachine(machineEntity: MachineEntity) {
        return dao.updateMachine(machineEntity)
    }
}