package com.jssdvv.ar_maintassist.core.presentation.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.jssdvv.ar_maintassist.core.presentation.navigation.components.NavBar
import com.jssdvv.ar_maintassist.core.presentation.navigation.graphs.HomeNavGraph
import com.jssdvv.ar_maintassist.core.presentation.navigation.graphs.agendaNavGraph
import com.jssdvv.ar_maintassist.core.presentation.navigation.graphs.homeNavGraph
import com.jssdvv.ar_maintassist.core.presentation.navigation.graphs.inventoryNavGraph
import com.jssdvv.ar_maintassist.core.presentation.navigation.graphs.machinesNavGraph

@Composable
fun NavHost(
    modifier: Modifier = Modifier
) {
    val navHostController = rememberNavController()
    val backStackEntry = navHostController.currentBackStackEntryAsState().value
    val currentDestination = backStackEntry?.destination
    val currentStartGraphDestination = backStackEntry?.destination?.parent?.findStartDestination()
    Scaffold(
        topBar = {},
        bottomBar = {
            if (currentDestination == currentStartGraphDestination) {
                NavBar(navHostController = navHostController)
            }
        }
    ) { paddingValues ->
        NavHost(
            startDestination = HomeNavGraph,
            navController = navHostController,
            modifier = Modifier.padding(paddingValues)
        ) {
            homeNavGraph(navHostController)
            machinesNavGraph(navHostController)
            inventoryNavGraph(navHostController)
            agendaNavGraph(navHostController)
        }
    }
}