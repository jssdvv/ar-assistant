package com.jssdvv.ar_maintassist.core.presentation.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.jssdvv.ar_maintassist.core.presentation.navigation.components.NavBar
import com.jssdvv.ar_maintassist.core.presentation.navigation.graphs.HomeNavGraph
import com.jssdvv.ar_maintassist.core.presentation.navigation.graphs.agendaNavGraph
import com.jssdvv.ar_maintassist.core.presentation.navigation.graphs.cameraNavGraph
import com.jssdvv.ar_maintassist.core.presentation.navigation.graphs.homeNavGraph
import com.jssdvv.ar_maintassist.core.presentation.navigation.graphs.resourcesNavGraph

@Composable
fun NavHost(
    modifier: Modifier = Modifier
) {
    val navHostController = rememberNavController()
    Scaffold(
        topBar = {},
        bottomBar = { NavBar(navHostController = navHostController) }
    ) { paddingValues ->
        NavHost(
            startDestination = HomeNavGraph,
            navController = navHostController,
            modifier = Modifier.padding(paddingValues)
        ) {
            homeNavGraph(navHostController)
            cameraNavGraph(navHostController)
            resourcesNavGraph(navHostController)
            agendaNavGraph(navHostController)
        }
    }
}