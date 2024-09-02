package com.jssdvv.ar_maintassist.resources.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.jssdvv.ar_maintassist.resources.domain.models.MachineEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MachineDao {
    @Query("SELECT * FROM machineTable ORDER BY name ASC")
    fun getAllMachinesByNameAsc(): Flow<List<MachineEntity>>

    @Query("SELECT * FROM machineTable ORDER BY name DESC")
    fun getAllMachinesByNameDesc(): Flow<List<MachineEntity>>

    @Query("SELECT * FROM machineTable ORDER BY category ASC")
    fun getAllMachinesByCategoryAsc(): Flow<List<MachineEntity>>

    @Query("SELECT * FROM machineTable ORDER BY category DESC")
    fun getAllMachinesByCategoryDesc(): Flow<List<MachineEntity>>

    @Query("SELECT * FROM machineTable ORDER BY timestamp ASC")
    fun getAllMachinesByTimestampAsc(): Flow<List<MachineEntity>>

    @Query("SELECT * FROM machineTable ORDER BY timestamp DESC")
    fun getAllMachinesByTimestampDesc(): Flow<List<MachineEntity>>

    @Insert
    suspend fun insertMachine(machineEntity: MachineEntity)

    @Delete
    suspend fun deleteMachine(machineEntity: MachineEntity)

    @Update
    suspend fun updateMachine(machineEntity: MachineEntity)
}