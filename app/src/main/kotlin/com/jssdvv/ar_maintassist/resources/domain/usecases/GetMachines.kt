package com.jssdvv.ar_maintassist.resources.domain.usecases

import com.jssdvv.ar_maintassist.resources.domain.models.MachineEntity
import com.jssdvv.ar_maintassist.resources.domain.repository.MachineRepository
import com.jssdvv.ar_maintassist.resources.domain.util.MachineOrder
import com.jssdvv.ar_maintassist.resources.domain.util.OrderType
import kotlinx.coroutines.flow.Flow

class GetMachines(
    private val repository: MachineRepository
) {
    operator fun invoke(
        machineOrder: MachineOrder = MachineOrder.Name(OrderType.ASCENDING),
    ): Flow<List<MachineEntity>> {
        return when (machineOrder.orderType) {
            OrderType.ASCENDING -> when (machineOrder) {
                is MachineOrder.Name -> repository.getAllMachinesByNameAsc()
                is MachineOrder.Category -> repository.getAllMachinesByCategoryAsc()
                is MachineOrder.Timestamp -> repository.getAllMachinesByTimestampAsc()
            }

            OrderType.DESCENDING -> when (machineOrder) {
                is MachineOrder.Name -> repository.getAllMachinesByNameDesc()
                is MachineOrder.Category -> repository.getAllMachinesByCategoryDesc()
                is MachineOrder.Timestamp -> repository.getAllMachinesByTimestampDesc()
            }
        }
    }
}