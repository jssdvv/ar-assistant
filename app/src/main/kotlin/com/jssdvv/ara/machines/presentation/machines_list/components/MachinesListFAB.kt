package com.jssdvv.ara.machines.presentation.machines_list.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun MachinesListFAB(
    onNavigateToAddMachine: () -> Unit
) {
    ExtendedFloatingActionButton(
        text = { Text(text = "Nueva máquina") },
        icon = {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = null
            )
        },
        onClick = onNavigateToAddMachine
    )
}