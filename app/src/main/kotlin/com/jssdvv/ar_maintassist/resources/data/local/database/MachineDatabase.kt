package com.jssdvv.ar_maintassist.resources.data.local.database

import androidx.compose.ui.platform.LocalContext
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jssdvv.ar_maintassist.resources.data.local.dao.MachineDao
import com.jssdvv.ar_maintassist.resources.data.local.entity.MachineEntity

@Database(entities = [MachineEntity::class], version = 1, exportSchema = false)
abstract class MachineDatabase: RoomDatabase() {
    abstract val machineDao: MachineDao
}


