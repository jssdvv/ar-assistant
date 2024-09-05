package com.jssdvv.ar_maintassist.inventory.presentation.inventory_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.jssdvv.ar_maintassist.inventory.domain.models.InventoryEntity

@Composable
fun InventoryListScreen(
    navHostController: NavHostController,
    viewModel : InventoryListViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    Scaffold(
        floatingActionButton = {
            InventoryListFAB {
                viewModel.onEvent(
                    InventoryListEvent.AddItem(
                        InventoryEntity(
                            code = null,
                            name = "Aceite 20w50",
                            description = null,
                            brand = null,
                            suppliers = null,
                            initialQuantity = null,
                            storageUnit = "L",
                            unitCost = 20000f,
                            timestamp = 6347
                        )
                    )
                )
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            items(state.inventoryItems) { item ->
                InventoryItemCard(
                    modifier = Modifier.fillMaxWidth(),
                    item = item
                )
            }
        }
    }
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

@Composable
fun InventoryItemCard(
    modifier: Modifier = Modifier,
    item: InventoryEntity
) {
    Card(
        modifier = modifier
    ) {
        Text("Hola")
    }
    Spacer(modifier = Modifier.padding(16.dp))
}