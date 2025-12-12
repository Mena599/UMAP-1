package com.example.umap_1.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import androidx.navigation.NavController
import com.example.umap_1.components.AddPlaceModal

import com.example.umap_1.components.BotonNavegacionSuperAdmin

import com.example.umap_1.components.CategoriasMenu

import com.example.umap_1.components.MapCard

import com.example.umap_1.components.TopHeader
import com.example.umap_1.viewmodel.PuntosViewModel
@Composable
fun SuperAdminScreen(
    navController: NavController,
    puntosViewModel: PuntosViewModel
) {

    var showAddModal by remember { mutableStateOf(false) }

    Scaffold(
        topBar = { TopHeader() },
        bottomBar = {
            BotonNavegacionSuperAdmin(navController) {
                showAddModal = true   // ← abre el modal del botón "+"
            }
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .padding(top = 16.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            CategoriasMenu()

            Spacer(modifier = Modifier.height(20.dp))

            MapCard(
                puntosViewModel = puntosViewModel,
                onMarkerClick = { puntoId ->
                    // Aquí decides qué hacer cuando toquen un marcador
                    // Por ejemplo: abrir modal de edición
                    showAddModal = true
                }
            )
            Spacer(modifier = Modifier.height(20.dp))
        }

        // ----------------------
        //         MODAL
        // ----------------------
        if (showAddModal) {
            AddPlaceModal(
                onClose = { showAddModal = false },
                puntosViewModel = puntosViewModel,
                onDismiss = { showAddModal = false }
            )
        }
    }
}
