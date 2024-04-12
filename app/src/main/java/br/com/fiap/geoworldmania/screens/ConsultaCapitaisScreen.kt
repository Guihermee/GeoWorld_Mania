package br.com.fiap.geoworldmania.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.geoworldmania.components.Footer
import br.com.fiap.geoworldmania.components.Header
import br.com.fiap.geoworldmania.model.Pais
import br.com.fiap.geoworldmania.repository.getAllContinentesString
import br.com.fiap.geoworldmania.repository.getPaisByCountry
import br.com.fiap.geoworldmania.viewModel.ConsultaCapitaisViewModel

@Composable
fun ConsultaCapitaisScreen(
    navController: NavController,
    ConsultaCapitaisViewModel: ConsultaCapitaisViewModel,
    tituloJogo: String
) {
    Column {
        Header(textContent = tituloJogo, onClickVoltar = { navController.navigate("telaInicial") })

        val consultaState by ConsultaCapitaisViewModel.consultaState.observeAsState(initial = "")

        OutlinedTextField(
            value = consultaState,
            onValueChange = {
                ConsultaCapitaisViewModel.onConsultaChanged(it)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp),
            label = {
                Text(text = "Nome do País")
            },
            trailingIcon = {
                IconButton(onClick = { /*TODO botao de busca*/ }) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = ""
                    )
                }
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        LazyRow(modifier = Modifier.padding(start = 16.dp, end = 16.dp)) {
            items(getAllContinentesString()) {
                ContinenteCard(it)
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn(modifier = Modifier.padding(16.dp)) {
            items(getPaisByCountry(consultaState)) {
                PaisCard(pais = it)
            }
        }


        Box(contentAlignment = Alignment.BottomCenter) { Footer(navController = navController) }
    }
}

@Composable
fun ContinenteCard(continentes: String) {
    Button(
        onClick = {},
        modifier = Modifier
            .size(100.dp)
            .padding(end = 4.dp),
        colors = ButtonDefaults.buttonColors(Color.Transparent)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(text = continentes)
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