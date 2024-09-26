package com.example.twoforyou_allmighty.feature_record.presentation.add_record

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.twoforyou_allmighty.R
import com.example.twoforyou_allmighty.feature_record.presentation.add_record.component.PlayerNameTextField
import com.example.twoforyou_allmighty.feature_record.presentation.add_record.component.RecordTitleTextField
import com.example.twoforyou_allmighty.test.TestTag.RECORD_SAVE_BUTTON

@Composable
fun AddRecordScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: AddRecordViewModel = hiltViewModel()
) {
    val playerListState = viewModel.playerListState
    val titleState = viewModel.titleState
    val context = LocalContext.current

    Scaffold { paddingValues ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {

            RecordTitleTextField(
                modifier = Modifier
                    .semantics {
                        this.contentDescription = context.getString(R.string.record_title)
                    },
                titleText = titleState.value.title,
                onValueChange = { title -> viewModel.onEvent(AddRecordEvent.ChangedRecordTitle(title)) },
                labelText = "제목을 입력하세요."
            )

            LazyColumn {
                items(playerListState.size) { index ->
                    PlayerNameTextField(
                        modifier = Modifier
                            .semantics {
                                this.contentDescription = context.getString(R.string.player_name, index.plus(1))
                            },
                        nameText = playerListState.toList()[index].name,
                        onValueChange = { name -> viewModel.onEvent(AddRecordEvent.ChangedPlayerName(index, name)) },
                        labelText = "플레이어${index.plus(1)} 이름을 입력하세요."
                    )
                }
            }

            Button(
                onClick = {
                    viewModel.onEvent(AddRecordEvent.SaveRecord)
                    navController.popBackStack()
                },
                modifier = Modifier
                    .testTag(RECORD_SAVE_BUTTON)
            ) {
                Text(text = "저장")
            }

        }
    }
}