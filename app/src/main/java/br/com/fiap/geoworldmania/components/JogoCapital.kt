package br.com.fiap.geoworldmania.components

import androidx.compose.foundation.border
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.geoworldmania.R
import br.com.fiap.geoworldmania.model.ContinuaDeOndeParou
import br.com.fiap.geoworldmania.model.Pais
import br.com.fiap.geoworldmania.repository.ContinuarDeOndeParouRepository
import br.com.fiap.geoworldmania.viewModel.JogoDaCapitalScreenViewModel
import br.com.fiap.geoworldmania.viewModel.PerfilViewModel
import coil.compose.AsyncImage

@Composable
fun JogoCapital(
    pais: Pais,
    opcoesDeEscolha: List<Pais>,
    listaDePais: List<Pais>,
    listaDoContinente: List<Pais>,
    navController: NavController,
    jogoDaCapitalScreenViewModel: JogoDaCapitalScreenViewModel,
    perfilViewModel: PerfilViewModel,
    desafio: Boolean,
    continente: String,
    tituloJogo: String,
    tituloContinente: String,
    tituloNivel: String,
    jogoPais: Boolean,
    jogoBandeira: Boolean,
    continuaDeOndeParou: Boolean
) {
    // Criação das variáveis utilizadas no jogo.
    val opcaoCorreta = pais.capital[0]
    val opcaoCorretaPais = pais.nome.portugues.common
    val acertos by jogoDaCapitalScreenViewModel.acertos.observeAsState(initial = 0)
    val erros by jogoDaCapitalScreenViewModel.erros.observeAsState(initial = 0)
    val heart01 by jogoDaCapitalScreenViewModel.heart01.observeAsState(initial = true)
    val heart02 by jogoDaCapitalScreenViewModel.heart02.observeAsState(initial = true)
    val heart03 by jogoDaCapitalScreenViewModel.heart03.observeAsState(initial = true)
    val context = LocalContext.current

    // Atualizando o db do Continua se o Usuario sair no meio do jogo ele consegue voltar de onde parou pelo botão na tela inicial
    perfilViewModel.atualizarDbContinuaDeOndeParou(
        context = context,
        listaDePais = listaDePais,
        listaDoContinente = listaDoContinente,
        desafio = desafio,
        continente = continente,
        tituloJogo = tituloJogo,
        tituloContinente = tituloContinente,
        tituloNivel = tituloNivel,
        jogoPais = jogoPais,
        jogoBandeira = jogoBandeira,
        erros = erros,
        acertos = acertos,
        todos = continente == "all"
    )

    // Se for desafio é aplicado uma lógica para "perder" vidas e se errar 3 vezes é movido para tela de Resultado
    if (desafio) {
        Vidas(
            onClick = {}, heart01, heart02, heart03
        )
        if (erros == 1) {
            jogoDaCapitalScreenViewModel.onHeart03Change(false)
        } else if (erros == 2) {
            jogoDaCapitalScreenViewModel.onHeart02Change(false)
        } else if (erros == 3) {
            jogoDaCapitalScreenViewModel.onHeart01Change(false)
            navController.navigate("telaResultado?acertos=${acertos}?erros=${erros}?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}")
        }
    }

    // Titulo mostrando o nome do pais ou não (dependende do jogo)
    if (jogoPais && jogoBandeira) { // Esse é o Jogo da bandeira

    } else if (jogoPais && !jogoBandeira) { // Esse é o Jogo do Pais
        Text(
            text = pais.capital[0],
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 6.dp),
            textAlign = TextAlign.Center,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
    } else if (!jogoPais && !jogoBandeira) {// Esse é o Jogo da Capital
        Text(
            text = pais.nome.portugues.common,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 6.dp),
            textAlign = TextAlign.Center,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
    }

    // Imagem do País TODO Imagens das Cidades dos Paises.
    Column(
        modifier = Modifier.height(250.dp)
    ) {
        AsyncImage(
            model = pais.bandeira.png,
            contentDescription = "Bandeira do Pais",
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, end = 16.dp)
                .border(1.dp, color = Color.Black),
            contentScale = ContentScale.Crop
        )
    }

    Spacer(modifier = Modifier.height(16.dp))

    /*TODO*/
    // Com base em um dos três jogo possíveis, é escolhido um Texto apropriado (FAZER UM COMPONENTE?)
    if (jogoPais && jogoBandeira) { // Esse é o Jogo da bandeira
        Text(
            text = stringResource(id = R.string.qual_bandeira),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, bottom = 8.dp),
            textAlign = TextAlign.Start,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
    } else if (jogoPais && !jogoBandeira) { // Esse é o Jogo Pais
        Text(
            text = stringResource(id = R.string.qual_pais),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, bottom = 8.dp),
            textAlign = TextAlign.Start,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
    } else if (!jogoPais && !jogoBandeira) { // Esse é o Jogo Capital
        Text(
            text = stringResource(id = R.string.qual_capital),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, bottom = 8.dp),
            textAlign = TextAlign.Start,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
    }


    // Declaração das variáveis de estado das cores dos botões
    var corCard00 by remember { mutableIntStateOf(R.color.azul1) }
    var corCard01 by remember { mutableIntStateOf(R.color.azul1) }
    var corCard02 by remember { mutableIntStateOf(R.color.azul1) }
    var corCard03 by remember { mutableIntStateOf(R.color.azul1) }


    fun verificarSeAcertou(it: Pais, listadePais: List<Pais>, proxIndex: Int) {
        if (!jogoPais) {
            if (it.capital[0] == opcaoCorreta) {

                perfilViewModel.addAcertoDbContinuaDeOndeParou(context)
                perfilViewModel.addAcertoInDb(context)
                jogoDaCapitalScreenViewModel.adicionarAcerto()



                if (!continuaDeOndeParou){
                    jogoDaCapitalScreenViewModel.apagarListaPais()
                    // Essa função recebe o próximo Pais como parâmetro e exclui da listaDoContinente
                    // e adiciona 3 Paises
                    jogoDaCapitalScreenViewModel.encherPaisesAleatorios(
                        listaDoContinente,
                        listadePais,
                        proxIndex
                    )
                }


            } else {
                perfilViewModel.addErroDbContinuaDeOndeParou(context)
                perfilViewModel.addErroInDb(context)
                jogoDaCapitalScreenViewModel.adicionarErro()
            }
        } else {
            if (it.nome.portugues.common == opcaoCorretaPais) {

                perfilViewModel.addAcertoDbContinuaDeOndeParou(context)
                perfilViewModel.addAcertoInDb(context)
                jogoDaCapitalScreenViewModel.adicionarAcerto()

                if (!continuaDeOndeParou){
                    jogoDaCapitalScreenViewModel.apagarListaPais()
                    // Essa função recebe o próximo Pais como parâmetro e exclui da listaDoContinente
                    // e adiciona 3 Paises
                    jogoDaCapitalScreenViewModel.encherPaisesAleatorios(
                        listaDoContinente,
                        listadePais,
                        proxIndex
                    )
                }

            } else {
                perfilViewModel.addErroDbContinuaDeOndeParou(context)
                perfilViewModel.addErroInDb(context)
                jogoDaCapitalScreenViewModel.adicionarErro()
            }
        }
    }

    // Funções que muda as variavel de estado das opções para vermelho caso não for a opção correta
    fun verifica00(): Int {
        if (!jogoPais) {
            if (opcoesDeEscolha[0].capital[0] != opcaoCorreta) {
                corCard00 = R.color.vermelho
                return corCard00
            }
        } else {
            if (opcoesDeEscolha[0].nome.portugues.common != opcaoCorretaPais) {
                corCard00 = R.color.vermelho
                return corCard00
            }
        }

        return R.color.azul1
    }

    fun verifica01(): Int {
        if (!jogoPais) {
            if (opcoesDeEscolha[1].capital[0] != opcaoCorreta) {
                corCard01 = R.color.vermelho
                return corCard01
            }
        } else {
            if (opcoesDeEscolha[1].nome.portugues.common != opcaoCorretaPais) {
                corCard01 = R.color.vermelho
                return corCard01
            }
        }

        return R.color.azul1
    }

    fun verifica02(): Int {
        if (!jogoPais) {
            if (opcoesDeEscolha[2].capital[0] != opcaoCorreta) {
                corCard02 = R.color.vermelho
                return corCard02
            }
        } else {
            if (opcoesDeEscolha[2].nome.portugues.common != opcaoCorretaPais) {
                corCard02 = R.color.vermelho
                return corCard02
            }
        }

        return R.color.azul1
    }

    fun verifica03(): Int {
        if (!jogoPais) {
            if (opcoesDeEscolha[3].capital[0] != opcaoCorreta) {
                corCard03 = R.color.vermelho
                return corCard03
            }
        } else {
            if (opcoesDeEscolha[3].nome.portugues.common != opcaoCorretaPais) {
                corCard03 = R.color.vermelho
                return corCard03
            }
        }

        return R.color.azul1
    }

    @Composable
    fun botao(pais: Pais, corCard: Int) {
        Button(
            onClick = {
                var proxIndex = jogoDaCapitalScreenViewModel.saberQualProxPais(pais, listaDePais)

                // Aqui é verificado se o botão clicaco (pais) é igual o botão 1,2,3,4 e
                // mudando a cor do botão clicado
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

                verificarSeAcertou(pais, listaDePais, proxIndex)

                // Continua a verificar se o usário clicou na opção correta e adiciona o próx pais na lista totalizando 4 paises
                if (!jogoPais) { // Esse é o jogo da capital
                    if (pais.capital[0] == opcaoCorreta) {

                        // Verificação se acabou a lista para ir pra tela de resultado
                        if (proxIndex + 1 > listaDePais.count()) {
                            proxIndex -= 1
                            jogoDaCapitalScreenViewModel.adicionarPaisCorreto(listaDePais[proxIndex])

                            // Alterando o banco de dados de niveis do usuario ao concluir o nível
                            perfilViewModel.onNiveisCapitaisChanged(context, continente, tituloNivel)

                            // resetando db ContinuaDeOndeParou para não haver conflitos (pois usuario finalizou o nível)
                            perfilViewModel.resetadbContinuaDeOndeParou(context)

                            // Indo para tela de resultado
                            return@Button navController.navigate("telaResultado?acertos=${acertos}?erros=${erros}?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}")
                        }

                        // Se não for pra tela de resultado aqui é adicionado o Proximo País na lista e
                        // embaralha ela para a próxima pergunta
                        if (proxIndex <= listaDePais.count()) {
                            if (!continuaDeOndeParou) {
                                jogoDaCapitalScreenViewModel.adicionarPaisCorreto(listaDePais[proxIndex])
                                jogoDaCapitalScreenViewModel.embaralharPaisesAleatorios()
                            }
                        }

                        perfilViewModel.atualizarListaDePaisesDbContinuaOndeParou(context, listaDePais, pais)
                        jogoDaCapitalScreenViewModel.proximoPais()// Adiciona +1 no i do FOR do jogoDaCapitalScreen
                    }
                } else {
                    if (pais.nome.portugues.common == opcaoCorretaPais) { // Esse é o jogo de acertar pais ou bandeira

                        // Verificação se acabou a lista para ir pra tela de resultado
                        if (proxIndex + 1 > listaDePais.count()) {
                            proxIndex -= 1
                            jogoDaCapitalScreenViewModel.adicionarPaisCorreto(listaDePais[proxIndex])

                            // Alterando o banco de dados de niveis do usuario ao concluir o nível
                            if (jogoPais && !jogoBandeira) { // esse é o jogo do pais
                                perfilViewModel.onNiveisPaisesChanged(context, continente, tituloNivel)
                            } else { // esse é o jogo da bandeira
                                perfilViewModel.onNiveisBandeirasChanged(context, continente, tituloNivel)
                            }

                            // resetando db ContinuaDeOndeParou para não haver conflitos (pois usuario finalizou o nível)
                            perfilViewModel.resetadbContinuaDeOndeParou(context)

                            // Indo para tela de resultado
                            return@Button navController.navigate("telaResultado?acertos=${acertos}?erros=${erros}?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}")
                        }

                        // Se não for pra tela de resultado aqui é adicionado o Proximo País na lista e
                        // embaralha ela para a próxima pergunta
                        if (proxIndex <= listaDePais.count()) {
                            if (!continuaDeOndeParou) {
                                jogoDaCapitalScreenViewModel.adicionarPaisCorreto(listaDePais[proxIndex])
                                jogoDaCapitalScreenViewModel.embaralharPaisesAleatorios()
                            }
                        }

                        perfilViewModel.atualizarListaDePaisesDbContinuaOndeParou(context, listaDePais, pais)
                        jogoDaCapitalScreenViewModel.proximoPais()// Adiciona +1 no i do FOR do jogoDaCapitalScreen
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = corCard))
        ) {
            if (!jogoPais) { // Se for o jogo da Capital
                Text(
                    text = pais.capital[0],
                    fontSize = 32.sp
                )
            } else {
                Text( // Se for o Jogo Pais ou
                    text = pais.nome.portugues.common,
                    fontSize = 32.sp
                )
            }
        }
        Spacer(modifier = Modifier.height(6.dp))
    }

    // Opções de escolhas
    botao(pais = opcoesDeEscolha[0], corCard00)
    botao(pais = opcoesDeEscolha[1], corCard01)
    botao(pais = opcoesDeEscolha[2], corCard02)
    botao(pais = opcoesDeEscolha[3], corCard03)
}