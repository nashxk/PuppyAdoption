package com.example.androiddevchallenge.ui

import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.SnackbarHost
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androiddevchallenge.MainViewModel
import kotlinx.coroutines.launch

@Composable
fun Home() {
    val snackbarHostState = SnackbarHostState()
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Puppy Adoption") })
        },
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }
    ) {
        val viewModel: MainViewModel = viewModel()
        val currentPuppy = viewModel.currentPuppy
        PuppyList(puppyList = viewModel.puppyList) { puppyInfo ->
            if (currentPuppy == null) {
                viewModel.showPuppy(puppy = puppyInfo)
            }
        }
        if (currentPuppy != null) {
            PuppyDetail(puppyInfo = currentPuppy) {
                coroutineScope.launch {
                    snackbarHostState.showSnackbar("Thank you for having ${currentPuppy.name}")
                }
            }
        }
    }
}