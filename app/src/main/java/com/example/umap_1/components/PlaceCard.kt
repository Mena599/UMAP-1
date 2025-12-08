package com.example.umap_1.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.umap_1.R


@Composable
fun PlaceCard(
    title: String,
    name: String,
    dishes: List<String>,
    schedule: String,
    onNavigateClick: () -> Unit,
    onClose: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth(0.90f)
            .wrapContentHeight(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {

        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            // --------- BOTÓN DE CERRAR (X) -----------
            Icon(
                painter = painterResource(id = R.drawable.favorito), // agrega un ícono close
                contentDescription = "Cerrar",
                tint = Color.Gray,
                modifier = Modifier
                    .size(28.dp)
                    .align(Alignment.TopEnd)
                    .padding(12.dp)
                    .clickable { onClose() }
            )

            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                // TÍTULO PRINCIPAL
                Text(
                    text = title,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1F2A44),
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    // ------------ FOTO -------------
                    Box(
                        modifier = Modifier
                            .size(140.dp)
                            .background(Color(0xFFE5E5E5), RoundedCornerShape(10.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Foto", color = Color.DarkGray)
                    }

                    Spacer(modifier = Modifier.width(20.dp))

                    Column {

                        // Nombre del lugar
                        Text(
                            text = name,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        // --------- PLATILLOS ----------
                        Text(
                            text = "Platillos populares",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold
                        )

                        dishes.forEachIndexed { index, dish ->
                            Text("${index + 1}. $dish", fontSize = 14.sp)
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        // --------- HORARIO ----------
                        Text(
                            text = "Horario: $schedule",
                            fontSize = 14.sp
                        )
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                // ----------- BOTÓN IR -----------
                Button(
                    onClick = { onNavigateClick() },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFCCF7D1)
                    ),
                    modifier = Modifier
                        .align(Alignment.End)
                        .padding(end = 8.dp)
                ) {
                    Text("Ir", color = Color.Black)
                }
            }
        }
    }
}

@Composable
fun PlaceCard2(
    title: String,
    name: String,
    dishes: List<String>,
    schedule: String,
    onNavigateClick: () -> Unit,
    onClose: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth(0.90f)
            .wrapContentHeight(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {

        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            // --------- BOTÓN DE CERRAR (X) -----------
            Icon(
                painter = painterResource(id = R.drawable.favorito), // agrega un ícono close
                contentDescription = "Cerrar",
                tint = Color.Gray,
                modifier = Modifier
                    .size(28.dp)
                    .align(Alignment.TopEnd)
                    .padding(12.dp)
                    .clickable { onClose() }
            )

            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                // TÍTULO PRINCIPAL
                Text(
                    text = title,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1F2A44),
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    // ------------ FOTO -------------
                    Box(
                        modifier = Modifier
                            .size(140.dp)
                            .background(Color(0xFFE5E5E5), RoundedCornerShape(10.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Foto", color = Color.DarkGray)
                    }

                    Spacer(modifier = Modifier.width(20.dp))

                    Column {

                        // Nombre del lugar
                        Text(
                            text = name,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        // --------- PLATILLOS ----------
                        Text(
                            text = "Platillos populares",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold
                        )

                        dishes.forEachIndexed { index, dish ->
                            Text("${index + 1}. $dish", fontSize = 14.sp)
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        // --------- HORARIO ----------
                        Text(
                            text = "Horario: $schedule",
                            fontSize = 14.sp
                        )
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                // ----------- BOTÓN IR -----------
                Button(
                    onClick = { onNavigateClick() },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFCCF7D1)
                    ),
                    modifier = Modifier
                        .align(Alignment.End)
                        .padding(end = 8.dp)
                ) {
                    Text("Ir", color = Color.Black)
                }
            }
        }
    }
}
