package com.example.twoforyou_allmighty.feature_record.presentation.add_record.component

import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun PlayerNameTextField(
    modifier: Modifier = Modifier,
    nameText: String,
    onValueChange: (String) -> Unit,
    labelText: String
) {
    TextField(
        value = nameText,
        onValueChange = { name -> onValueChange(name) },
        modifier = modifier,
        label = {
            Text(
                text = labelText
            )
        }
    )
}