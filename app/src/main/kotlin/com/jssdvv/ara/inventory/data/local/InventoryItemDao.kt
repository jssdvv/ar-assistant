package com.jssdvv.ara.inventory.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.jssdvv.ara.inventory.domain.models.InventoryItemEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface InventoryItemDao {
    @Query("SELECT * FROM inventoryItemsTable ORDER BY id ASC")
    fun getAllInventoryItemsByCodeAsc(): Flow<List<InventoryItemEntity>>

    @Query("SELECT * FROM inventoryItemsTable ORDER BY id DESC")
    fun getAllInventoryItemsByCodeDesc(): Flow<List<InventoryItemEntity>>

    @Query("SELECT * FROM inventoryItemsTable ORDER BY name ASC")
    fun getAllInventoryItemsByNameAsc(): Flow<List<InventoryItemEntity>>

    @Query("SELECT * FROM inventoryItemsTable ORDER BY name DESC")
    fun getAllInventoryItemsByNameDesc(): Flow<List<InventoryItemEntity>>

    @Query("SELECT * FROM inventoryItemsTable ORDER BY timestamp ASC")
    fun getAllInventoryItemsByTimestampAsc(): Flow<List<InventoryItemEntity>>

    @Query("SELECT * FROM inventoryItemsTable ORDER BY timestamp DESC")
    fun getAllInventoryItemsByTimestampDesc(): Flow<List<InventoryItemEntity>>

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertInventoryItem(entity: InventoryItemEntity)

    @Update(onConflict = OnConflictStrategy.ABORT)
    suspend fun updateInventoryItem(entity: InventoryItemEntity)

    @Delete
    suspend fun deleteInventoryItem(entity: InventoryItemEntity)
}