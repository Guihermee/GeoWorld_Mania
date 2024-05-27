package br.com.fiap.geoworldmania.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.geoworldmania.model.Pais
import coil.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContinenteCard(continentes: String, onClick: () -> Unit) {
    Card(
        onClick = onClick,
        modifier = Modifier
            .size(100.dp)
            .padding(end = 4.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(text = continentes, modifier = Modifier.padding(16.dp))
        }
    }
}

@Composable
fun PaisCard(pais: Pais) {
    Card(modifier = Modifier.padding(bottom = 8.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .weight(3f)
            ) {
                Text(
                    text = pais.nome.portugues.common,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = pais.regiao,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal
                )
            }
            Text(
                text = pais.capital[0],
                modifier = Modifier
                    .weight(2f)
                    .fillMaxWidth(),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Blue
            )
        }
    }
}

@Composable
fun BandeiraCard(pais: Pais) {
    Card(modifier = Modifier.padding(bottom = 8.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .weight(3f)
            ) {
                Text(
                    text = pais.nome.portugues.common,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = pais.regiao,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal
                )
            }
            AsyncImage(
                model = pais.bandeira.png,
                contentDescription = "Bandeira da/do ${pais.nome.portugues.common}",
                modifier = Modifier.size(150.dp).padding(end = 16.dp)
            )
        }
    }
}