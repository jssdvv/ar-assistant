package com.jssdvv.ar_maintassist.core.presentation.navigation.components

import com.jssdvv.ar_maintassist.R
import com.jssdvv.ar_maintassist.core.presentation.navigation.graphs.AgendaNavGraph
import com.jssdvv.ar_maintassist.core.presentation.navigation.graphs.CameraNavGraph
import com.jssdvv.ar_maintassist.core.presentation.navigation.graphs.HomeNavGraph
import com.jssdvv.ar_maintassist.core.presentation.navigation.graphs.MachinesNavGraph

sealed class NavItems(
    val title: Int,
    val route: Any,
    val selectedIcon: Int,
    val unselectedIcon: Int,
    val description: String
) {
    data object HomeItem : NavItems(
        title = R.string.home_title,
        route = HomeNavGraph,
        selectedIcon = R.drawable.home_filled,
        unselectedIcon = R.drawable.home_outlined,
        description = ""
    )

    data object CamItem : NavItems(
        title = R.string.camera_title,
        route = CameraNavGraph,
        selectedIcon = R.drawable.ar_filled,
        unselectedIcon = R.drawable.ar_outlined,
        description = ""
    )

    data object DocsItem : NavItems(
        title = R.string.resources_title,
        route = MachinesNavGraph,
        selectedIcon = R.drawable.docs_filled,
        unselectedIcon = R.drawable.docs_outlined,
        description = ""
    )

    data object CalendarItem : NavItems(
        title = R.string.agenda_title,
        route = AgendaNavGraph,
        selectedIcon = R.drawable.calendar_filled,
        unselectedIcon = R.drawable.calendar_outlined,
        description = ""
    )
}