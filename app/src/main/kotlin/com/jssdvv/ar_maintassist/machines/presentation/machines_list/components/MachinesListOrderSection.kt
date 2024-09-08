package com.jssdvv.ar_maintassist.machines.presentation.machines_list.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.jssdvv.ar_maintassist.R
import com.jssdvv.ar_maintassist.core.domain.utils.OrderType
import com.jssdvv.ar_maintassist.machines.domain.utils.MachineOrderKey

@Composable
fun MachinesListOrderSection(
    modifier: Modifier,
    orderKey: MachineOrderKey,
    onOrderKeyChange: (MachineOrderKey) -> Unit,
) {
    val orderKeys = listOf(
        MachineOrderKey.Name(orderKey.orderType),
        MachineOrderKey.Timestamp(orderKey.orderType)
    )
    val orderTypes = listOf(
        Pair(OrderType.ASCENDING, stringResource(R.string.order_type_ascending_name)),
        Pair(OrderType.DESCENDING,stringResource(R.string.order_type_descending_name))
    )
    LazyColumn(
        modifier = modifier
    ) {
        item {
            LazyRow {
                items(orderKeys) {
                    FilterChip(
                        selected = it.orderKeyName == orderKey.orderKeyName,
                        onClick = { onOrderKeyChange(it) },
                        label = {
                            Text(stringResource(it.orderKeyName))
                        }
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                }
            }
        }
        item {
            LazyRow {
                items(orderTypes) { orderType ->
                    FilterChip(
                        selected = orderType.first == orderKey.orderType,
                        onClick = { onOrderKeyChange(orderKey.copy(orderType.first)) },
                        label = {
                            Text(orderType.second)
                        }
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                }
            }
        }
    }
}