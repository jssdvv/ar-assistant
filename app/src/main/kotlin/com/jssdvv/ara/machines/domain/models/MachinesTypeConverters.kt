package com.jssdvv.ara.machines.domain.models

import android.net.Uri
import androidx.room.TypeConverter

class MachinesTypeConverters {
    @TypeConverter
    fun uriToString(uri: Uri?): String? {
        return uri?.toString()
    }

    @TypeConverter
    fun stringToUri(string: String?): Uri? {
        return if (string != null) Uri.parse(string) else null
    }
}