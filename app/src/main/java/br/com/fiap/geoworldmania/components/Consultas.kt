package br.com.fiap.geoworldmania.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ConsultaButton(texto1: String, imagem: Int, colors: ButtonColors, onClick: () -> Unit) {
    Spacer(modifier = Modifier.height(4.dp))
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
            .height(75.dp),
        shape = RoundedCornerShape(4.dp),
        colors = colors,
    ) {
        Row(
            horizontalArrangement = Arrangement.Absolute.SpaceBetween,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column{
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = texto1,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 20.sp
                )
            }
            Image(
                painter = painterResource(id = imagem),
                contentDescription = "",
                modifier = Modifier
                    .size(50.dp)
                    .graphicsLayer {
                        alpha = 0.6f
                    }
            )
        }
    }
}

