package com.jssdvv.ar_maintassist.core.presentation.navigation.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun NavBar(
    navHostController: NavHostController,
    modifier: Modifier = Modifier
) {
    val backStackEntry = navHostController.currentBackStackEntryAsState().value
    NavigationBar {
        val navItems = listOf(
            NavItems.HomeItem,
            NavItems.CamItem,
            NavItems.DocsItem,
            NavItems.CalendarItem
        )
        navItems.forEach { item ->
            val selected = backStackEntry?.destination?.hierarchy?.any { navDestination ->
                navDestination.hasRoute(item.route::class)
            } == true
            NavigationBarItem(
                selected = selected,
                onClick = {
                    navHostController.navigate(item.route) {
                        popUpTo(navHostController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(
                            if (selected) item.selectedIcon else item.unselectedIcon
                        ),
                        contentDescription = item.description
                    )
                },
                label = {
                    Text(
                        text = stringResource(id = item.title)
                    )
                }
            )
        }
    }
}