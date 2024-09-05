package com.jssdvv.ar_maintassist.inventory.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.jssdvv.ar_maintassist.inventory.domain.models.InventoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface InventoryDao {

    @Query("SELECT * FROM inventoryTable ORDER BY name ASC")
    fun getAllItemsByNameAsc(): Flow<List<InventoryEntity>>

    @Query("SELECT * FROM inventoryTable ORDER BY name DESC")
    fun getAllItemsByNameDesc(): Flow<List<InventoryEntity>>

    @Query("SELECT * FROM inventoryTable ORDER BY code ASC")
    fun getAllItemsByCodeAsc(): Flow<List<InventoryEntity>>

    @Query("SELECT * FROM inventoryTable ORDER BY code DESC")
    fun getAllItemsByCodeDesc(): Flow<List<InventoryEntity>>

    @Query("SELECT * FROM inventoryTable ORDER BY timestamp ASC")
    fun getAllItemsByTimestampAsc(): Flow<List<InventoryEntity>>

    @Query("SELECT * FROM inventoryTable ORDER BY timestamp DESC")
    fun getAllItemsByTimestampDesc(): Flow<List<InventoryEntity>>

    @Insert
    suspend fun insertItem(inventoryEntity: InventoryEntity)

    @Delete
    suspend fun deleteItem(inventoryEntity: InventoryEntity)

    @Update
    suspend fun updateItem(inventoryEntity: InventoryEntity)
}