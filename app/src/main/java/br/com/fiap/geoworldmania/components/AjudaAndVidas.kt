package br.com.fiap.geoworldmania.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.geoworldmania.R

@Composable
fun AjudaAndVidas() {
    Button(onClick = { /*TODO*/ }) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.lightbulb_outline_42),
                    contentDescription = "Icone de uma lâmpada",
                    modifier = Modifier.padding(start = 16.dp)
                )
                Text(
                    text = stringResource(id = R.string.CampoDica),
                    fontSize = 20.sp
                )
            }
            Row {
                Icon(
                    painter = painterResource(id = R.drawable.heart_filled_42),
                    contentDescription = "Ícone de Coração Cheio",
                    tint = colorResource(id = R.color.vermelho)
                )
                Icon(
                    painter = painterResource(id = R.drawable.heart_filled_42),
                    contentDescription = "Ícone de Coração Cheio",
                    tint = colorResource(id = R.color.vermelho)
                )
                Icon(
                    painter = painterResource(id = R.drawable.heart_filled_42),
                    contentDescription = "Ícone de Coração Cheio",
                    tint = colorResource(id = R.color.vermelho),
                    modifier = Modifier.padding(end = 16.dp)
                )

            }

        }
    }
    Spacer(modifier = Modifier.height(16.dp))
}

@Composable
fun Ajuda(onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 16.dp),
        horizontalArrangement = Arrangement.End
    ) {
        Button(onClick = onClick) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.lightbulb_outline_42),
                        contentDescription = "Icone de uma lâmpada"
                    )
                    Text(
                        text = stringResource(id = R.string.CampoDica),
                        fontSize = 20.sp
                    )
                }
            }
        }
    }

    Spacer(modifier = Modifier.height(16.dp))
}

@Composable
fun Vidas(onClick: () -> Unit) {
    Box {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 16.dp),
            horizontalArrangement = Arrangement.End
        ) {
            Row {
                Icon(
                    painter = painterResource(id = R.drawable.heart_filled_42),
                    contentDescription = "Ícone de Coração Cheio",
                    tint = colorResource(id = R.color.vermelho)
                )
                Icon(
                    painter = painterResource(id = R.drawable.heart_filled_42),
                    contentDescription = "Ícone de Coração Cheio",
                    tint = colorResource(id = R.color.vermelho)
                )
                Icon(
                    painter = painterResource(id = R.drawable.heart_filled_42),
                    contentDescription = "Ícone de Coração Cheio",
                    tint = colorResource(id = R.color.vermelho),
                )

            }
        }
    }
    Spacer(modifier = Modifier.height(16.dp))
}