package com.example.androiddevchallenge

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.viewmodel.compose.viewModel
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
        PuppyList(puppyList = viewModel.puppyList)  { puppyInfo ->
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