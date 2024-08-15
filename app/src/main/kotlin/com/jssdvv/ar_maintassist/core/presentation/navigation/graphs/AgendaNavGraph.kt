package com.jssdvv.ar_maintassist.core.presentation.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.jssdvv.ar_maintassist.agenda.presentation.screens.CalendarScreen
import kotlinx.serialization.Serializable

@Serializable object AgendaNavGraph
@Serializable object CalendarDestination

fun NavGraphBuilder.agendaNavGraph(
    navHostController: NavHostController
){
    navigation<AgendaNavGraph>(startDestination = CalendarDestination){
        composable<CalendarDestination>{
            CalendarScreen(navHostController = navHostController)
        }
    }
}