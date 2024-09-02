package com.jssdvv.ar_maintassist.resources.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jssdvv.ar_maintassist.resources.domain.models.MachineEntity

@Database(entities = [MachineEntity::class], version = 1, exportSchema = false)
abstract class MachineDatabase: RoomDatabase() {
    abstract val machineDao: MachineDao

    companion object {
        const val DATABASE_NAME = "machineDb"
    }
}