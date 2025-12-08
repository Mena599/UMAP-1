package com.example.umap_1.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.umap_1.R
import com.example.umap_1.models.Categoria

// --- Tus categorías ---
val categorias = listOf(
    Categoria("Cafeterías", R.drawable.cafeteria),
    Categoria("Biblioteca", R.drawable.biblioteca),
    Categoria("Edificios", R.drawable.docencias),
    Categoria("Servicio médico", R.drawable.enfermeria),
    Categoria("Estacionamiento", R.drawable.parking)
)
@Composable
fun CategoriasMenu() {

    var categoriaSeleccionada by remember { mutableStateOf<Categoria?>(null) }

    Box {
        // ----- LISTA DE ICONOS -----
        LazyRow(horizontalArrangement = Arrangement.spacedBy(24.dp)) {
            items(categorias) { categoria ->

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.clickable {
                        categoriaSeleccionada = categoria
                    }
                ) {
                    Image(
                        painter = painterResource(id = categoria.icon),
                        contentDescription = categoria.titulo,
                        modifier = Modifier.size(45.dp)
                    )
                    Text(text = categoria.titulo, fontSize = 12.sp)
                }
            }
        }

        // ----- MODAL SUPERPUESTO -----
        categoriaSeleccionada?.let { categoria ->

            // Fondo semitransparente (click → cerrar)
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable {
                        categoriaSeleccionada = null // Cierra modal
                    },
                contentAlignment = Alignment.Center
            ) {

                // Card – evita que el click cierre por accidente
                Box(
                    modifier = Modifier
                        .wrapContentSize()
                        .clickable(enabled = false) { },
                ) {
                    PlaceCard(
                        title = categoria.titulo,
                        name = "Lugar destacado",
                        dishes = listOf("Ejemplo 1", "Ejemplo 2", "Ejemplo 3"),
                        schedule = "8:00 AM - 5:00 PM",
                        onNavigateClick = {
                            // Acción del botón Ir
                        },
                        onClose = {
                            categoriaSeleccionada = null
                        }
                    )
                }
            }
        }
    }
}
