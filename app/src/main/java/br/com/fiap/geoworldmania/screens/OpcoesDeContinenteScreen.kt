package br.com.fiap.geoworldmania.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.geoworldmania.R
import br.com.fiap.geoworldmania.components.Footer
import br.com.fiap.geoworldmania.components.Header
import br.com.fiap.geoworldmania.components.OpcoesEscolhaCapital
import br.com.fiap.geoworldmania.repository.getAllContinente

@Composable
fun OpcoesDeContinenteScreen(
    navController: NavController,
    tituloJogo: String,
    jogoPais: Boolean,
    jogoBandeira: Boolean
) {

    val context = LocalContext.current

    Column(modifier = Modifier.fillMaxSize()) {

        Header(
            textContent = tituloJogo,
            onClickVoltar = { navController.navigate("telaInicial") })

        Spacer(modifier = Modifier.height(4.dp))

        // Titulo dos Continentes
        Text(
            modifier = Modifier.padding(start = 24.dp),
            text = "Continentes",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.azul5)
        )

        // Preenchendo os Continentes existentes com lazyColumn percorrendo a Lista dos continentes
        LazyColumn {
            items(
                // Uma função que fica no repository que devolve todos os continentes
                getAllContinente(
                    navController = navController,
                    tituloJogo = tituloJogo,
                    jogoPais = jogoPais,
                    jogoBandeira = jogoBandeira,
                    context = context
                )
            ) {
                // Preenchendo os Cards com um Componente que recebe um Pais que é uma class data
                // Assim cada item da função acima recebe um Card.
                OpcoesEscolhaCapital(it)
            }

        }

        // Chamada do componente Footer
        Box(contentAlignment = Alignment.BottomCenter) { Footer(navController = navController) }
    }
}