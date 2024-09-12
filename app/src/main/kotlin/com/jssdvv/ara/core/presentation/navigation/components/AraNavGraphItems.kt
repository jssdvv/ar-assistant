package com.jssdvv.ara.core.presentation.navigation.components

import com.jssdvv.ara.R
import com.jssdvv.ara.core.presentation.navigation.graphs.AgendaNavGraphDestination
import com.jssdvv.ara.core.presentation.navigation.graphs.HomeNavGraphDestination
import com.jssdvv.ara.core.presentation.navigation.graphs.InventoryNavGraphDestination
import com.jssdvv.ara.core.presentation.navigation.graphs.MachinesNavGraphDestination

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
        navGraphDestination = HomeNavGraphDestination
    )

    data object MachinesNavItem : AraNavGraphItems(
        labelTextId = R.string.machines_title,
        selectedIcon = R.drawable.tools_filled,
        unselectedIcon = R.drawable.tools_outlined,
        description = "",
        navGraphDestination = MachinesNavGraphDestination
    )

    data object InventoryNavItem : AraNavGraphItems(
        labelTextId = R.string.inventory_title,
        selectedIcon = R.drawable.storage_filled,
        unselectedIcon = R.drawable.storage_outlined,
        description = "",
        navGraphDestination = InventoryNavGraphDestination
    )

    data object AgendaNavItem : AraNavGraphItems(
        labelTextId = R.string.agenda_title,
        selectedIcon = R.drawable.calendar_filled,
        unselectedIcon = R.drawable.calendar_outlined,
        description = "",
        navGraphDestination = AgendaNavGraphDestination
    )
}