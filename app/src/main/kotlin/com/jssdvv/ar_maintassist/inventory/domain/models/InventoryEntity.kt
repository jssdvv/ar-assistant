package com.jssdvv.ar_maintassist.inventory.domain.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "inventoryTable")
data class InventoryEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "code") val code: Int? = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "brand") val brand: String?,
    @ColumnInfo(name = "suppliers") val suppliers: String?,
    @ColumnInfo(name = "initialQuantity") val initialQuantity: Float?,
    @ColumnInfo(name = "storageUnit") val storageUnit: String,
    @ColumnInfo(name = "unitCost") val unitCost: Float,
    @ColumnInfo(name = "timestamp") val timestamp : Long
)

class InvalidInventoryItemException(exception: String) : Exception(exception)