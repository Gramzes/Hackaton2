package com.gramzin.composable2.di.components

import android.content.Context
import com.gramzin.composable2.di.module.NetworkModule
import com.gramzin.composable2.domain.usecases.GetCitiesUseCase
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface AppComponent {
    val getCitiesUseCase: GetCitiesUseCase
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }
}