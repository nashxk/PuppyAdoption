/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.PuppyInfo

@Composable
fun PuppyList(puppyList: List<PuppyInfo>, onClick: (PuppyInfo) -> Unit = {}) {
    LazyColumn(
        Modifier.background(MaterialTheme.colors.background),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(puppyList) { puppyInfo ->
            PuppyItem(
                puppyInfo = puppyInfo,
                Modifier
                    .clickable {
                        onClick(puppyInfo)
                    }
                    .fillMaxWidth()
            )
        }
    }
}

@Composable
fun PuppyItem(puppyInfo: PuppyInfo, modifier: Modifier = Modifier) {
    Card(
        modifier
            .border(
                color = Color.LightGray,
                width = 1.dp,
                shape = RoundedCornerShape(4.dp)
            )
    ) {
        Row {
            Image(
                painterResource(id = puppyInfo.avatar),
                "${puppyInfo.name}'s picture",
                Modifier.size(150.dp),
                contentScale = ContentScale.Crop
            )
            Column(
                Modifier
                    .padding(8.dp)
                    .align(Alignment.CenterVertically)
            ) {
                Text(text = puppyInfo.name)
                Text(text = puppyInfo.gender)
                Text(text = puppyInfo.address)
            }
        }
    }
}
