package com.gramzin.composable2

import android.app.Application
import com.gramzin.composable2.di.components.AppComponent

class FuelApp: Application() {
    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
    }
}