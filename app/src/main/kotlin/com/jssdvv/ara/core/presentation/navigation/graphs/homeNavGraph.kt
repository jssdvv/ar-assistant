package com.jssdvv.ara.core.presentation.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.jssdvv.ara.home.presentation.screens.HomeScreen
import kotlinx.serialization.Serializable

@Serializable object HomeNavGraphDestination
@Serializable object HomeDestination

fun NavGraphBuilder.homeNavGraph(
    navHostController : NavHostController
) {
    navigation<HomeNavGraphDestination>(startDestination = HomeDestination){
        composable<HomeDestination>{
            HomeScreen(navHostController = navHostController)
        }
    }
}