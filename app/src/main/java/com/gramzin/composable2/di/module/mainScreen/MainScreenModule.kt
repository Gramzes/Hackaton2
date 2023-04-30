package com.gramzin.composable2.di.module.mainScreen

import com.gramzin.composable2.di.module.mainScreen.MainScreenScope
import com.gramzin.composable2.domain.usecases.GetCitiesUseCase
import com.gramzin.composable2.ui.viewModel.MainViewModel
import dagger.Module
import dagger.Provides


@Module
object MainScreenModule{
    @Provides
    @MainScreenScope
    fun provideViewModel(getCitiesUseCase: GetCitiesUseCase): MainViewModel =
        MainViewModel(getCitiesUseCase)
}