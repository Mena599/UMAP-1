@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.umap.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.umap_1.components.BotonNavegacion
import com.example.umap_1.components.CategoriasMenu
import com.example.umap_1.components.MapCard
import com.example.umap_1.components.TopHeader


@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = { TopHeader() },
        bottomBar = { BotonNavegacion(navController) }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)      // ✔ Respeta TopBar y BottomBar
                .padding(top = 16.dp)  // ✔ Baja el contenido debajo de la cámara
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            CategoriasMenu()

            Spacer(modifier = Modifier.height(20.dp))

            MapCard()

            Spacer(modifier = Modifier.height(20.dp))
        }
    }

}

