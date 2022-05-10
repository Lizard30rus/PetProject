package com.example.details

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun DetailsUI() {
    val viewModel: DetailsViewModel = hiltViewModel()
    Text(
        text = "This is Detals screen",
        textAlign = TextAlign.Center,
        fontSize = 32.sp
    )
}