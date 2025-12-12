package com.example.umap_1.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.umap_1.models.Punto
import com.example.umap_1.viewmodel.PuntosViewModel

@Composable
fun EditPlaceModal(
    punto: Punto,
    onClose: () -> Unit,
    puntosViewModel: PuntosViewModel
) {
    var nombre by remember { mutableStateOf(punto.nombre) }
    var descripcion by remember { mutableStateOf(punto.descripcion) }
    var horario by remember { mutableStateOf(punto.horario) }
    var latText by remember { mutableStateOf(punto.lat.toString()) }
    var lngText by remember { mutableStateOf(punto.lng.toString()) }

    Dialog(onDismissRequest = onClose) {
        Card(shape = RoundedCornerShape(12.dp), modifier = Modifier.fillMaxWidth(0.92f)) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Editar / Eliminar", style = MaterialTheme.typography.titleLarge)
                Spacer(modifier = Modifier.height(12.dp))

                OutlinedTextField(value = nombre, onValueChange = { nombre = it }, label = { Text("Nombre") })
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(value = horario, onValueChange = { horario = it }, label = { Text("Horario") })
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(value = descripcion, onValueChange = { descripcion = it }, label = { Text("Descripción") })
                Spacer(modifier = Modifier.height(8.dp))

                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                    TextButton(onClick = {
                        puntosViewModel.eliminarPunto(punto.id)
                        onClose()
                    }) {
                        Text("Eliminar", color = MaterialTheme.colorScheme.error)
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(onClick = {
                        val lat = latText.toDoubleOrNull() ?: punto.lat
                        val lng = lngText.toDoubleOrNull() ?: punto.lng
                        puntosViewModel.editarPunto(punto.copy(
                            nombre = nombre,
                            descripcion = descripcion,
                            horario = horario,
                            lat = lat,
                            lng = lng
                        ))
                        onClose()
                    }) {
                        Text("Editar")
                    }
                }
            }
        }
    }
}
