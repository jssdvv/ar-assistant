package com.jssdvv.ar_maintassist.machines.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.jssdvv.ar_maintassist.machines.domain.models.MachineEntity
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

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertMachine(entity: MachineEntity)

    @Update(onConflict = OnConflictStrategy.ABORT)
    suspend fun updateMachine(entity: MachineEntity)

    @Delete
    suspend fun deleteMachine(entity: MachineEntity)
}