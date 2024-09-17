package com.example.twoforyou_allmighty.feature_record.presentation.record

import android.content.Context
import androidx.activity.compose.setContent
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.test.core.app.ApplicationProvider
import com.example.twoforyou_allmighty.R
import com.example.twoforyou_allmighty.di.AppModule
import com.example.twoforyou_allmighty.feature_record.presentation.add_record.AddRecordScreen
import com.example.twoforyou_allmighty.feature_record.presentation.screen.Screen
import com.example.twoforyou_allmighty.test.TestTag
import com.example.twoforyou_allmighty.ui.MainActivity
import com.example.twoforyou_allmighty.ui.theme.Twoforyou_AllMightyTheme
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import com.google.common.truth.Truth

@HiltAndroidTest
@UninstallModules(AppModule::class)
class RecordScreenTest {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeRule = createAndroidComposeRule<MainActivity>()

    private lateinit var navController: NavHostController

    @Before
    fun setUp() {
        hiltRule.inject()
        composeRule.activity.setContent {
            navController = rememberNavController()

            Twoforyou_AllMightyTheme {
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
                }
            }
        }

    }

    @Test
    fun clickAddRecordButton_opensAddRecordScreen() {
        val context = ApplicationProvider.getApplicationContext<Context>()

        composeRule
            .onNodeWithTag(TestTag.ADD_NOTES_ICON_BUTTON, useUnmergedTree = true)
            .assertExists()
        composeRule.onNodeWithContentDescription(context.getString(R.string.add_note)).performClick()
        composeRule
            .onNodeWithTag(TestTag.ADD_NOTES_ICON_BUTTON, useUnmergedTree = true)
            .assertDoesNotExist()

        val route = navController.currentBackStackEntry?.destination?.route
        Truth.assertThat(route).isEqualTo(Screen.AddRecordScreen.route)



    }

}