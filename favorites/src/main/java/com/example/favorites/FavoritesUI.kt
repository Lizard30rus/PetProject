package com.example.favorites

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun FavoritesUI() {
    val viewModel: FavoritesViewModel = hiltViewModel()
    Text(
        text = "This is Favorites screen",
        textAlign = TextAlign.Center,
        fontSize = 32.sp
    )
}