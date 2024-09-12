package com.jssdvv.ara.core.presentation.navigation.components

import com.jssdvv.ara.R
import com.jssdvv.ara.core.presentation.navigation.graphs.AgendaNavGraph
import com.jssdvv.ara.core.presentation.navigation.graphs.HomeNavGraph
import com.jssdvv.ara.core.presentation.navigation.graphs.InventoryNavGraph
import com.jssdvv.ara.core.presentation.navigation.graphs.MachinesNavGraph

sealed class AraNavGraphItems(
    val labelTextId: Int,
    val selectedIcon: Int,
    val unselectedIcon: Int,
    val description: String,
    val navGraphDestination: Any
) {
    data object HomeNavItem : AraNavGraphItems(
        labelTextId = R.string.home_title,
        selectedIcon = R.drawable.home_filled,
        unselectedIcon = R.drawable.home_outlined,
        description = "",
        navGraphDestination = HomeNavGraph
    )

    data object MachinesNavItem : AraNavGraphItems(
        labelTextId = R.string.machines_title,
        selectedIcon = R.drawable.tools_filled,
        unselectedIcon = R.drawable.tools_outlined,
        description = "",
        navGraphDestination = MachinesNavGraph
    )

    data object InventoryNavItem : AraNavGraphItems(
        labelTextId = R.string.inventory_title,
        selectedIcon = R.drawable.storage_filled,
        unselectedIcon = R.drawable.storage_outlined,
        description = "",
        navGraphDestination = InventoryNavGraph
    )

    data object AgendaNavItem : AraNavGraphItems(
        labelTextId = R.string.agenda_title,
        selectedIcon = R.drawable.calendar_filled,
        unselectedIcon = R.drawable.calendar_outlined,
        description = "",
        navGraphDestination = AgendaNavGraph
    )
}