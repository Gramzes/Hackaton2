package com.gramzin.composable2.ui.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.gramzin.composable2.domain.usecases.GetCitiesUseCase
import com.gramzin.composable2.ui.state.MainUIState
import javax.inject.Inject

class MainViewModel @Inject constructor(getCitiesUseCase: GetCitiesUseCase): ViewModel() {
    private val _state = mutableStateOf(MainUIState())
    val state: State<MainUIState> = _state

    init {
         _state.value.cities = getCitiesUseCase().cachedIn(viewModelScope)
    }

}