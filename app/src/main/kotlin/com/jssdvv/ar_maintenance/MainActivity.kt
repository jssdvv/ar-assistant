package com.jssdvv.ar_maintenance

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.jssdvv.ar_maintenance.home.presentation.screens.MainScreen
import com.jssdvv.ar_maintenance.ui.theme.Ar_maintenanceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Ar_maintenanceTheme {
                // A surface container using the 'background' color from the theme

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val myCustomText = "Hola mundo 2"

                    MainScreen(
                        myText = myCustomText
                    )
                    //resto del codigo
                }
            }
        }
    }
}