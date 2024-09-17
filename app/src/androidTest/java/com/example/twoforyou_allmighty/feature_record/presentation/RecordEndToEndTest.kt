package com.example.twoforyou_allmighty.feature_record.presentation

import android.content.Context
import androidx.activity.compose.setContent
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.test.core.app.ApplicationProvider
import com.example.twoforyou_allmighty.R
import com.example.twoforyou_allmighty.di.AppModule
import com.example.twoforyou_allmighty.feature_record.presentation.add_record.AddRecordScreen
import com.example.twoforyou_allmighty.feature_record.presentation.record.RecordScreen
import com.example.twoforyou_allmighty.feature_record.presentation.screen.Screen
import com.example.twoforyou_allmighty.test.TestTag
import com.example.twoforyou_allmighty.test.TestTag.RECORD_SAVE_BUTTON
import com.example.twoforyou_allmighty.ui.MainActivity
import com.example.twoforyou_allmighty.ui.theme.Twoforyou_AllMightyTheme
import com.google.common.truth.Truth
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
@UninstallModules(AppModule::class)
class RecordEndToEndTest {
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
    fun saveNewRecord_addedNewNote() {
        val context = ApplicationProvider.getApplicationContext<Context>()

        composeRule
            .onNodeWithTag(TestTag.ADD_NOTES_ICON_BUTTON, useUnmergedTree = true)
            .performClick()

        for (i in 1..5) {
            val playerText = "player $i"
            composeRule
                .onNodeWithContentDescription(context.getString(R.string.player_name, i), useUnmergedTree = true)
                .performTextInput(playerText)

            composeRule
                .onNodeWithContentDescription(context.getString(R.string.player_name, i), useUnmergedTree = true)
                .assertTextEquals(playerText)
        }

        val titleText = "Record for Testing"
        composeRule
            .onNodeWithContentDescription(context.getString(R.string.record_title), useUnmergedTree = true)
            .performTextInput(titleText)

        composeRule
            .onNodeWithContentDescription(context.getString(R.string.record_title), useUnmergedTree = true)
            .assertTextEquals(titleText)

        composeRule
            .onNodeWithTag(RECORD_SAVE_BUTTON, useUnmergedTree = true)
            .performClick()

        val route = navController.currentBackStackEntry?.destination?.route
        Truth.assertThat(route).isEqualTo(Screen.RecordScreen.route)

        composeRule
            .onNodeWithTag(TestTag.RECORD_LIST, useUnmergedTree = true)
            .assertTextEquals(titleText)
    }

}