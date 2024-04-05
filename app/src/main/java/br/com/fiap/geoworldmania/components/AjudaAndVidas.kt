package br.com.fiap.geoworldmania.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.geoworldmania.R

@Composable
fun Ajuda(onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 16.dp),
        horizontalArrangement = Arrangement.End
    ) {
        Button(
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.lightbulb_outline_42),
                        tint = colorResource(id = R.color.azul5),
                        contentDescription = "Icone de uma lâmpada"
                    )
                    Text(
                        text = stringResource(id = R.string.CampoDica),
                        color = colorResource(id = R.color.azul5),
                        fontSize = 20.sp
                    )
                }
            }
        }
    }

    Spacer(modifier = Modifier.height(16.dp))
}

@Composable
fun Vidas(onClick: () -> Unit, heart01: Boolean, heart02: Boolean, heart03: Boolean) {
    Box {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 16.dp),
            horizontalArrangement = Arrangement.End
        ) {
            Row {

                if (heart01) {
                    Icon(
                        painter = painterResource(id = R.drawable.heart_filled_42),
                        contentDescription = "Ícone de Coração Cheio",
                        tint = colorResource(id = R.color.vermelho)
                    )
                } else {
                    Icon(
                        painter = painterResource(id = R.drawable.heart_outline_42),
                        contentDescription = "Ícone de Coração Cheio",
                        tint = colorResource(id = R.color.vermelho)
                    )
                }

                if (heart02) {
                    Icon(
                        painter = painterResource(id = R.drawable.heart_filled_42),
                        contentDescription = "Ícone de Coração Cheio",
                        tint = colorResource(id = R.color.vermelho)
                    )
                } else {
                    Icon(
                        painter = painterResource(id = R.drawable.heart_outline_42),
                        contentDescription = "Ícone de Coração Cheio",
                        tint = colorResource(id = R.color.vermelho)
                    )
                }

                if (heart03) {
                    Icon(
                        painter = painterResource(id = R.drawable.heart_filled_42),
                        contentDescription = "Ícone de Coração Cheio",
                        tint = colorResource(id = R.color.vermelho)
                    )
                } else {
                    Icon(
                        painter = painterResource(id = R.drawable.heart_outline_42),
                        contentDescription = "Ícone de Coração Cheio",
                        tint = colorResource(id = R.color.vermelho)
                    )
                }

            }
        }
    }
    Spacer(modifier = Modifier.height(16.dp))
}