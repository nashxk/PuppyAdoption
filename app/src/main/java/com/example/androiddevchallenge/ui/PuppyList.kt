package com.example.androiddevchallenge.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.PuppyInfo

@Composable
fun PuppyList(puppyList: List<PuppyInfo>, onClick: (PuppyInfo) -> Unit = {}) {
    LazyColumn(
        Modifier.background(MaterialTheme.colors.secondary),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(puppyList) { puppyInfo ->
            PuppyItem(puppyInfo = puppyInfo,
                Modifier
                    .clickable {
                        onClick(puppyInfo)
                    }
                    .fillMaxWidth())
        }
    }
}

@Composable
fun PuppyItem(puppyInfo: PuppyInfo, modifier: Modifier = Modifier) {
    Card(modifier) {
        Row {
            Image(
                painterResource(id = puppyInfo.avatar),
                "${puppyInfo.name}'s picture",
                Modifier.size(120.dp),
                contentScale = ContentScale.Crop
            )
            Column(Modifier.padding(8.dp)) {
                Text(text = puppyInfo.name, style = MaterialTheme.typography.h4)
                Text(text = puppyInfo.gender)
                Text(text = puppyInfo.address)
            }
        }
    }
}