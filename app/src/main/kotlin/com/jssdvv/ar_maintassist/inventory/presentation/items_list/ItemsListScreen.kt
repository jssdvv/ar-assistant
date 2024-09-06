package com.jssdvv.ar_maintassist.inventory.presentation.items_list

import android.net.Uri
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.jssdvv.ar_maintassist.inventory.domain.models.InventoryItemEntity
import com.jssdvv.ar_maintassist.inventory.presentation.items_list.components.InventoryItemCard
import java.io.File

@Composable
fun ItemsListScreen(
    navHostController: NavHostController,
    viewModel : ItemsListViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    val imagePath = "/storage/emulated/0/Download/2b4sn0.jpg"
    val imageFile = File(imagePath)
    val uriExample = Uri.fromFile(imageFile)

    Scaffold(
        floatingActionButton = {
            InventoryListFAB {
                viewModel.onEvent(
                    ItemsListEvent.InsertItem(
                        InventoryItemEntity(
                            id = 0,
                            name = "Aceite 20w50",
                            description = "",
                            imageUri = uriExample,
                            brand = null,
                            suppliers = null,
                            quantity = 0f,
                            storageUnit = "L",
                            unitCost = 20000f,
                            timestamp = 6340L
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
                    inventoryItemEntity = item
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