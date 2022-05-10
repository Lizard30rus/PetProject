package com.example.settings

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun SettingsUI() {
    val viewModel: SettingsViewModel = hiltViewModel()
    Text(
        text = "This is Settings screen",
        textAlign = TextAlign.Center,
        fontSize = 32.sp
    )
}