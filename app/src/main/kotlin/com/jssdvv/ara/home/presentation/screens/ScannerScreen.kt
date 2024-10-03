package com.jssdvv.ara.home.presentation.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.navigation.NavHostController
import com.google.mlkit.vision.barcode.common.Barcode
import com.jssdvv.ara.home.data.repositories.ImageAnalyzerRepositoryImpl
import com.jssdvv.ara.home.presentation.screens.components.CameraPreview

@Composable
fun ScannerScreen(
    onNavigateToActivityList: (Int) -> Unit
) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val detectedBarcodes = remember { mutableStateListOf<Barcode>() }

    CameraPreview(
        context = context,
        analyzer = ImageAnalyzerRepositoryImpl(
            onBarcodesDetected = { barcodes ->
                detectedBarcodes.clear()
                detectedBarcodes.addAll(barcodes)

                if (detectedBarcodes.size > 1) {
                    detectedBarcodes.first()
                        .displayValue?.let {
                            val integer = it.toIntOrNull()
                            if (integer != null) {
                                onNavigateToActivityList(integer)
                            }
                        }
                }
            }
        ),
        lifecycleOwner = lifecycleOwner
    )
}