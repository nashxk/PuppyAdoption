package com.example.androiddevchallenge.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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