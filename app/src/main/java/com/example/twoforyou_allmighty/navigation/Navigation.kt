package com.example.twoforyou_allmighty.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.twoforyou_allmighty.ui.mighty_record.MightyRecordScreen

@Composable
fun Navigation(
    navController: NavHostController
) {

    NavHost(
        navController = navController,
        startDestination = Screen.MightyRecordScreen.route
    ) {
        composable(route = Screen.MightyRecordScreen.route) {
            MightyRecordScreen(navController = navController)
        }
    }
}