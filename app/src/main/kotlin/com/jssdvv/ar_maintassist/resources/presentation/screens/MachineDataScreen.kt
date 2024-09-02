package com.jssdvv.ar_maintassist.resources.presentation.screens

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.jssdvv.ar_maintassist.R
import com.jssdvv.ar_maintassist.resources.presentation.components.MaintenanceCard

@Composable
fun MachineDataScreen(
    modifier: Modifier = Modifier,
    navHostController: NavHostController
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            MaintenanceCard(
                navHostController = navHostController,
                imgId = R.drawable.cabezal,
                title = "mantenimiento del cabezal",
                description = "Guía sobre como armar y desarmar el cabezal del compresor, así mismo de comprobar sus componentes y reemplazar partes"
            )
            Spacer(modifier = Modifier.padding(8.dp))
            MaintenanceCard(
                navHostController = navHostController,
                imgId = R.drawable.poleas,
                title = "Mantenimiento de poleas",
                description = "Guía sobre como armar y desarmar las poleas del compresor, así mismo de comprobar sus componentes y reemplazar partes"
            )
        }
    }

}