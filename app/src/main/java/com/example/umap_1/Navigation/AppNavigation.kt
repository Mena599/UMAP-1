package com.example.umap_1.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.umap.ui.screens.HomeScreen
import com.example.umap_1.ui.screens.FavoritosScreen
import com.example.umap_1.ui.screens.LoginScreen


@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login"
    ) {
        composable("login") {
            LoginScreen(navController)
        }
        composable("home") {
            HomeScreen(navController)
        }
        composable("favoritos") {
            FavoritosScreen(navController)
        }
    }
}
