package com.jssdvv.ar_maintassist.machines.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.jssdvv.ar_maintassist.machines.domain.models.MachineEntity
import com.jssdvv.ar_maintassist.machines.domain.models.MachineTypeConverter

@Database(entities = [MachineEntity::class], version = 1, exportSchema = false)
@TypeConverters(MachineTypeConverter::class)
abstract class MachineDatabase : RoomDatabase() {
    abstract val dao: MachineDao

    companion object {
        const val DATABASE_NAME = "machineDatabase"
    }
}