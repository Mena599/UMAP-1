@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.umap.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.umap_1.R


@Composable
fun HomeScreen() {

    Scaffold(
        topBar = { TopHeader() },
        bottomBar = { BottomNavigationBar() }
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {

            CategoriesMenu()

            Spacer(modifier = Modifier.height(20.dp))

            MapCard()

            Spacer(modifier = Modifier.height(20.dp))

        }
    }

}

// -----------------------------------------------------------------------
// HEADER
// -----------------------------------------------------------------------

@Composable
fun TopHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF0A233F))
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Mapa UTEZ",
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

// -----------------------------------------------------------------------
// CATEGORIES MENU (Cafetería, Biblioteca, etc.)
// -----------------------------------------------------------------------

val categorias = listOf(
    Categoria("Cafeterías", R.drawable.cafeteria),
    Categoria("Biblioteca", R.drawable.biblioteca),
    Categoria("Edificios", R.drawable.docencias),
    Categoria("Servicio médico", R.drawable.enfermeria),
    Categoria("Estacionamiento", R.drawable.parking)
)


data class Categoria(val titulo: String, val icon: Int)

@Composable
fun CategoriesMenu() {

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

// -----------------------------------------------------------------------
// MAP CARD (la tarjeta grande donde esta el mapa)
// -----------------------------------------------------------------------

@Composable
fun MapCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF3F4F6)),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Aquí irá el mapa de la UTEZ 🗺️",
                color = Color(0xFF666666),
                fontSize = 16.sp
            )
        }
    }
}

@Composable
fun PlaceItem(nombre: String) {

    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.umaplogo),
                contentDescription = "icono",
                tint = Color(0xFF0BBF91),
                modifier = Modifier.size(22.dp)
            )

            Spacer(modifier = Modifier.width(12.dp))

            Text(
                text = nombre,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

// -----------------------------------------------------------------------
// BOTTOM NAVIGATION
// -----------------------------------------------------------------------
@Composable
fun BottomNavigationBar() {

    NavigationBar(
        containerColor = Color(0xFF0BBF91),
        tonalElevation = 8.dp
    ) {

        NavigationBarItem(
            selected = true,
            onClick = { },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.hogar),
                    contentDescription = "Inicio",
                    tint = Color.Unspecified,
                    modifier = Modifier.size(36.dp)
                )
            },
            label = {
                Text(
                    text = "Inicio",
                    color = Color.White
                )
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.White,
                selectedTextColor = Color.White,
                indicatorColor = Color(0x1AFFFFFF),
                unselectedIconColor = Color.White,
                unselectedTextColor = Color.White
            )
        )

        NavigationBarItem(
            selected = false,
            onClick = { },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.favorito),
                    contentDescription = "Favoritos",
                    tint = Color.Unspecified,
                    modifier = Modifier.size(36.dp)
                )
            },
            label = {
                Text(
                    text = "Favoritos",
                    color = Color.White
                )
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.White,
                selectedTextColor = Color.White,
                indicatorColor = Color(0x1AFFFFFF),
                unselectedIconColor = Color.White,
                unselectedTextColor = Color.White
            )
        )
    }
}



