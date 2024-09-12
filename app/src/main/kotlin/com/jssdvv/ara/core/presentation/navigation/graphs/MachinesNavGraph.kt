package com.jssdvv.ara.core.presentation.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import androidx.navigation.toRoute
import com.jssdvv.ara.machines.presentation.activities_list.ActivitiesListScreen
import com.jssdvv.ara.machines.presentation.ar_camera.ArCameraScreen
import com.jssdvv.ara.machines.presentation.machines_list.MachinesListScreen
import kotlinx.serialization.Serializable

@Serializable object MachinesNavGraph
@Serializable object MachinesListDestination
@Serializable data class ActivitiesListDestination(val machineId: Int)
@Serializable object ArCameraDestination

fun NavGraphBuilder.machinesNavGraph(
    navHostController: NavHostController
){
    navigation<MachinesNavGraph>(startDestination = MachinesListDestination){
        composable<MachinesListDestination>{
            MachinesListScreen(navHostController = navHostController)
        }
        composable<ActivitiesListDestination>{
            val args = it.toRoute<ActivitiesListDestination>()
            ActivitiesListScreen(
                navHostController = navHostController,
                machineId = args.machineId
            )
        }
        composable<ArCameraDestination>{
            ArCameraScreen(navHostController = navHostController)
        }
    }
}