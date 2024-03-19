package br.com.fiap.geoworldmania.components

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
import br.com.fiap.geoworldmania.model.Pais
import br.com.fiap.geoworldmania.viewModel.JogoDaCapitalScreenViewModel
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

    val opcaoCorreta = pais.capital[0]
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

    // Declaração das variáveis de estado das cores dos botões
    var corCard00 by remember { mutableIntStateOf(R.color.azul1) }
    var corCard01 by remember { mutableIntStateOf(R.color.azul1) }
    var corCard02 by remember { mutableIntStateOf(R.color.azul1) }
    var corCard03 by remember { mutableIntStateOf(R.color.azul1) }

    // Essa função verifica se o Usuário acertou e apaga a lista de opções e adiciona 3 aleatorios
    fun verificarSeAcertou(it: Pais) {
        if (it.capital[0] == opcaoCorreta) {

            // Adiciona +1 na variável acertos
            jogoDaCapitalScreenViewModel.adicionarAcerto()

            /*Se Usuario escolher opção correta a lista opcoesDeEscolha será limpada e
             preenchida com outros 3 paises aleatorios da API*/
            jogoDaCapitalScreenViewModel.apagarPaisesAleatorios()
            jogoDaCapitalScreenViewModel.encherPaisesAleatorios(listaDoContinente)

        } else {

            // Adiciona +1 na variável erros
            jogoDaCapitalScreenViewModel.adicionarErro()

        }
    }

    // Funções que muda as variavel de estado para vermelho
    fun verifica00(): Int {
        if (opcoesDeEscolha[0].capital[0] != opcaoCorreta){
            corCard00 = R.color.vermelho
            return corCard00
        }

        return R.color.azul1
    }

    fun verifica01(): Int {
        if (opcoesDeEscolha[1].capital[0] != opcaoCorreta){
            corCard01 = R.color.vermelho
            return corCard01
        }

        return R.color.azul1
    }

    fun verifica02(): Int {
        if (opcoesDeEscolha[2].capital[0] != opcaoCorreta){
            corCard02 = R.color.vermelho
            return corCard02
        }

        return R.color.azul1
    }

    fun verifica03(): Int {
        if (opcoesDeEscolha[3].capital[0] != opcaoCorreta){
            corCard03 = R.color.vermelho
            return corCard03
        }

        return R.color.azul1
    }

    @Composable
    fun botao(pais: Pais, corCard: Int) {
        Button(
            onClick = {

                // Aqui é verificado se o botão clicaco (pais) é igual o botão 1,2,3,4 e
                // mudando a cor do botão correspondente
                when (pais) {
                    opcoesDeEscolha[0] -> {
                        verifica00()
                    }
                    opcoesDeEscolha[1] -> {
                        verifica01()
                    }
                    opcoesDeEscolha[2] -> {
                        verifica02()
                    }
                    opcoesDeEscolha[3] -> {
                        verifica03()
                    }
                }

                verificarSeAcertou(pais)

                // Continua a verificar se o usário clicou na opção correta e adiciona o próx pais na lista totalizando 4 paises
                if(pais.capital[0] == opcaoCorreta) {
                    //Variavel para saber qual é o index do proximo pais do Nivel.
                    var proxIndex =
                        jogoDaCapitalScreenViewModel.saberQualPaisesAtual(pais, listaDePais)

                    // Verificação se acabou a lista para ir pra tela de resultado
                    if (proxIndex + 1 > listaDePais.count()) {
                        proxIndex -= 1
                        jogoDaCapitalScreenViewModel.adicionarPaisAleatorio(listaDePais[proxIndex])
                        return@Button navController.navigate("telaResultado?acertos=${acertos}?erros=${erros}")
                    }

                    // Se não for pra tela de resultado aqui é adicionado o País na lista e
                    // embaralha ela para a próxima pergunta
                    if (proxIndex <= listaDePais.count()) {
                        jogoDaCapitalScreenViewModel.adicionarPaisAleatorio(listaDePais[proxIndex])
                        jogoDaCapitalScreenViewModel.embaralharPaisesAleatorios()

                    }

                    // Adiciona +1 no i do for do jogoDaCapitalScreen
                    jogoDaCapitalScreenViewModel.proximoPais()
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = corCard))
        ) {
            Text(
                text = pais.capital[0],
                fontSize = 32.sp
            )
        }
        Spacer(modifier = Modifier.height(6.dp))
    }

    // Opções de escolhas
    botao(pais = opcoesDeEscolha[0], corCard00)
    botao(pais = opcoesDeEscolha[1], corCard01)
    botao(pais = opcoesDeEscolha[2], corCard02)
    botao(pais = opcoesDeEscolha[3], corCard03)

}