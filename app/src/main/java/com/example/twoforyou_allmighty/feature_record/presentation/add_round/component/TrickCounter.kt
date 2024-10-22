package com.example.twoforyou_allmighty.feature_record.presentation.add_round.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.twoforyou_allmighty.R

@Composable
fun TrickCounter(
    modifier: Modifier = Modifier,
    text : String,
    trickNumber: Int,
    onPlusClick: () -> Unit,
    onMinusClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = text
        )
        
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            IconButton(onClick = { onPlusClick() }) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "더하기"
                )
            }

            Text("${trickNumber}")

            IconButton(onClick = { onMinusClick() }) {
                Icon(
                    painter = painterResource(R.drawable.minus),
                    contentDescription = "빼기"
                )
            }
        }


    }

}