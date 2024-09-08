package com.jssdvv.ar_maintassist.core.presentation.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.jssdvv.ar_maintassist.inventory.presentation.item_add.ItemAddScreen
import com.jssdvv.ar_maintassist.inventory.presentation.item_details.ItemDetailsScreen
import com.jssdvv.ar_maintassist.inventory.presentation.item_edit.ItemEditScreen
import com.jssdvv.ar_maintassist.inventory.presentation.items_list.ItemsListScreen
import kotlinx.serialization.Serializable

@Serializable object InventoryNavGraph
@Serializable object ItemsListDestination
@Serializable object ItemAddDestination
@Serializable object ItemEditDestination
@Serializable object ItemDetailsDestination

fun NavGraphBuilder.inventoryNavGraph(navHostController: NavHostController) {
    navigation<InventoryNavGraph>(startDestination = ItemsListDestination) {
        composable<ItemsListDestination> {
            ItemsListScreen(navHostController = navHostController)
        }
        composable<ItemAddDestination> {
            ItemAddScreen(navHostController = navHostController)
        }
        composable<ItemEditDestination> {
            ItemEditScreen(navHostController = navHostController)
        }
        composable<ItemDetailsDestination> {
            ItemDetailsScreen(navHostController = navHostController)
        }
    }
}