package com.jssdvv.ar_maintassist.core.presentation.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.jssdvv.ar_maintassist.resources.presentation.screens.DocumentsScreen
import kotlinx.serialization.Serializable

@Serializable object ResourcesNavGraph
@Serializable object DocumentsDestination

fun NavGraphBuilder.resourcesNavGraph(
    navHostController: NavHostController
){
    navigation<ResourcesNavGraph>(startDestination = DocumentsDestination){
        composable<DocumentsDestination>{
            DocumentsScreen(navHostController = navHostController)
        }
    }
}