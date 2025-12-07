package com.example.umap_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.umap.ui.screens.HomeScreen
import com.example.umap_1.Navigation.AppNavigation
import com.example.umap_1.ui.screens.FavoritosScreen
import com.example.umap_1.ui.screens.LoginScreen
import com.example.umap_1.ui.theme.UMAP1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UMAP1Theme {
                AppNavigation()
            }
        }
    }
}

