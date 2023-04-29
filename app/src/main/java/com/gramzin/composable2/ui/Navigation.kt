package com.gramzin.composable2

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gramzin.composable2.ui.Screen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Splash.route){
        composable(route = Screen.Splash.route){
            SplashScreen(onNavigateToMain = {navController.navigate(Screen.Main.route)})
        }
        composable(route = Screen.Main.route){
            MainScreen(onClick = {})
        }
    }
}