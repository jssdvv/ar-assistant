package com.jssdvv.ar_maintassist.core.presentation.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.jssdvv.ar_maintassist.machines.presentation.ar_camera.ArCameraScreen
import com.jssdvv.ar_maintassist.machines.presentation.machines_list.MachinesListScreen
import com.jssdvv.ar_maintassist.machines.presentation.machine_data.MachineDataScreen
import kotlinx.serialization.Serializable

@Serializable object MachinesNavGraph
@Serializable object MachinesListDestination
@Serializable object MachineDataDestination
@Serializable object ArCameraDestination

fun NavGraphBuilder.machinesNavGraph(
    navHostController: NavHostController
){
    navigation<MachinesNavGraph>(startDestination = MachinesListDestination){
        composable<MachinesListDestination>{
            MachinesListScreen(navHostController = navHostController)
        }
        composable<MachineDataDestination>{
            MachineDataScreen(navHostController = navHostController)
        }
        composable<ArCameraDestination>{
            ArCameraScreen(navHostController = navHostController)
        }
    }
}