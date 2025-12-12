package com.example.umap_1.components

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.example.umap_1.viewmodel.PuntosViewModel
import com.example.umap_1.models.Punto
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*


@Composable
fun MapCard(
    puntosViewModel: PuntosViewModel,
    onMarkerClick: (Punto) -> Unit  // ← PARA ABRIR MODAL DE EDITAR/ELIMINAR
) {

    val contexto = LocalContext.current
    var permitido by remember { mutableStateOf(false) }

    // Pedir permiso
    val permissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) {
        permitido = it
    }

    // Solicitar permiso cuando cargue
    LaunchedEffect(Unit) {
        if (ContextCompat.checkSelfPermission(
                contexto, Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            permissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        } else {
            permitido = true
        }
    }

    val initialLocation = LatLng(18.850380575881903, -99.20095298249568)

    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(initialLocation, 18f)
    }

    val puntos = puntosViewModel.puntos  // LISTA OBSERVABLE

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        GoogleMap(
            modifier = Modifier
                .fillMaxWidth()
                .height(600.dp)
                .clip(RoundedCornerShape(16.dp)),
            cameraPositionState = cameraPositionState,
            properties = MapProperties(
                isMyLocationEnabled = permitido
            ),
            uiSettings = MapUiSettings(
                zoomControlsEnabled = true
            )
        ) {

            puntos.forEach { punto ->

                Marker(
                    state = MarkerState(
                        position = LatLng(punto.lat, punto.lng)
                    ),
                    title = punto.nombre,
                    snippet = punto.descripcion,
                    onClick = {
                        onMarkerClick(punto) // ← LLAMA AL MODAL
                        true
                    }
                )
            }
        }
    }
}
