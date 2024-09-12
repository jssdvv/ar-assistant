package com.jssdvv.ara.core.presentation.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.jssdvv.ara.agenda.presentation.screens.CalendarScreen
import kotlinx.serialization.Serializable

@Serializable object AgendaNavGraphDestination
@Serializable object CalendarDestination

fun NavGraphBuilder.agendaNavGraph(
    navHostController: NavHostController
) {
    navigation<AgendaNavGraphDestination>(startDestination = CalendarDestination) {
        composable<CalendarDestination> {
            CalendarScreen(navHostController = navHostController)
        }
    }
}