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
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.geoworldmania.components.ContinenteCard
import br.com.fiap.geoworldmania.components.Footer
import br.com.fiap.geoworldmania.components.Header
import br.com.fiap.geoworldmania.components.PaisCard
import br.com.fiap.geoworldmania.model.Pais
import br.com.fiap.geoworldmania.repository.getAllContinentesString
import br.com.fiap.geoworldmania.repository.getPaisByCountryContinente
import br.com.fiap.geoworldmania.viewModel.ConsultaCapitaisViewModel

@Composable
fun ConsultaCapitaisScreen(
    navController: NavController,
    consultaCapitaisViewModel: ConsultaCapitaisViewModel,
    tituloJogo: String
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Header(textContent = tituloJogo, onClickVoltar = { navController.navigate("telaInicial") })

        val consultaState by consultaCapitaisViewModel.consultaState.observeAsState(initial = "")

        OutlinedTextField(
            value = consultaState,
            onValueChange = {
                consultaCapitaisViewModel.onConsultaChanged(it)
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
                ContinenteCard(
                    it,
                    onClick = {
                        consultaCapitaisViewModel.onConsultaChanged(it)
                    }
                )
            }
        }
        LazyColumn(modifier = Modifier.padding(16.dp)) {
            items(getPaisByCountryContinente(consultaState)) {
                PaisCard(pais = it)
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
    
    Column(modifier = Modifier.fillMaxSize()) {
        Box(contentAlignment = Alignment.BottomCenter) { Footer(navController = navController) }
    }
}