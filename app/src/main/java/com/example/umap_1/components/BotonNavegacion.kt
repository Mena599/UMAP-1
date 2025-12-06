package com.example.umap_1.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.umap_1.R

@Composable
fun BotonNavegacion() {

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
            label = { Text("Inicio", color = Color.White) }
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
            label = { Text("Favoritos", color = Color.White) }
        )
    }

}