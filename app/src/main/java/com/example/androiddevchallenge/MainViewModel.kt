package com.example.androiddevchallenge

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.data.PuppyInfo

class MainViewModel: ViewModel() {

    val puppyList by mutableStateOf(
        listOf(
            PuppyInfo("1", "Pudding", "6", "hangzhou",
                "girl", "good dog", R.drawable.img_pudding),
            PuppyInfo("2", "Jelly", "1", "hangzhou",
                "girl", "good dog", R.drawable.img_jelly),
            PuppyInfo("3", "Beans", "10", "anqiu",
                "girl", "good dog", R.drawable.img_beans),
            PuppyInfo("4", "LittleYellow", "8", "anqiu",
            "girl", "good dog", R.drawable.img_little_yellow),
            PuppyInfo("5", "Niuniu", "15", "anqiu",
                "girl", "good dog", R.drawable.img_niuniu)
        )
    )

    var currentPuppy: PuppyInfo? by mutableStateOf(null)

    fun showPuppy(puppy: PuppyInfo) {
        currentPuppy = puppy
    }

    fun dismiss() {
        currentPuppy = null
    }

}