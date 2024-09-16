package com.jssdvv.ara.core.presentation.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
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
    modifier: Modifier,
) {
    val navHostController = appState.navHostController
    NavHost(
        startDestination = HomeNavGraphDestination,
        navController = navHostController,
        modifier = modifier
    ) {
        homeNavGraph(appState)
        machinesNavGraph(appState)
        inventoryNavGraph(appState)
        agendaNavGraph(appState)
    }
}

fun slideInToLeft(scope: AnimatedContentTransitionScope<NavBackStackEntry>): EnterTransition {
    return scope.slideIntoContainer(
        towards = AnimatedContentTransitionScope.SlideDirection.Left,
        animationSpec = tween(300)
    )
}

fun slideInToRight(scope: AnimatedContentTransitionScope<NavBackStackEntry>): EnterTransition {
    return scope.slideIntoContainer(
        towards = AnimatedContentTransitionScope.SlideDirection.Right,
        animationSpec = tween(300)
    )
}

fun slideOutToLeft(scope: AnimatedContentTransitionScope<NavBackStackEntry>): ExitTransition {
    return scope.slideOutOfContainer(
        towards = AnimatedContentTransitionScope.SlideDirection.Left,
        animationSpec = tween(300)
    )
}

fun slideOutToRight(scope: AnimatedContentTransitionScope<NavBackStackEntry>): ExitTransition {
    return scope.slideOutOfContainer(
        towards = AnimatedContentTransitionScope.SlideDirection.Right,
        animationSpec = tween(300)
    )
}
