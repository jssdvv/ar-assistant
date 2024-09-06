package com.jssdvv.ar_maintassist.inventory.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.jssdvv.ar_maintassist.inventory.domain.models.InventoryItemEntity
import com.jssdvv.ar_maintassist.inventory.domain.models.InventoryItemTypeConverter

@Database(entities = [InventoryItemEntity::class], version = 1, exportSchema = false)
@TypeConverters(InventoryItemTypeConverter::class)
abstract class InventoryItemDatabase : RoomDatabase() {
    abstract val dao: InventoryItemDao

    companion object {
        const val DATABASE_NAME = "inventoryItemDatabase"
    }
}