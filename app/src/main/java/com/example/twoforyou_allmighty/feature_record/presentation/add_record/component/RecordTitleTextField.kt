package com.example.twoforyou_allmighty.feature_record.presentation.add_record.component

import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun RecordTitleTextField(
    modifier: Modifier = Modifier,
    titleText: String,
    onValueChange: (String) -> Unit,
    labelText: String
) {
    TextField(
        value = titleText,
        onValueChange = { title -> onValueChange(title) },
        modifier = modifier,
        label = {
            Text(
                text = labelText
            )
        }
    )
}