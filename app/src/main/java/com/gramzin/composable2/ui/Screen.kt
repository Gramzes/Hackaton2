package com.gramzin.composable2.ui

sealed class Screen(val route: String){
    object Splash: Screen("splash_screen")
    object Main: Screen("main_screen")
}
