package com.jssdvv.ar_maintassist.core.presentation.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.jssdvv.ar_maintassist.R

sealed class NavItems(
    val title: Int,
    val route: Any,
    val selectedIcon: Int,
    val unselectedIcon: Int,
    val description: String
) {
    data object HomeItem : NavItems(
        title = R.string.home_title,
        route = HomeGraph,
        selectedIcon = R.drawable.home_filled,
        unselectedIcon = R.drawable.home_outlined,
        description = ""
    )

    data object CamItem : NavItems(
        title = R.string.camera_title,
        route = CameraGraph,
        selectedIcon = R.drawable.ar_filled,
        unselectedIcon = R.drawable.ar_outlined,
        description = ""
    )

    data object DocsItem : NavItems(
        title = R.string.docs_title,
        route = DocumentationGraph,
        selectedIcon = R.drawable.docs_filled,
        unselectedIcon = R.drawable.docs_outlined,
        description = ""
    )

    data object CalendarItem : NavItems(
        title = R.string.calendar_title,
        route = CalendarGraph,
        selectedIcon = R.drawable.calendar_filled,
        unselectedIcon = R.drawable.calendar_outlined,
        description = ""
    )
}

@Composable
fun NavBar(
    navController: NavHostController
) {
    var selectedItem by remember { mutableIntStateOf(0) }
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = backStackEntry?.destination?.parent?.route
    NavigationBar {
        val navItems = listOf(
            NavItems.HomeItem,
            NavItems.CamItem,
            NavItems.DocsItem,
            NavItems.CalendarItem
        )
        navItems.forEach { item ->
            NavigationBarItem(
                selected = true,
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.findStartDestination().route?.let {
                            popUpTo(it) {
                                inclusive = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(item.selectedIcon),
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