package com.example.umap_1.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.umap_1.models.Categoria
import com.example.umap_1.R

val categorias = listOf(
    Categoria("Cafeterías", R.drawable.cafeteria),
    Categoria("Biblioteca", R.drawable.biblioteca),
    Categoria("Edificios", R.drawable.docencias),
    Categoria("Servicio médico", R.drawable.enfermeria),
    Categoria("Estacionamiento", R.drawable.parking)
)

@Composable
fun CategoriasMenu() {

    LazyRow(horizontalArrangement = Arrangement.spacedBy(24.dp)) {
        items(categorias) { categoria ->

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = categoria.icon),
                    contentDescription = categoria.titulo,
                    modifier = Modifier.size(45.dp)
                )
                Text(
                    text = categoria.titulo,
                    fontSize = 12.sp
                )
            }
        }
    }
}
