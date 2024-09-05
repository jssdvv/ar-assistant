package com.jssdvv.ar_maintassist.inventory.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jssdvv.ar_maintassist.inventory.domain.models.InventoryEntity

@Database(entities = [InventoryEntity::class], version = 1, exportSchema = false)
abstract class InventoryDatabase: RoomDatabase() {
    abstract val dao: InventoryDao

    companion object {
        const val DATABASE_NAME = "inventoryDatabase"
    }
}