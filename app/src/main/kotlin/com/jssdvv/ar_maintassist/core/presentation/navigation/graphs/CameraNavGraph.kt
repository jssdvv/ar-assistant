package com.jssdvv.ar_maintassist.core.presentation.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.jssdvv.ar_maintassist.camera.presentation.screens.CameraScreen
import kotlinx.serialization.Serializable

@Serializable object CameraNavGraph
@Serializable object CameraDestination

fun NavGraphBuilder.cameraNavGraph(navHostController: NavHostController) {
    navigation<CameraNavGraph>(startDestination = CameraDestination) {
        composable<CameraDestination> {
            CameraScreen(navHostController = navHostController)
        }
    }
}