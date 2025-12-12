package com.example.umap_1.components

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.LocationListener
import android.location.LocationManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.core.content.ContextCompat
import com.example.umap_1.viewmodel.PuntosViewModel
@Composable
fun AddPlaceModal(
    onClose: () -> Unit,
    puntosViewModel: PuntosViewModel,
    onDismiss: () -> Unit
) {
    val contexto = LocalContext.current

    var nombre by remember { mutableStateOf("") }
    var descripcion by remember { mutableStateOf("") }
    var horario by remember { mutableStateOf("") }

    var latText by remember { mutableStateOf("") }
    var lngText by remember { mutableStateOf("") }

    var tienePermiso by remember { mutableStateOf(false) }

    val permissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { granted ->
        tienePermiso = granted
        if (granted) {
            val lm = contexto.getSystemService(Context.LOCATION_SERVICE) as LocationManager
            val last = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER)
            if (last != null) {
                latText = last.latitude.toString()
                lngText = last.longitude.toString()
            }
        }
    }

    // PEDIR PERMISO Y OBTENER UBICACIÓN AL ABRIR EL MODAL
    LaunchedEffect(Unit) {
        if (ContextCompat.checkSelfPermission(
                contexto,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            permissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        } else {
            tienePermiso = true
            val lm = contexto.getSystemService(Context.LOCATION_SERVICE) as LocationManager
            val last = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER)
            if (last != null) {
                latText = last.latitude.toString()
                lngText = last.longitude.toString()
            }
        }
    }

    Dialog(onDismissRequest = onClose) {
        Card(
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth(0.92f)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Añadir nuevo punto", style = MaterialTheme.typography.titleLarge)
                Spacer(Modifier.height(12.dp))

                OutlinedTextField(value = nombre, onValueChange = { nombre = it }, label = { Text("Nombre") })

                Spacer(Modifier.height(8.dp))
                Row {
                    OutlinedTextField(
                        value = latText,
                        onValueChange = { latText = it },
                        label = { Text("Latitud") },
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(Modifier.width(8.dp))
                    OutlinedTextField(
                        value = lngText,
                        onValueChange = { lngText = it },
                        label = { Text("Longitud") },
                        modifier = Modifier.weight(1f)
                    )
                }

                Spacer(Modifier.height(8.dp))
                OutlinedTextField(value = horario, onValueChange = { horario = it }, label = { Text("Horario") })
                Spacer(Modifier.height(8.dp))
                OutlinedTextField(value = descripcion, onValueChange = { descripcion = it }, label = { Text("Descripción") })

                Spacer(Modifier.height(12.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(onClick = onClose) { Text("Cancelar") }
                    Spacer(Modifier.width(8.dp))

                    Button(onClick = {
                        val lat = latText.toDoubleOrNull() ?: return@Button
                        val lng = lngText.toDoubleOrNull() ?: return@Button

                        puntosViewModel.agregarPunto(
                            nombre = nombre,
                            descripcion = descripcion,
                            horario = horario,
                            lat = lat,
                            lng = lng
                        )
                        onClose()
                    }) {
                        Text("Guardar")
                    }
                }
            }
        }
    }
}


