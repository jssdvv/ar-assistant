package com.jssdvv.ar_maintassist.core.presentation.navigation

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController

@Composable
fun NavScaffold(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { NavBar(navController = navController) }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            paddingValues = paddingValues
        )
    }
}