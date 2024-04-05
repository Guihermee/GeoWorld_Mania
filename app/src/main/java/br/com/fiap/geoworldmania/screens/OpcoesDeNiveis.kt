package br.com.fiap.geoworldmania.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.geoworldmania.R
import br.com.fiap.geoworldmania.R.drawable.heart_filled_42_white
import br.com.fiap.geoworldmania.R.drawable.lightbulb_filled_42_white
import br.com.fiap.geoworldmania.components.Footer
import br.com.fiap.geoworldmania.components.Header
import br.com.fiap.geoworldmania.components.OpcoesEscolhaNivel
import br.com.fiap.geoworldmania.viewModel.JogoDaCapitalScreenViewModel

@Composable

fun OpcoesDeNiveisScreen(
    navController: NavController,
    continente: String,
    tituloJogo: String,
    tituloContinente: String
) {

    Box(modifier = Modifier.fillMaxWidth()) {
        Column {
            Header(textContent = "${tituloJogo} - ${tituloContinente}", onClickVoltar = {
                navController.navigate("opcoesDeContinente?tituloJogo=${tituloJogo}")
            })
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                modifier = Modifier.padding(start = 24.dp),
                text = "Níveis",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.azul5)
            )



            OpcoesEscolhaNivel(
                texto1 = "Nível 1: 10 Países",
                imagem = lightbulb_filled_42_white,
                onClick = {
                    navController.navigate("jogoDaCapital?nivel=10?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?tituloNivel=Nível 1?desafio=false")
                },
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.verde_claro))
            )

            OpcoesEscolhaNivel(
                texto1 = "Nivel 2: +10 Países",
                imagem = lightbulb_filled_42_white,
                onClick = {
                    navController.navigate("jogoDaCapital?nivel=20?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?tituloNivel=Nível 2?desafio=false")
                },
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.verde_claro))
            )

            OpcoesEscolhaNivel(
                texto1 = "Desafio 1: 20 Países",
                imagem = heart_filled_42_white,
                onClick = {
                    navController.navigate("jogoDaCapital?nivel=20?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?tituloNivel=Desafio 1?desafio=true")
                },
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.azul_claro))
            )

            OpcoesEscolhaNivel(
                texto1 = "Nivel 3: 10 Países",
                imagem = lightbulb_filled_42_white,
                onClick = {
                    navController.navigate("jogoDaCapital?nivel=30?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?tituloNivel=Nível 3?desafio=false")
                },
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.verde_claro))
            )

            OpcoesEscolhaNivel(
                texto1 = "Nivel 4: +10 Países",
                imagem = lightbulb_filled_42_white,
                onClick = {
                    navController.navigate("jogoDaCapital?nivel=40?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?tituloNivel=Nível 4?desafio=false")
                },
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.verde_claro))
            )

            OpcoesEscolhaNivel(
                texto1 = "Desafio 2: 40 Países",
                imagem = heart_filled_42_white,
                onClick = {
                    navController.navigate("jogoDaCapital?nivel=40?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?tituloNivel=Desafio 2?desafio=true")
                },
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.azul_claro))
            )

            OpcoesEscolhaNivel(
                texto1 = "Desafio Difícil: Todos os países",
                imagem = heart_filled_42_white,
                onClick = {
                    navController.navigate("jogoDaCapital?nivel=53?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?tituloNivel=Desafio final?desafio=true")
                },
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.vermelho))
            )
        }
        Box(contentAlignment = Alignment.BottomCenter) { Footer() }
    }

}