package com.example.umap_1.models

data class Punto(
    val id: String = "",
    val nombre: String,
    val descripcion: String = "",
    val horario: String = "",
    val lat: Double,
    val lng: Double,
    val photoUrl: String? = null,
    val categoria: String? = null
)
