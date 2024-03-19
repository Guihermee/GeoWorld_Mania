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
    listaDoContinente: List<Pais>,
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
                    //Variavel para saber qual é o index do proximo pais do Nivel.
                    var proxIndex = jogoDaCapitalScreenViewModel.saberQualPaisesAtual(pais, listaDePais)
                    // Adiciona +1 na variável acertos
                    jogoDaCapitalScreenViewModel.adicionarAcerto()
                    /*Se Usuario escolher opção correta a lista opcoesDeEscolha será limpada e
                     preenchida com outros 3 paises aleatorios da API*/
                    jogoDaCapitalScreenViewModel.apagarPaisesAleatorios()
                    jogoDaCapitalScreenViewModel.encherPaisesAleatorios(listaDoContinente)

                    /*Se o proximo indice for maior que a Lista dos paises do nivel atual vai pra
                    tela de resultado*/
                    if (proxIndex + 1  > listaDePais.count()) {
                        return@Button navController.navigate("telaResultado?acertos=${acertos}?erros=${erros}")
                    }
                    /*Se o proximo index for menor do que a lista ele vai adicionar o proximo Pais
                     da lista do nivel totalizando 4 paises naquela lista aleatoria*/
                    if ( proxIndex <= listaDePais.count()) {
                        jogoDaCapitalScreenViewModel.adicionarPaisAleatorio(listaDePais[proxIndex])
                    }

                    /*Aqui ele embaralha os paises, porque quando adicionamos ela foi pro final
                    da lista, embralhando garatimos a aleatoriedade*/
                    jogoDaCapitalScreenViewModel.embaralharPaisesAleatorios()

                    /*Adicionamos 1 na contagem do For que está sendo chamado lá no
                    JogoDaCapitalScreen passando assim pro proximo pais*/
                    jogoDaCapitalScreenViewModel.proximoPais()


                } else {
                    // Adiciona +1 na variável erros
                    jogoDaCapitalScreenViewModel.adicionarErro()

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