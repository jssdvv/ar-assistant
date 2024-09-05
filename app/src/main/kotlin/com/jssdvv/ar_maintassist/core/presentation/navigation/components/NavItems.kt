package com.jssdvv.ar_maintassist.core.presentation.navigation.components

import com.jssdvv.ar_maintassist.R
import com.jssdvv.ar_maintassist.core.presentation.navigation.graphs.AgendaNavGraph
import com.jssdvv.ar_maintassist.core.presentation.navigation.graphs.InventoryNavGraph
import com.jssdvv.ar_maintassist.core.presentation.navigation.graphs.HomeNavGraph
import com.jssdvv.ar_maintassist.core.presentation.navigation.graphs.MachinesNavGraph

sealed class NavItems(
    val title: Int,
    val route: Any,
    val selectedIcon: Int,
    val unselectedIcon: Int,
    val description: String
) {
    data object HomeNavItem : NavItems(
        title = R.string.home_title,
        route = HomeNavGraph,
        selectedIcon = R.drawable.home_filled,
        unselectedIcon = R.drawable.home_outlined,
        description = ""
    )

    data object MachinesNavItem : NavItems(
        title = R.string.machines_title,
        route = MachinesNavGraph,
        selectedIcon = R.drawable.tools_filled,
        unselectedIcon = R.drawable.tools_outlined,
        description = ""
    )

    data object InventoryNavItem : NavItems(
        title = R.string.inventory_title,
        route = InventoryNavGraph,
        selectedIcon = R.drawable.storage_filled,
        unselectedIcon = R.drawable.storage_outlined,
        description = ""
    )

    data object AgendaNavItem : NavItems(
        title = R.string.agenda_title,
        route = AgendaNavGraph,
        selectedIcon = R.drawable.calendar_filled,
        unselectedIcon = R.drawable.calendar_outlined,
        description = ""
    )
}