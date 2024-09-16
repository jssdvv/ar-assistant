package com.jssdvv.ara.core.presentation.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.jssdvv.ara.agenda.presentation.screens.CalendarScreen
import com.jssdvv.ara.core.presentation.AraAppState
import kotlinx.serialization.Serializable

@Serializable
object AgendaNavGraphDestination

@Serializable
object CalendarDestination

fun NavGraphBuilder.agendaNavGraph(
    appState: AraAppState
) {
    val navHostController = appState.navHostController
    navigation<AgendaNavGraphDestination>(startDestination = CalendarDestination) {
        composable<CalendarDestination> {
            CalendarScreen(navHostController = navHostController)
        }
    }
}
