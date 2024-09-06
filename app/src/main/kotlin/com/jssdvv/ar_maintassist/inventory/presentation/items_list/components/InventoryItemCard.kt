package com.jssdvv.ar_maintassist.inventory.presentation.items_list.components

import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.os.Build
import android.provider.MediaStore
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.jssdvv.ar_maintassist.inventory.domain.models.InventoryItemEntity
import java.io.IOException

@Composable
fun InventoryItemCard(
    modifier: Modifier,
    inventoryItemEntity: InventoryItemEntity
) {
    val context = LocalContext.current
    var bitmap by remember { mutableStateOf<Bitmap?>(null) }

    LaunchedEffect(inventoryItemEntity.imageUri) {
        if (inventoryItemEntity.imageUri != null) {
            try {
                bitmap = if (Build.VERSION.SDK_INT < 28) {
                    MediaStore.Images.Media.getBitmap(
                        context.contentResolver,
                        inventoryItemEntity.imageUri
                    )
                } else {
                    val source = ImageDecoder.createSource(
                        context.contentResolver,
                        inventoryItemEntity.imageUri
                    )
                    ImageDecoder.decodeBitmap(source)
                }
            } catch (e: SecurityException) {
                Log.d("PERMISSION_IMAGES","NOT READ IMAGES PERMISSIONS GRANTED")
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

    ElevatedCard(
        modifier = modifier,
        onClick = {},
    ) {
        Row(
            modifier = Modifier.padding(8.dp)
        ) {

            if (bitmap != null) {
                Image(
                    modifier = Modifier
                        .size(40.dp)
                        .aspectRatio(1f),
                    bitmap = bitmap!!.asImageBitmap(),
                    contentDescription = ""
                )
            } else {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .aspectRatio(1f)
                        .background(Color.Green)
                )
            }
            Spacer(modifier = Modifier.padding(8.dp))
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Titulo")
                Spacer(modifier = Modifier.padding(8.dp))
                Text("Cantidad: 10")
            }
        }
    }
}