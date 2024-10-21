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
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.twoforyou_allmighty.R

@Composable
fun NumberCounterGroup(modifier: Modifier = Modifier) {
    val number = remember { mutableStateListOf(0, 0, 0, 0, 0) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        for (i in 0..4) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                IconButton(onClick = { number[i]++ }) {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = "더하기"
                    )
                }

                Text("${number[i]}")

                IconButton(onClick = { if (number[i] > 0) number[i]-- }) {
                    Icon(
                        painter = painterResource(R.drawable.minus),
                        contentDescription = "빼기"
                    )
                }
            }
        }

    }

}