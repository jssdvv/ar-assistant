package com.jssdvv.ar_maintassist.inventory.presentation.items_list

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

@Composable
fun ItemsListScreen(
    navHostController: NavHostController,
    viewModel: ItemsListViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()


}

@Composable
fun InventoryListFAB(
    modifier: Modifier = Modifier,
    addInventoryItem: () -> Unit
) {
    FloatingActionButton(
        onClick = {
            addInventoryItem()
        }
    ) {
        Icon(imageVector = Icons.Default.Add, contentDescription = "Add inventory item")
    }
}