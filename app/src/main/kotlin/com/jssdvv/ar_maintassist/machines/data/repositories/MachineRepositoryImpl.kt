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

    override suspend fun insertMachine(entity: MachineEntity) {
        return dao.insertMachine(entity)
    }

    override suspend fun updateMachine(entity: MachineEntity) {
        return dao.updateMachine(entity)
    }

    override suspend fun deleteMachine(entity: MachineEntity) {
        return dao.deleteMachine(entity)
    }
}