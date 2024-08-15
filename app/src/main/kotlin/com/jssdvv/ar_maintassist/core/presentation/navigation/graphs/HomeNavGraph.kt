package com.jssdvv.ar_maintassist.core.presentation.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.jssdvv.ar_maintassist.home.presentation.screens.HomeScreen
import kotlinx.serialization.Serializable

@Serializable object HomeNavGraph
@Serializable object HomeDestination

fun NavGraphBuilder.homeNavGraph(
    navHostController : NavHostController
) {
    navigation<HomeNavGraph>(startDestination = HomeDestination){
        composable<HomeDestination>{
            HomeScreen(navHostController = navHostController)
        }
    }
}