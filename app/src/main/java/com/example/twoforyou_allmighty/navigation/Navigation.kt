package com.example.twoforyou_allmighty.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.twoforyou_allmighty.feature_record.presentation.Screen
import com.example.twoforyou_allmighty.ui.mighty_record.MightyRecordScreen
import com.example.twoforyou_allmighty.ui.record_detail.RecordDetailScreen

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