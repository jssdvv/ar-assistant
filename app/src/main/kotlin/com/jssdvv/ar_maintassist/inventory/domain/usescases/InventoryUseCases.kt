package com.jssdvv.ar_maintassist.inventory.domain.usescases

data class InventoryUseCases(
    val getInventoryItems: GetInventoryItems,
    val deleteInventoryItem: DeleteInventoryItem,
    val addInventoryItem: AddInventoryItem
)