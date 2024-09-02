package com.jssdvv.ar_maintassist.resources.presentation.screens

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.jssdvv.ar_maintassist.core.presentation.navigation.graphs.MachineDataDestination
import com.jssdvv.ar_maintassist.resources.presentation.components.MachineCard

@Composable
fun MachinesListScreen(
    navHostController: NavHostController
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            MachineCard(
                navHostController = navHostController
            ) {
                navHostController.navigate(
                    MachineDataDestination
                )
            }
            Spacer(modifier = Modifier.padding(8.dp))
            MachineCard(
                navHostController = navHostController
            ) {
            }
        }
    }
}