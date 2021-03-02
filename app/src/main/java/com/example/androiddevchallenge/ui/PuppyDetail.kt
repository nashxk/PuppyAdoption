package com.example.androiddevchallenge.ui

import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ProvideTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.PuppyInfo

@Composable
fun PuppyDetail(puppyInfo: PuppyInfo, onAdopt: (PuppyInfo) -> Unit = {}) {

    Column(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.secondary)
    ) {
        Image(
            painterResource(id = puppyInfo.avatar),
            "${puppyInfo.name}'s picture",
            Modifier.aspectRatio(1f),
            contentScale = ContentScale.Crop
        )
        Column(
            Modifier
                .padding(16.dp, 8.dp)
                .weight(1f)
                .verticalScroll(rememberScrollState(0))
                ) {
            Text(text = "Name: ${puppyInfo.name}", fontStyle = FontStyle.Italic)
            Text(text = "Gender: ${puppyInfo.gender}")
            Text(text = "Address: ${puppyInfo.address}")
            Text(text = "Age: ${puppyInfo.age} years old")
            Text(text = "Description: ${puppyInfo.desc}")
        }
        Button(
            { onAdopt(puppyInfo) },
            Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = "This is the one!")
        }
    }
}