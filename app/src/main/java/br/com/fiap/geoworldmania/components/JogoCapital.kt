package br.com.fiap.geoworldmania.components

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.geoworldmania.R
import br.com.fiap.geoworldmania.viewModel.JogoDaCapitalScreenViewModel
import br.com.fiap.geoworldmania.model.Pais
import coil.compose.AsyncImage

@Composable
fun JogoCapital(
    pais: Pais,
    opcoesDeEscolha: List<Pais>,
    listaDePais: List<Pais>,
    navController: NavController,
    jogoDaCapitalScreenViewModel: JogoDaCapitalScreenViewModel
) {

    var opcaoCorreta = pais.capital[0]
    val acertos by jogoDaCapitalScreenViewModel.acertos.observeAsState(initial = 0)
    val erros by jogoDaCapitalScreenViewModel.erros.observeAsState(initial = 0)

    // Nome do País
    Text(
        text = pais.nome.portugues.common,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 6.dp),
        textAlign = TextAlign.Center,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold
    )

    // Imagem do País
    Column(
        modifier = Modifier.height(250.dp)
    ) {
        AsyncImage(
            model = pais.bandeira.png,
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

    // Criação das opções de escolha
    var corCard by remember { mutableIntStateOf(R.color.azul1) }

    opcoesDeEscolha.forEach {
        Button(
            onClick = {
                if (it.capital[0] == opcaoCorreta) {
                    var proxIndex = jogoDaCapitalScreenViewModel.saberQualPaisesAtual(pais)
                    jogoDaCapitalScreenViewModel.removerPaisAleatorio(pais)
                    if (proxIndex + 1  > listaDePais.count()) {
                        navController.navigate("telaResultado")
                    }
                    if ( proxIndex <= listaDePais.count()) {
                        jogoDaCapitalScreenViewModel.adicionarPaisAleatorio(listaDePais[proxIndex])
                    }
                    jogoDaCapitalScreenViewModel.embaralharPaisesAleatorios()
                    jogoDaCapitalScreenViewModel.proximoPais()
                    jogoDaCapitalScreenViewModel.adicionarAcerto()
                    Log.i("FIAP", "acertos: ${acertos}")
                } else {
                    jogoDaCapitalScreenViewModel.adicionarErro()
                    Log.i("FIAP", "erros: ${erros}")
                }

            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = corCard))
        ) {
            Text(
                text = it.capital[0],
                fontSize = 32.sp
            )
        }
        Spacer(modifier = Modifier.height(6.dp))
    }
}