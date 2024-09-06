package com.jssdvv.ar_maintassist.inventory.domain.usescases

data class InventoryItemUseCases(
    val getInventoryItems: GetInventoryItems,
    val insertInventoryItem: InsertInventoryItem,
    val updateInventoryItem: UpdateInventoryItem,
    val deleteInventoryItem: DeleteInventoryItem
)