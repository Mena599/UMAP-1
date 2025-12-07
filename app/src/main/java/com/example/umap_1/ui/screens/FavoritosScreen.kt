package com.example.umap_1.ui.screens

import android.widget.Space
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.umap_1.components.BotonNavegacion
import com.example.umap_1.components.MapCard
import com.example.umap_1.components.TopFavoritos
import com.example.umap_1.components.TopHeader


@Composable
fun FavoritosScreen(){


    Scaffold(
        topBar = { TopFavoritos() },
        bottomBar = { BotonNavegacion() }
    ) { padding ->

        Column(
            modifier = Modifier.padding(padding).padding(top = 16.dp)
                .fillMaxSize(),
                verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            MapCard()
            Spacer(modifier = Modifier.height(20.dp))
        }
    }


}