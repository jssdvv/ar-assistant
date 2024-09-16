package com.jssdvv.ara.core.presentation.navigation.components

import com.jssdvv.ara.R
import com.jssdvv.ara.core.presentation.navigation.graphs.AgendaNavGraphDestination
import com.jssdvv.ara.core.presentation.navigation.graphs.HomeNavGraphDestination
import com.jssdvv.ara.core.presentation.navigation.graphs.InventoryNavGraphDestination
import com.jssdvv.ara.core.presentation.navigation.graphs.MachinesNavGraphDestination

sealed class AraNavGraphItems(
    val labelTextId: Int,
    val selectedIconId: Int,
    val unselectedIconId: Int,
    val description: String,
    val navGraphDestination: Any
) {
    data object HomeNavItem : AraNavGraphItems(
        labelTextId = R.string.home_title,
        selectedIconId = R.drawable.home_filled,
        unselectedIconId = R.drawable.home_outlined,
        description = "",
        navGraphDestination = HomeNavGraphDestination
    )

    data object MachinesNavItem : AraNavGraphItems(
        labelTextId = R.string.machines_title,
        selectedIconId = R.drawable.tools_filled,
        unselectedIconId = R.drawable.tools_outlined,
        description = "",
        navGraphDestination = MachinesNavGraphDestination
    )

    data object InventoryNavItem : AraNavGraphItems(
        labelTextId = R.string.inventory_title,
        selectedIconId = R.drawable.storage_filled,
        unselectedIconId = R.drawable.storage_outlined,
        description = "",
        navGraphDestination = InventoryNavGraphDestination
    )

    data object AgendaNavItem : AraNavGraphItems(
        labelTextId = R.string.agenda_title,
        selectedIconId = R.drawable.calendar_filled,
        unselectedIconId = R.drawable.calendar_outlined,
        description = "",
        navGraphDestination = AgendaNavGraphDestination
    )
}