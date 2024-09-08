package com.jssdvv.ar_maintassist.machines.presentation.activities_list

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.jssdvv.ar_maintassist.machines.presentation.activities_list.components.ActivityCard

@Composable
fun ActivitiesListScreen(
    navHostController: NavHostController,
    machineId: Int,
    viewModel: ActivitiesListViewModel = hiltViewModel()
) {


    val state = viewModel.state.collectAsState()
    LaunchedEffect(true) {
        viewModel.onEvent(
            ActivitiesListEvent.GetMachineId(machineId)
        )
    }
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
            items(state.value.activities) { activity ->
                ActivityCard(
                    modifier = Modifier.fillParentMaxWidth(),
                    navHostController = navHostController,
                    entity = activity
                )
                Spacer(modifier = Modifier.height(16.dp))
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