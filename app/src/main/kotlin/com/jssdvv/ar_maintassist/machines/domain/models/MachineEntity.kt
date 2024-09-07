package com.jssdvv.ar_maintassist.machines.domain.models

import android.net.Uri
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter

@Entity(tableName = "machineTable")
data class MachineEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "category") val category: String,
    @ColumnInfo(name = "imageUri") val imageUri: Uri?,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "timestamp") val timestamp: Long
)

class InvalidMachineException(exception: String) : Exception(exception)

class MachineTypeConverter {
    @TypeConverter
    fun uriToString(uri: Uri?): String? {
        return uri?.toString()
    }

    @TypeConverter
    fun stringToUri(string: String?): Uri? {
        return if (string != null) Uri.parse(string) else null
    }
}