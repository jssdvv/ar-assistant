package com.jssdvv.ara.core.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.WindowAdaptiveInfo
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffoldDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteType
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.window.core.layout.WindowWidthSizeClass
import com.jssdvv.ara.core.presentation.navigation.AraNavHost

@Composable
fun AraApp(
    appState: AraAppState,
    windowAdaptiveInfo: WindowAdaptiveInfo = currentWindowAdaptiveInfo()
) {
    AraApp(
        appState = appState,
        modifier = Modifier,
        windowAdaptiveInfo = windowAdaptiveInfo
    )
}

@Composable
internal fun AraApp(
    appState: AraAppState,
    modifier: Modifier,
    windowAdaptiveInfo: WindowAdaptiveInfo
) {
    val currentDestination = appState.currentDestination
    val currentGraphDestination = appState.currentNavGraphDestination
    val layoutType = with(windowAdaptiveInfo) {
        if (currentDestination == currentGraphDestination) {
            when (windowSizeClass.windowWidthSizeClass) {
                WindowWidthSizeClass.EXPANDED -> NavigationSuiteType.NavigationRail
                else -> NavigationSuiteScaffoldDefaults.calculateFromAdaptiveInfo(windowAdaptiveInfo)
            }
        } else {
            NavigationSuiteType.None
        }
    }
    NavigationSuiteScaffold(
        navigationSuiteItems = {
            appState.navGraphItems.forEach { navGraphItem ->
                val selected = currentGraphDestination
                    .isDestinationInHierarchy(navGraphItem.navGraphDestination)
                val onClick = {
                    appState.navigateToGraphDestination(navGraphItem.navGraphDestination)
                }
                item(
                    selected = selected,
                    onClick = onClick,
                    icon = {
                        Icon(
                            painter = painterResource(
                                if (selected) navGraphItem.selectedIconId else navGraphItem.unselectedIconId
                            ),
                            contentDescription = navGraphItem.description
                        )
                    },
                    modifier = Modifier,
                    label = { Text(stringResource(navGraphItem.labelTextId)) }
                )
            }
        },
        modifier = modifier,
        layoutType = layoutType
    ) {
        Scaffold { paddingValues ->
            AraNavHost(
                appState = appState,
                modifier = Modifier.padding(paddingValues)
            )
        }
    }
}

private fun NavDestination?.isDestinationInHierarchy(destination: Any): Boolean {
    return this?.hierarchy?.any { navDestination ->
        navDestination.hasRoute(destination::class)
    } ?: false
}