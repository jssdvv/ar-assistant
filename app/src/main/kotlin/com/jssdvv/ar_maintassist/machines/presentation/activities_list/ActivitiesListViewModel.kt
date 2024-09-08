package com.jssdvv.ar_maintassist.machines.presentation.activities_list

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jssdvv.ar_maintassist.machines.domain.usecases.ActivityUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ActivitiesListViewModel @Inject constructor(
    private val useCases: ActivityUseCases
) : ViewModel() {
    private val _state = MutableStateFlow(ActivitiesListState())
    val state = _state.asStateFlow()

    private var _getActivitiesJob: Job? = null

    init {
        _state.value.machineId?.let { getActivities(it) }
    }

    fun onEvent(event: ActivitiesListEvent) {
        when (event) {
            is ActivitiesListEvent.GetMachineId -> {
                if (state.value.machineId != event.machineId) {
                    _state.value = state.value.copy(
                        machineId = event.machineId
                    )
                }
                getActivities(event.machineId)
            }

            else -> {}
        }
    }

    private fun getActivities(machineId: Int) {
        _getActivitiesJob?.cancel()
        _getActivitiesJob = useCases.getActivities(machineId).onEach { activities ->
            _state.value = state.value.copy(
                activities = activities,
                machineId = machineId
            )
        }.launchIn(viewModelScope)
    }
}