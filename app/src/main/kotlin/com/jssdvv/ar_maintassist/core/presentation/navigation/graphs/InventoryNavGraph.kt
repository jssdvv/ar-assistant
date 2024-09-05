package com.jssdvv.ar_maintassist.core.presentation.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.jssdvv.ar_maintassist.inventory.presentation.inventory_list.InventoryListScreen
import kotlinx.serialization.Serializable

@Serializable object InventoryNavGraph
@Serializable object InventoryListDestination

fun NavGraphBuilder.inventoryNavGraph(navHostController: NavHostController) {
    navigation<InventoryNavGraph>(startDestination = InventoryListDestination) {
        composable<InventoryListDestination> {
            InventoryListScreen(navHostController = navHostController)
        }
    }
}