package br.com.fiap.geoworldmania.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.geoworldmania.R
import br.com.fiap.geoworldmania.R.drawable.co
import br.com.fiap.geoworldmania.R.drawable.heart_filled_42_white
import br.com.fiap.geoworldmania.R.drawable.lightbulb_filled_42_white
import br.com.fiap.geoworldmania.components.Footer
import br.com.fiap.geoworldmania.components.Header
import br.com.fiap.geoworldmania.components.OpcoesEscolhaNivel
import br.com.fiap.geoworldmania.components.OpcoesEscolhaNivelTest
import br.com.fiap.geoworldmania.repository.getAllNiveis
import br.com.fiap.geoworldmania.viewModel.JogoDaCapitalScreenViewModel

@Composable
fun OpcoesDeNiveisScreen(
    navController: NavController,
    continente: String,
    tituloJogo: String,
    tituloContinente: String,
    jogoPais: Boolean,
    jogoBandeira: Boolean
) {
    val context = LocalContext.current

    Box(modifier = Modifier.fillMaxWidth()) {
        Column {

            //Chamada do componente Header
            Header(textContent = "${tituloJogo} - ${tituloContinente}", onClickVoltar = {
                navController.navigate("opcoesDeContinente?tituloJogo=${tituloJogo}?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}")
            })

            Spacer(modifier = Modifier.height(4.dp))

            // Titulo da Tela
            Text(
                modifier = Modifier.padding(start = 24.dp),
                text = "Níveis",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.azul5)
            )

            // Percorrendo uma Lista de níveis (dataClass) e Aplicando um componente para cada
            LazyColumn {
                items(
                    // Percorrendo a lista
                    getAllNiveis(
                        navController = navController,
                        continente = continente,
                        tituloJogo = tituloJogo,
                        tituloContinente = tituloContinente,
                        jogoPais = jogoPais,
                        jogoBandeira = jogoBandeira,
                        context = context
                    )
                ) {
                    OpcoesEscolhaNivelTest(it) // Aplicando o componente para os Níveis disponíveis
                }
            }
        }
        // Chamada do componente Footer
        Box(contentAlignment = Alignment.BottomCenter) { Footer(navController = navController) }
    }

}