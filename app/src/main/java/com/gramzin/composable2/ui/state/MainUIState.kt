package com.gramzin.composable2.ui.state

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.paging.PagingData
import com.gramzin.composable2.domain.model.City
import kotlinx.coroutines.flow.Flow

data class MainUIState(
    var cities: Flow<PagingData<City>>,
    val loading: MutableState<Boolean> = mutableStateOf(false),
    val error: MutableState<Boolean> = mutableStateOf(false)
    )