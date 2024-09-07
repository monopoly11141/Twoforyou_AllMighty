package com.example.twoforyou_allmighty.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.twoforyou_allmighty.navigation.Navigation
import com.example.twoforyou_allmighty.feature_record.presentation.theme.Twoforyou_AllMightyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Twoforyou_AllMightyTheme {
                val navController = rememberNavController()
                Navigation(navController)
            }
        }
    }
}