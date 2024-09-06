package com.jssdvv.ar_maintassist.inventory.presentation.items_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jssdvv.ar_maintassist.core.domain.utils.OrderType
import com.jssdvv.ar_maintassist.inventory.domain.models.InventoryItemEntity
import com.jssdvv.ar_maintassist.inventory.domain.usescases.InventoryItemUseCases
import com.jssdvv.ar_maintassist.inventory.domain.utils.InventoryItemOrderKey
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ItemsListViewModel @Inject constructor(
    private val useCases: InventoryItemUseCases
) : ViewModel() {

    private val _state = MutableStateFlow(ItemsListState())
    val state = _state.asStateFlow()

    private var _lastDeletedItem: InventoryItemEntity? = null

    private var _getInventoryJob: Job? = null

    init {
        getInventoryItems(InventoryItemOrderKey.Timestamp(OrderType.ASCENDING))
    }

    fun onEvent(event: ItemsListEvent) {
        when (event) {
            is ItemsListEvent.OrderItems -> {
                if (state.value.inventoryItemOrderKey::class == event.orderKey::class &&
                    state.value.inventoryItemOrderKey.orderType == event.orderKey.orderType
                ) {
                    return
                }
            }

            is ItemsListEvent.DeleteItem -> {
                viewModelScope.launch {
                    useCases.deleteInventoryItem(event.entity)
                    _lastDeletedItem = event.entity
                }
            }

            is ItemsListEvent.RestoreItem -> {
                viewModelScope.launch {
                    useCases.insertInventoryItem(_lastDeletedItem ?: return@launch)
                    _lastDeletedItem = null
                }
            }

            is ItemsListEvent.ToggleOrderSectionVisibility -> {
                _state.value = state.value.copy(
                    isOrderSectionVisible = !state.value.isOrderSectionVisible
                )
            }

            is ItemsListEvent.InsertItem -> {
                viewModelScope.launch {
                    useCases.insertInventoryItem(event.entity)
                }
            }
        }
    }

    private fun getInventoryItems(inventoryItemOrderKey: InventoryItemOrderKey) {
        _getInventoryJob?.cancel()
        _getInventoryJob = useCases.getInventoryItems(inventoryItemOrderKey).onEach { inventoryItems ->
            _state.value = state.value.copy(
                inventoryItems = inventoryItems,
                inventoryItemOrderKey = inventoryItemOrderKey
            )
        }.launchIn(viewModelScope)
    }
}