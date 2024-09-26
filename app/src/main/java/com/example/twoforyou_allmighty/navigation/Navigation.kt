package com.example.twoforyou_allmighty.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.twoforyou_allmighty.feature_record.presentation.add_record.AddRecordScreen
import com.example.twoforyou_allmighty.feature_record.presentation.record.RecordScreen
import com.example.twoforyou_allmighty.feature_record.presentation.record_detail.RecordDetailScreen
import com.example.twoforyou_allmighty.feature_record.presentation.screen.Screen

@Composable
fun Navigation(
    navController: NavHostController
) {

    NavHost(
        navController = navController,
        startDestination = Screen.RecordScreen.route
    ) {
        composable(route = Screen.RecordScreen.route) {
            RecordScreen(navController = navController)
        }

        composable(route = Screen.AddRecordScreen.route) {
            AddRecordScreen(navController = navController)
        }

        composable(route = "${Screen.RecordDetailScreen.route}/{recordKey}",
            arguments = listOf(
                navArgument("recordKey") {
                    type = NavType.IntType
                }
            )
        ) {entry ->
            val recordKey = entry.arguments?.getInt("recordKey")!!
            RecordDetailScreen(
                navController = navController,
                recordKey = recordKey,
            )
        }

    }
}