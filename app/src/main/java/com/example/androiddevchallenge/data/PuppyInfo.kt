package com.example.androiddevchallenge.data

import androidx.annotation.DrawableRes

data class PuppyInfo(
    val id: String,
    val name: String,
    val age: String,
    val address: String,
    val gender: String,
    val desc: String,
    @DrawableRes val avatar: Int
)