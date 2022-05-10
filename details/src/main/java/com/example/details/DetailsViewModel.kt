package com.example.details

import androidx.lifecycle.ViewModel
import com.example.navigation.Navigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val navigator: Navigator
): ViewModel(), Navigator by navigator {
}