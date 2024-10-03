package com.jssdvv.ara.core.presentation.navigation.graphs

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import androidx.navigation.toRoute
import com.jssdvv.ara.core.presentation.AraAppState
import com.jssdvv.ara.core.presentation.navigation.slideInToLeft
import com.jssdvv.ara.core.presentation.navigation.slideOutToRight
import com.jssdvv.ara.machines.presentation.activities_list.ActivitiesListScreen
import com.jssdvv.ara.machines.presentation.add_activity.AddActivityScreen
import com.jssdvv.ara.machines.presentation.add_machine.AddMachineScreen
import com.jssdvv.ara.machines.presentation.ar_camera.ArCameraScreen
import com.jssdvv.ara.machines.presentation.edit_activity.EditActivityScreen
import com.jssdvv.ara.machines.presentation.edit_machine.EditMachineScreen
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
data class EditActivityDestination(val activityId: Int)

@Serializable
object ArCameraDestination

fun NavGraphBuilder.machinesNavGraph(
    appState: AraAppState
) {
    val navHostController = appState.navHostController
   navigation<MachinesNavGraphDestination>(MachinesListDestination) {
        composable<MachinesListDestination> {
            MachinesListScreen(
                onNavigateBack = { navHostController.navigateUp() },
                onNavigateToAddMachine = navHostController::navigateToAddMachine,
                onNavigateToEditMachine = navHostController::navigateToEditMachine,
                onNavigateToActivitiesList = navHostController::navigateToActivitiesList,
            )
        }
        composable<AddMachineDestination>(
            enterTransition = ::slideInToLeft,
            exitTransition = ::slideOutToRight,
            popEnterTransition = ::slideInToLeft,
            popExitTransition = ::slideOutToRight
        ) {
            AddMachineScreen(
                onNavigateBack = { navHostController.navigateUp() }
            )
        }
        composable<EditMachineDestination> {
            val args = it.toRoute<EditMachineDestination>()
            EditMachineScreen(
                machineId = args.machineId,
                onNavigateBack = { navHostController.navigateUp() }
            )
        }
        composable<ActivitiesListDestination>{
            val args = it.toRoute<ActivitiesListDestination>()
            ActivitiesListScreen(
                machineId = args.machineId,
                onNavigateBack = { navHostController.navigateUp() },
                onNavigateToAddActivity = navHostController::navigateToAddActivity,
                onNavigateToEditActivity = navHostController::navigateToEditActivity,
                onNavigateToArCamera = navHostController::navigateToArCamera
            )
        }
        composable<AddActivityDestination> {
            AddActivityScreen()
        }
        composable<EditActivityDestination> {
            val args = it.toRoute<EditActivityDestination>()
            EditActivityScreen(
                activityId = args.activityId
            )
        }
        composable<ArCameraDestination> {
            ArCameraScreen(navHostController = navHostController)
        }
    }
}

internal fun NavController.navigateToAddMachine() =
    navigate(AddMachineDestination)

internal fun NavController.navigateToEditMachine(machineId: Int) =
    navigate(EditMachineDestination(machineId))

fun NavController.navigateToActivitiesList(machineId: Int) =
    navigate(ActivitiesListDestination(machineId))

internal fun NavController.navigateToAddActivity() =
    navigate(AddActivityDestination)

internal fun NavController.navigateToEditActivity(activityId: Int) =
    navigate(EditActivityDestination(activityId))

internal fun NavController.navigateToArCamera() =
    navigate(ArCameraDestination)
