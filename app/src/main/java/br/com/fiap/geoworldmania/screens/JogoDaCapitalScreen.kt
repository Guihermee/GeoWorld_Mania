package br.com.fiap.geoworldmania.screens


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import br.com.fiap.geoworldmania.R
import br.com.fiap.geoworldmania.components.Ajuda
import br.com.fiap.geoworldmania.components.Header
import br.com.fiap.geoworldmania.components.JogoCapital
import br.com.fiap.geoworldmania.model.Pais
import br.com.fiap.geoworldmania.repository.ContinuarDeOndeParouRepository
import br.com.fiap.geoworldmania.repository.getAllPaises
import br.com.fiap.geoworldmania.repository.getPaisByContinente
import br.com.fiap.geoworldmania.viewModel.JogoDaCapitalScreenViewModel
import br.com.fiap.geoworldmania.viewModel.PerfilViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun JogoDaCapitalScreen(
    jogoDaCapitalScreenViewModel: JogoDaCapitalScreenViewModel,
    perfilViewModel: PerfilViewModel,
    navController: NavController,
    continente: String,
    indexNivelComeca: Int,
    indexNivelTermina: Int,
    tituloJogo: String,
    tituloContinente: String,
    tituloNivel: String,
    desafio: Boolean,
    todos: Boolean,
    jogoPais: Boolean,
    jogoBandeira: Boolean,
    continuaOndeParou: Boolean
) {
    Column {
        val coroutineScope = rememberCoroutineScope()

        // Definição e inicialização das variáveis de estado utilizadas para iniciar o jogo
        val listaPaisAleatoriosState by jogoDaCapitalScreenViewModel
            .listaPaisAleatorioState.observeAsState(initial = listOf())
        val nivelAtual by jogoDaCapitalScreenViewModel.nivel01.observeAsState(initial = listOf())
        val indexAtual by jogoDaCapitalScreenViewModel.indexAtual.observeAsState(initial = 0)
        val listaDeContinente by jogoDaCapitalScreenViewModel.listaDeContinente.observeAsState(
            initial = listOf()
        )
        val iniciarJogo by jogoDaCapitalScreenViewModel.iniciarJogo.observeAsState(initial = true)
        var isDialog by remember { mutableStateOf(false) }

        val context = LocalContext.current

        // Chamada do componente Header
        Header(
            textContent = "$tituloJogo - $tituloContinente - $tituloNivel",
            onClickVoltar = { navController.navigate("opcoesDeNiveis?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}") }
        )

        // Verifica se é um desafio (Desafios tem vida e não tem dicas, caso ao contrario só dicas)
        if (!desafio) {
            Ajuda(onClick = { isDialog = true })
        }

        // Botão de Dica TODO Dicas para os jogos Bandeira/Pais
        if (isDialog) {
            Dialog(onDismissRequest = { isDialog = false }, DialogProperties()) {
                var letra by remember { mutableStateOf("") }

                // Recuperação da letra da Capital
                for (i in nivelAtual.indices) {
                    if (i == indexAtual) {
                        letra = nivelAtual[i].capital[0].first().toString()
                    }
                }

                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Card(
                        modifier = Modifier
                            .height(150.dp)
                            .width(300.dp),
                        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.azul4)),
                        elevation = CardDefaults.cardElevation(6.dp),
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxSize()
                                .fillMaxWidth()
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(
                                    text = "A Primeira letra é $letra",
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White,
                                    fontSize = 25.sp
                                )
                                Button(
                                    onClick = { isDialog = false },
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = colorResource(
                                            id = R.color.azul4
                                        )
                                    ),
                                    modifier = Modifier.padding(top = 30.dp)
                                ) {
                                    Text(
                                        text = "Sair",
                                        fontSize = 25.sp,
                                        modifier = Modifier.padding(start = 150.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }







        Column {

            LaunchedEffect(indexAtual) {

                if (continuaOndeParou) {

                    val continuarDeOndeParouRepository = ContinuarDeOndeParouRepository(context)
                    val continuaDeOndeParou = continuarDeOndeParouRepository.listarContinuaDeOndeParouById(1)

                    val resp = continuaDeOndeParou.listaDoContinente
                    val nivelAtual = continuaDeOndeParou.listaDePais

                    jogoDaCapitalScreenViewModel.encherPaisesAleatorios(resp, nivelAtual, proxIndex = 0)
                    jogoDaCapitalScreenViewModel.adicionarPaisCorreto(nivelAtual[indexAtual])
                    jogoDaCapitalScreenViewModel.embaralharPaisesAleatorios()
                    jogoDaCapitalScreenViewModel.onNivel01Change(nivelAtual)
                    jogoDaCapitalScreenViewModel.onListaDeContinenteStateChange(resp)
                    jogoDaCapitalScreenViewModel.onIniciarJogoChange(false)

                } else {
                    // Preenchendo as Listas com os Paises necessários mas antes se verifica se é todos, pois a função muda.
                    if (iniciarJogo && continente != "all") {
                        val resp = getPaisByContinente(continente)
                        val nivelAtual = resp.subList(indexNivelComeca, indexNivelTermina).shuffled()


                        jogoDaCapitalScreenViewModel.encherPaisesAleatorios(resp, nivelAtual, proxIndex = 0)
                        jogoDaCapitalScreenViewModel.adicionarPaisCorreto(nivelAtual[0])
                        jogoDaCapitalScreenViewModel.embaralharPaisesAleatorios()
                        jogoDaCapitalScreenViewModel.onNivel01Change(nivelAtual)
                        jogoDaCapitalScreenViewModel.onListaDeContinenteStateChange(resp)
                        jogoDaCapitalScreenViewModel.onIniciarJogoChange(false)

                    }
                    if (iniciarJogo && todos) {
                        val resp =
                            getAllPaises() // Tudo igual o IF de cima, mas com uma função que retorna todos os Paises
                        val nivelAtual = resp.subList(indexNivelComeca, indexNivelTermina).shuffled()

                        jogoDaCapitalScreenViewModel.encherPaisesAleatorios(resp, nivelAtual, proxIndex = 0)
                        jogoDaCapitalScreenViewModel.adicionarPaisCorreto(nivelAtual[0])
                        jogoDaCapitalScreenViewModel.embaralharPaisesAleatorios()
                        jogoDaCapitalScreenViewModel.onNivel01Change(nivelAtual)
                        jogoDaCapitalScreenViewModel.onListaDeContinenteStateChange(resp)
                        jogoDaCapitalScreenViewModel.onIniciarJogoChange(false)
                    }
                }

                delay(1000)

            }

            // Construção do Jogo, percorrendo uma lista de paises de um continente
            for (i in nivelAtual.indices) {



                if (i == indexAtual) {
                    JogoCapital( // Componente que Cria o jogo e manda as Info
                        pais = nivelAtual[i], // Lista com o Pais sendo utilizado pelo FOR
                        opcoesDeEscolha = listaPaisAleatoriosState, // Lista com 3 aleatorios e um Correto
                        listaDePais = nivelAtual, // Lista com todos paises do Nível atual
                        listaDoContinente = listaDeContinente, // Todos Paises do Continente
                        navController = navController,
                        jogoDaCapitalScreenViewModel = jogoDaCapitalScreenViewModel,
                        perfilViewModel = perfilViewModel,
                        desafio = desafio, // Boolean para saber se é um desafio ou não
                        continente = continente, // String do nome do continente (preenchimento do header)
                        tituloJogo = tituloJogo,  // String do titulo do jogo Atual (preenchimento do header)
                        tituloContinente = tituloContinente,  // String do nome do Continente Atual
                        tituloNivel = tituloNivel, // String do titulo nivel (no shit)
                        jogoPais = jogoPais, // Boolean para saber se é o Jogo de adivinhar o País
                        jogoBandeira = jogoBandeira, // Boolean para saber se é o jogo de Adivinhar Bandeiras
                        continuaDeOndeParou = continuaOndeParou
                    )
                }
            }

        }
    }
}