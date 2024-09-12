package com.jssdvv.ara.core.presentation.navigation.graphs

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import androidx.navigation.toRoute
import com.jssdvv.ara.machines.presentation.activities_list.ActivitiesListScreen
import com.jssdvv.ara.machines.presentation.addactivity.AddActivityScreen
import com.jssdvv.ara.machines.presentation.addmachine.AddMachineScreen
import com.jssdvv.ara.machines.presentation.ar_camera.ArCameraScreen
import com.jssdvv.ara.machines.presentation.editmachine.EditMachineScreen
import com.jssdvv.ara.machines.presentation.machines_list.MachinesListScreen
import kotlinx.serialization.Serializable

@Serializable
object MachinesNavGraphDestination

@Serializable
object MachinesListDestination

@Serializable
object AddMachineDestination

@Serializable
data class EditMachineDestination(val machineId: Int)

@Serializable
data class ActivitiesListDestination(val machineId: Int)

@Serializable
object AddActivityDestination

@Serializable
object ArCameraDestination

fun NavGraphBuilder.machinesNavGraph(
    navHostController: NavHostController
) {
    navigation<MachinesNavGraphDestination>(MachinesListDestination) {
        composable<MachinesListDestination> {
            MachinesListScreen(
                onNavigateToActivitiesList = navHostController::navigateToActivitiesList,
                onNavigateToEditMachine = navHostController::navigateToEditMachine,
            )
        }
        composable<AddMachineDestination> {
            AddMachineScreen()
        }
        composable<EditMachineDestination> {
            val args = it.toRoute<EditMachineDestination>()
            EditMachineScreen(
                machineId = args.machineId
            )
        }
        composable<ActivitiesListDestination> {
            val args = it.toRoute<ActivitiesListDestination>()
            ActivitiesListScreen(
                navHostController = navHostController,
                machineId = args.machineId,
                onNavigateToAddActivity = navHostController::navigateToAddActivity,
                onNavigateToArCamera = navHostController::navigateToArCamera
            )
        }
        composable<AddActivityDestination> {
            AddActivityScreen()
        }
        composable<ArCameraDestination> {
            ArCameraScreen(navHostController = navHostController)
        }
    }
}

fun NavController.navigateToActivitiesList(machineId: Int) =
    navigate(ActivitiesListDestination(machineId))

fun NavController.navigateToEditMachine(machineId: Int) =
    navigate(EditMachineDestination(machineId))

fun NavController.navigateToAddMachine() =
    navigate(AddMachineDestination)

fun NavController.navigateToAddActivity() =
    navigate(AddActivityDestination)

fun NavController.navigateToArCamera() =
    navigate(ArCameraDestination)

