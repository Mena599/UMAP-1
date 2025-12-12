package com.example.umap_1.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.umap_1.models.Punto
import kotlinx.coroutines.launch
import java.util.UUID

class PuntosViewModel : ViewModel() {

    // Lista observable usada por Compose
    private val _puntos = mutableStateListOf<Punto>()
    val puntos: List<Punto> get() = _puntos

    // Agregar punto (genera id)
    fun agregarPunto(
        nombre: String,
        descripcion: String,
        horario: String,
        lat: Double,
        lng: Double,
        categoria: String? = null,
        photoUrl: String? = null
    ) {
        val nuevo = Punto(
            id = UUID.randomUUID().toString(),
            nombre = nombre,
            descripcion = descripcion,
            horario = horario,
            lat = lat,
            lng = lng,
            categoria = categoria,
            photoUrl = photoUrl
        )
        _puntos.add(nuevo)
        // aquí puedes lanzar coroutine para guardar en Firestore cuando la conectes
    }

    fun editarPunto(edited: Punto) {
        val idx = _puntos.indexOfFirst { it.id == edited.id }
        if (idx >= 0) {
            _puntos[idx] = edited
            // actualizar en la nube si aplica
        }
    }

    fun eliminarPunto(id: String) {
        val idx = _puntos.indexOfFirst { it.id == id }
        if (idx >= 0) {
            _puntos.removeAt(idx)
            // eliminar en la nube si aplica
        }
    }

    // Opcional: cargar datos iniciales (por ahora ejemplo)
    fun cargarEjemplo() {
        viewModelScope.launch {
            if (_puntos.isEmpty()) {
                _puntos.add(
                    Punto(
                        id = UUID.randomUUID().toString(),
                        nombre = "Cafetería Central",
                        descripcion = "Comida económica y rápida",
                        horario = "8:00 - 17:00",
                        lat = 18.9119,
                        lng = -99.1797,
                        categoria = "Cafetería"
                    )
                )
            }
        }
    }
}
