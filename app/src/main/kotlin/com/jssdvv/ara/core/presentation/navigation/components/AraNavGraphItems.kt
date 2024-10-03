package com.jssdvv.ara.core.presentation.navigation.components

import com.jssdvv.ara.R
import com.jssdvv.ara.core.presentation.navigation.graphs.AgendaNavGraphDestination
import com.jssdvv.ara.core.presentation.navigation.graphs.ScannerNavGraphDestination
import com.jssdvv.ara.core.presentation.navigation.graphs.InventoryNavGraphDestination
import com.jssdvv.ara.core.presentation.navigation.graphs.MachinesNavGraphDestination

sealed class AraNavGraphItems(
    val labelTextId: Int,
    val selectedIconId: Int,
    val unselectedIconId: Int,
    val description: String,
    val navGraphDestination: Any
) {
    data object ScannerNavItem : AraNavGraphItems(
        labelTextId = R.string.scanner_title,
        selectedIconId = R.drawable.scanner_filled,
        unselectedIconId = R.drawable.scanner_outlined,
        description = "",
        navGraphDestination = ScannerNavGraphDestination
    )

    data object MachinesNavItem : AraNavGraphItems(
        labelTextId = R.string.machines_title,
        selectedIconId = R.drawable.machines_filled,
        unselectedIconId = R.drawable.machines_outlined,
        description = "",
        navGraphDestination = MachinesNavGraphDestination
    )

    data object InventoryNavItem : AraNavGraphItems(
        labelTextId = R.string.inventory_title,
        selectedIconId = R.drawable.inventory_filled,
        unselectedIconId = R.drawable.inventory_outlined,
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