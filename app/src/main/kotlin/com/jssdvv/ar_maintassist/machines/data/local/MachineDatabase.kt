package com.jssdvv.ar_maintassist.machines.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jssdvv.ar_maintassist.machines.domain.models.MachineEntity

@Database(entities = [MachineEntity::class], version = 1, exportSchema = false)
abstract class MachineDatabase: RoomDatabase() {
    abstract val dao: MachineDao

    companion object {
        const val DATABASE_NAME = "machineDatabase"
    }
}