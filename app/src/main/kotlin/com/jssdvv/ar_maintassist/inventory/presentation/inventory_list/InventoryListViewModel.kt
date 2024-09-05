package com.jssdvv.ar_maintassist.inventory.presentation.inventory_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jssdvv.ar_maintassist.core.domain.utils.OrderType
import com.jssdvv.ar_maintassist.inventory.domain.models.InventoryEntity
import com.jssdvv.ar_maintassist.inventory.domain.usescases.InventoryUseCases
import com.jssdvv.ar_maintassist.inventory.domain.utils.InventoryOrder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class InventoryListViewModel @Inject constructor(
    private val useCases: InventoryUseCases
) : ViewModel() {

    private val _state = MutableStateFlow(InventoryListState())
    val state = _state.asStateFlow()

    private var _lastDeletedItem: InventoryEntity? = null

    private var _getInventoryJob: Job? = null

    init {
        getInventoryItems(InventoryOrder.Timestamp(OrderType.ASCENDING))
    }

    fun onEvent(event: InventoryListEvent) {
        when (event) {
            is InventoryListEvent.Order -> {
                if (state.value.inventoryOrder::class == event.inventoryOrder::class &&
                    state.value.inventoryOrder.orderType == event.inventoryOrder.orderType
                ) {
                    return
                }
            }

            is InventoryListEvent.DeleteItem -> {
                viewModelScope.launch {
                    useCases.deleteInventoryItem(event.inventoryEntity)
                    _lastDeletedItem = event.inventoryEntity
                }
            }

            is InventoryListEvent.RestoreItem -> {
                viewModelScope.launch {
                    useCases.addInventoryItem(_lastDeletedItem ?: return@launch)
                    _lastDeletedItem = null
                }
            }

            is InventoryListEvent.ToggleOrderSectionVisibility -> {
                _state.value = state.value.copy(
                    isOrderSectionVisible = !state.value.isOrderSectionVisible
                )
            }

            is InventoryListEvent.AddItem -> {
                viewModelScope.launch {
                    useCases.addInventoryItem(event.inventoryEntity)
                }
            }
        }
    }

    private fun getInventoryItems(inventoryOrder: InventoryOrder) {
        _getInventoryJob?.cancel()
        _getInventoryJob = useCases.getInventoryItems(inventoryOrder).onEach { inventoryItems ->
            _state.value = state.value.copy(
                inventoryItems = inventoryItems,
                inventoryOrder = inventoryOrder
            )
        }.launchIn(viewModelScope)
    }
}