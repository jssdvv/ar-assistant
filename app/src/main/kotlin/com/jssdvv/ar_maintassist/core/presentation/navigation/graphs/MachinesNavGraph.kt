package com.jssdvv.ar_maintassist.core.presentation.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.jssdvv.ar_maintassist.resources.presentation.screens.MachinesListScreen
import com.jssdvv.ar_maintassist.resources.presentation.screens.MachineDataScreen
import kotlinx.serialization.Serializable

@Serializable object MachinesNavGraph
@Serializable object MachinesListDestination
@Serializable object MachineDataDestination

fun NavGraphBuilder.resourcesNavGraph(
    navHostController: NavHostController
){
    navigation<MachinesNavGraph>(startDestination = MachinesListDestination){
        composable<MachinesListDestination>{
            MachinesListScreen(navHostController = navHostController)
        }
        composable<MachineDataDestination>{
            MachineDataScreen(navHostController = navHostController)
        }
    }
}