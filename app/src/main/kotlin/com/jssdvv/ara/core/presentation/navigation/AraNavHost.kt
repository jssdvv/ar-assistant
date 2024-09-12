package com.jssdvv.ara.core.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.jssdvv.ara.core.presentation.AraAppState
import com.jssdvv.ara.core.presentation.navigation.graphs.HomeNavGraphDestination
import com.jssdvv.ara.core.presentation.navigation.graphs.agendaNavGraph
import com.jssdvv.ara.core.presentation.navigation.graphs.homeNavGraph
import com.jssdvv.ara.core.presentation.navigation.graphs.inventoryNavGraph
import com.jssdvv.ara.core.presentation.navigation.graphs.machinesNavGraph

@Composable
fun AraNavHost(
    appState: AraAppState,
    paddingValues: PaddingValues
) {
    val navHostController = appState.navHostController
    NavHost(
        startDestination = HomeNavGraphDestination,
        navController = navHostController,
        modifier = Modifier.padding(paddingValues)
    ) {
        homeNavGraph(navHostController)
        machinesNavGraph(navHostController)
        inventoryNavGraph(navHostController)
        agendaNavGraph(navHostController)
    }
}