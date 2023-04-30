package com.gramzin.composable2

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gramzin.composable2.di.components.DaggerAppComponent
import com.gramzin.composable2.di.module.mainScreen.DaggerMainScreenComponent
import com.gramzin.composable2.di.module.mainScreen.MainScreenComponent
import com.gramzin.composable2.ui.Screen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val appComponent = DaggerAppComponent.factory().create(navController.context)
    NavHost(navController = navController, startDestination = Screen.Splash.route){
        composable(route = Screen.Splash.route){
            SplashScreen(onNavigateToMain = {navController.navigate(Screen.Main.route)})
        }
        composable(route = Screen.Main.route){
            val mainScreenComponent = DaggerMainScreenComponent
                .builder()
                .appComponent(appComponent)
                .build()
            MainScreen(onClick = {}, mainScreenComponent.getViewModel())
        }
    }
}