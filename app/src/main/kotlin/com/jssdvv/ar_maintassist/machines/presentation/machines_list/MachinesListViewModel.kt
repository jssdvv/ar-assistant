package com.jssdvv.ar_maintassist.machines.presentation.machines_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jssdvv.ar_maintassist.machines.domain.models.MachineEntity
import com.jssdvv.ar_maintassist.machines.domain.usecases.MachineUseCases
import com.jssdvv.ar_maintassist.machines.domain.utils.MachineOrderKey
import com.jssdvv.ar_maintassist.core.domain.utils.OrderType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MachinesListViewModel @Inject constructor(
    private val useCases: MachineUseCases
) : ViewModel() {

    private val _state = MutableStateFlow(MachinesListState())
    val state = _state.asStateFlow()

    private var _lastDeletedMachine: MachineEntity? = null

    private var _getMachinesJob: Job? = null

    init {
        getMachines(MachineOrderKey.Timestamp(OrderType.ASCENDING))
    }

    fun onEvent(event: MachinesListEvent) {
        when (event) {
            is MachinesListEvent.OrderMachines -> {
                if (state.value.machineOrderKey::class == event.orderKey::class &&
                    state.value.machineOrderKey.orderType == event.orderKey.orderType
                ) {
                    return
                }
            }

            is MachinesListEvent.DeleteMachine -> {
                viewModelScope.launch {
                    useCases.deleteMachine(event.entity)
                    _lastDeletedMachine = event.entity
                }
            }

            is MachinesListEvent.RestoreMachine -> {
                viewModelScope.launch {
                    useCases.insertMachine(_lastDeletedMachine ?: return@launch)
                    _lastDeletedMachine = null
                }
            }

            is MachinesListEvent.ToggleOrderSectionVisibility -> {
                _state.value = state.value.copy(
                    isOrderSectionVisible = !state.value.isOrderSectionVisible
                )
            }
        }
    }

    private fun getMachines(machineOrderKey: MachineOrderKey) {
        _getMachinesJob?.cancel()
        _getMachinesJob = useCases.getMachines(machineOrderKey).onEach { machines ->
            _state.value = state.value.copy(
                machines = machines,
                machineOrderKey = machineOrderKey
            )
        }.launchIn(viewModelScope)
    }
}