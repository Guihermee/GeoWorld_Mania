package br.com.fiap.geoworldmania.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.geoworldmania.R
import br.com.fiap.geoworldmania.model.Pais
import coil.compose.AsyncImage

@Composable
fun JogoCapital(pais: Pais) {

    Text(
        text = "${pais.nome}",
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 6.dp),
        textAlign = TextAlign.Center,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold
    )

    // Imagem do Pais
    Column(
        modifier = Modifier.height(250.dp)
    ) {
        AsyncImage(
            model = "${pais.bandeira}",
            contentDescription = "Bandeira do Pais",
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, end = 16.dp),
            contentScale = ContentScale.Crop
        )
    }

    Spacer(modifier = Modifier.height(16.dp))

    Text(
        text = stringResource(id = R.string.qual_capital),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, bottom = 8.dp),
        textAlign = TextAlign.Start,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold
    )
    val nomePais = pais.capital.first().split("=")[1].split("common=")[1].removeSuffix(")")
    OpcaoDeEscolhaJogoErrado(nomePais)
    OpcaoDeEscolhaJogoErrado(opcao = "Nicosia")
    OpcaoDeEscolhaJogoErrado(opcao = "Bratislava")
    OpcaoDeEscolhaJogoErrado(opcao = "Belgrade")
}