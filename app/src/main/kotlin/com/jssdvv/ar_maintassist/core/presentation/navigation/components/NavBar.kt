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
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun NavBar(
    navHostController: NavHostController,
    modifier: Modifier = Modifier
) {
    var selectedItem by remember { mutableIntStateOf(0) }
    val backStackEntry by navHostController.currentBackStackEntryAsState()

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
                    navHostController.navigate(item.route) {
                        navHostController.graph.findStartDestination().route?.let {
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