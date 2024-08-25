package com.jssdvv.ar_maintassist.resources.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.jssdvv.ar_maintassist.resources.data.local.entity.MachineEntity

@Dao
interface MachineDao {
    @Query("SELECT * FROM machineTable ORDER BY name ASC")
    fun getAllMachinesByNameAsc(): List<MachineEntity>

    @Query("SELECT * FROM machineTable ORDER BY category ASC")
    fun getAllMachinesByCategoryAsc(): List<MachineEntity>

    @Insert
    fun insertMachine(machineEntity: MachineEntity)

    @Delete
    fun deleteMachine(machineEntity: MachineEntity)

    @Update
    fun updateMachine(machineEntity: MachineEntity)
}