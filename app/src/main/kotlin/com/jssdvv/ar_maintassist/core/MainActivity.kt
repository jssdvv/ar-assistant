package com.jssdvv.ar_maintassist.core

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import com.jssdvv.ar_maintassist.core.presentation.navigation.NavHost
import com.jssdvv.ar_maintassist.core.presentation.theme.Theme

class MainActivity : ComponentActivity() {

    @SuppressLint("UnrememberedMutableState")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Theme {
                Surface {
                    NavHost()
                }
            }
        }
    }
}