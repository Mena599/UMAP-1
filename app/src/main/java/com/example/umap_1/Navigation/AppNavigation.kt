package com.example.umap_1.Navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.umap.ui.screens.HomeScreen
import com.example.umap_1.ui.screens.FavoritosScreen
import com.example.umap_1.ui.screens.LoginScreen
import com.example.umap_1.ui.screens.SuperAdminScreen
import com.example.umap_1.viewmodel.PuntosViewModel


@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login"
    ) {
        composable("login") {
            val puntosViewModel: PuntosViewModel = viewModel()
            LoginScreen(navController)
        }
        composable("home") {
            val puntosViewModel: PuntosViewModel = viewModel()
            HomeScreen(navController, puntosViewModel )

        }
        composable("favoritos") {

            val puntosViewModel: PuntosViewModel = viewModel()
            FavoritosScreen(navController, puntosViewModel)
        }
        composable("superadmin") {
            val puntosViewModel: PuntosViewModel = viewModel()
            SuperAdminScreen(navController, puntosViewModel)
        }


    }

}
