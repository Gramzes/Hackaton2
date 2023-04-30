package com.gramzin.composable2.di.module.mainScreen

import com.gramzin.composable2.di.components.AppComponent
import com.gramzin.composable2.ui.viewModel.MainViewModel
import dagger.Component

@Component(
    dependencies = [AppComponent::class],
    modules = [MainScreenModule::class]
)
@MainScreenScope
interface MainScreenComponent {

    fun getViewModel(): MainViewModel
}