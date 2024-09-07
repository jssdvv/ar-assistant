package com.jssdvv.ar_maintassist.machines.presentation.machines_list

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.jssdvv.ar_maintassist.R
import com.jssdvv.ar_maintassist.machines.presentation.machines_list.components.MachineCard
import com.jssdvv.ar_maintassist.machines.presentation.machines_list.components.MachinesListOrderSection

@Composable
fun MachinesListScreen(
    navHostController: NavHostController,
    viewModel: MachinesListViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsState()
    var selectedChip by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            FilterChip(
                selected = selectedChip,
                onClick = { selectedChip = !selectedChip },
                label = {
                    Text(text = stringResource(R.string.categories_chip_all_options_label))
                },
                leadingIcon = {
                    Icon(
                        painter = painterResource(
                            if (selectedChip) {
                                R.drawable.manufacturing_filled
                            } else {
                                R.drawable.manufacturing_outlined
                            }
                        ),
                        contentDescription = stringResource(R.string.categories_chip_leading_icon_content_description),
                        modifier = Modifier.size(AssistChipDefaults.IconSize)
                    )
                },
                trailingIcon = {
                    Icon(
                        imageVector = if (selectedChip) {
                            Icons.Default.KeyboardArrowUp
                        } else {
                            Icons.Default.KeyboardArrowDown
                        },
                        contentDescription = stringResource(R.string.categories_chip_trailing_icon_content_description),
                        modifier = Modifier.size(AssistChipDefaults.IconSize)
                    )
                }
            )
            IconButton(
                onClick = {
                    viewModel.onEvent(MachinesListEvent.ToggleOrderSectionVisibility)
                }
            ) {
                Icon(
                    painter = painterResource(R.drawable.filter_outlined),
                    contentDescription = stringResource(R.string.icon_filter_button_content_description)
                )
            }
        }
        AnimatedVisibility(
            visible = state.value.isOrderSectionVisible,
            enter = fadeIn() + slideInVertically(),
            exit = fadeOut() + slideOutVertically()
        ) {
            MachinesListOrderSection(
                modifier = Modifier.fillMaxWidth(),
                orderKey = state.value.machineOrderKey,
                onOrderKeyChange = { orderKey ->
                    viewModel.onEvent(MachinesListEvent.OrderMachines(orderKey))
                },
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(state.value.machines) { machineEntity ->
                MachineCard(
                    modifier = Modifier.fillMaxWidth(),
                    navHostController = navHostController,
                    machineEntity = machineEntity,
                    onNavigateToMachineData = {}
                )
            }
        }
    }
}