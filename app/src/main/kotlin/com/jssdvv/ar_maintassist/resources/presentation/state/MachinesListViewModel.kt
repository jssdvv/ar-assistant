package com.jssdvv.ar_maintassist.resources.presentation.state

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jssdvv.ar_maintassist.resources.domain.models.MachineEntity
import com.jssdvv.ar_maintassist.resources.domain.usecases.MachineUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MachinesListViewModel @Inject constructor(
    private val useCases: MachineUseCases
) : ViewModel() {

    private val _state = MutableStateFlow(MachinesListState())
    val state = _state.asStateFlow()

    private val _lastDeletedMachine = MutableStateFlow<MachineEntity?>(null)

    fun onEvent(event: MachinesListEvent) {
        when(event) {
            is MachinesListEvent.Order -> {}
            is MachinesListEvent.DeleteMachine -> {
                viewModelScope.launch {
                    useCases.deleteMachine(event.machineEntity)
                    _lastDeletedMachine.value = event.machineEntity
                }
            }
            is MachinesListEvent.RestoreMachine -> {}
            is MachinesListEvent.ToggleOrderSection -> {
                _state.value = state.value.copy(
                    isOrderSectionVisible = !state.value.isOrderSectionVisible
                )
            }
        }
    }
}