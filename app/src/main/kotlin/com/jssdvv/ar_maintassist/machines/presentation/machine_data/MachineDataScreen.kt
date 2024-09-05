package com.jssdvv.ar_maintassist.machines.presentation.machine_data

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.jssdvv.ar_maintassist.R
import com.jssdvv.ar_maintassist.machines.presentation.machine_data.components.MaintenanceCard

@Composable
fun MachineDataScreen(
    modifier: Modifier = Modifier,
    navHostController: NavHostController
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            DataScreenTopBar {
                navHostController.popBackStack()
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
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


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DataScreenTopBar(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit
) {
    TopAppBar(
        title = {
            Text(
                text = "Actividades",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )
        },
        navigationIcon = {
            IconButton(
                onClick = onBackClick
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = ""
                )
            }
        }
    )
}