package com.jssdvv.ar_maintassist.core.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.jssdvv.ar_maintassist.calendar.presentation.screens.CalendarScreen
import com.jssdvv.ar_maintassist.camera.presentation.SceneView
import com.jssdvv.ar_maintassist.camera.presentation.screens.CameraScreen
import com.jssdvv.ar_maintassist.documentation.presentation.screens.DocumentationScreen
import com.jssdvv.ar_maintassist.home.presentation.screens.HomeScreen
import kotlinx.serialization.Serializable

@Serializable object HomeGraph
@Serializable object HomeDestination

@Serializable object CameraGraph
@Serializable object CameraDestination

@Serializable object CalendarGraph
@Serializable object CalendarDestination

@Serializable object DocumentationGraph
@Serializable object DocumentationDestination

@Composable
fun NavHost(
    navController: NavHostController,
    paddingValues: PaddingValues
) {
    NavHost(
        startDestination = HomeGraph,
        navController = navController,
        modifier = Modifier.padding(paddingValues)
    ) {
        navigation<HomeGraph>(startDestination = HomeDestination){
            composable<HomeDestination>{
                HomeScreen(navHostController = navController)
            }
        }
        navigation<CameraGraph>(startDestination = CameraDestination){
            composable<CameraDestination>{
                SceneView()
            }
        }
        navigation<CalendarGraph>(startDestination = CalendarDestination){
            composable<CalendarDestination>{
                CalendarScreen(navHostController = navController)
            }
        }
        navigation<DocumentationGraph>(startDestination = DocumentationDestination){
            composable<DocumentationDestination>{
                DocumentationScreen(navHostController = navController)
            }
        }
    }
}