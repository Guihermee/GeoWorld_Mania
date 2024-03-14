package br.com.fiap.geoworldmania.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.geoworldmania.R


@Composable
fun Header() {
    Card {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
                .background(color = colorResource(id = R.color.azul2))
                .height(70.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.arrow_back_42),
                contentDescription = "Icone de voltar",
                modifier = Modifier.padding(start = 16.dp),
                tint = colorResource(id = R.color.azul5)
            )

            Text(
                text = "Capital - Europa - Nível 1",
                color = colorResource(id = R.color.azul5),
                fontSize =  20.sp
            )

            Icon(
                painter = painterResource(id = R.drawable.more_vert_42),
                contentDescription = "Ícone de mais",
                modifier = Modifier.padding(end = 16.dp),
                tint = colorResource (id = R.color.azul5)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun HeaderPreview() {
    Header()
}