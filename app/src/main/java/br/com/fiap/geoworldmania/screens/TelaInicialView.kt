package br.com.fiap.geoworldmania.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.geoworldmania.R
import br.com.fiap.geoworldmania.components.ConsultaButton
import br.com.fiap.geoworldmania.components.FooterTelaInicial
import br.com.fiap.geoworldmania.components.TiposJogosButton
import br.com.fiap.geoworldmania.model.ContinuaDeOndeParou
import br.com.fiap.geoworldmania.model.NiveisBandeiras
import br.com.fiap.geoworldmania.model.NiveisCapitais
import br.com.fiap.geoworldmania.model.NiveisPaises
import br.com.fiap.geoworldmania.model.Usuario
import br.com.fiap.geoworldmania.repository.ContinuarDeOndeParouRepository
import br.com.fiap.geoworldmania.repository.NiveisBandeirasRepository
import br.com.fiap.geoworldmania.repository.NiveisCapitaisRepository
import br.com.fiap.geoworldmania.repository.NiveisPaisesRepository
import br.com.fiap.geoworldmania.repository.UsuarioRepository

@Composable
fun TelaInicial(navController: NavController) {

    val context = LocalContext.current

    val usuarioRepository = UsuarioRepository(context = context)
    val niveisCapitaisRepository = NiveisCapitaisRepository(context = context)
    val niveisBandeirasRepository = NiveisBandeirasRepository(context = context)
    val niveisPaisesRepository = NiveisPaisesRepository(context = context)
    val continuarDeOndeParouRepository = ContinuarDeOndeParouRepository(context)

    val listaDeUsuario = usuarioRepository.listarUsuario()
    val listaDeNiveisCapitais = niveisCapitaisRepository.listarNiveisCapitais()
    val listadeNiveisBandeiras = niveisBandeirasRepository.listarNiveisBandeiras()
    val listadeNiveisPaises = niveisPaisesRepository.listarNiveisPaises()
    val listaContinuaDeOndeParou = continuarDeOndeParouRepository.listarContinuaDeOndeParou()

    if (listaDeUsuario.isEmpty()) {
        var usuario = Usuario()
        usuarioRepository.db.salvar(usuario)
    }

    if (listaDeNiveisCapitais.isEmpty()) {
        var niveisCapitais = NiveisCapitais()
        niveisCapitaisRepository.salvar(niveisCapitais)
    }

    if (listadeNiveisBandeiras.isEmpty()) {
        var nivelBandeiras = NiveisBandeiras()
        niveisBandeirasRepository.salvar(nivelBandeiras)
    }

    if (listadeNiveisPaises.isEmpty()) {
        val niveisPaises = NiveisPaises()
        niveisPaisesRepository.salvar(niveisPaises)
    }

    if (listaContinuaDeOndeParou.isEmpty()) {
        val continuaDeOndeParou = ContinuaDeOndeParou()
        continuarDeOndeParouRepository.db.salvarContinua(continuaDeOndeParou)
    }

    val usuario = usuarioRepository.buscarUsuarioPeloId(1)


    Box(
        modifier = Modifier
            .padding(16.dp)
            .background(Color.White)
    ) {
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth()
                    .padding(end = 14.dp)

            ) {
                // Titulo principal
                Text(
                    text = "Bem-vindo ${usuario.nome}!",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.azul5),
                    modifier = Modifier
                        .height(50.dp)
                        .padding(top = 10.dp, end = 30.dp),
                )
                // Ícone com a foto do usuário
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(45.dp, 45.dp)
                        .clip(shape = CircleShape)
                ) {
                    IconButton(onClick = { navController.navigate("perfilScreen") }) {
                        Image(
                            painter = painterResource(id = usuario.imagem),
                            contentDescription = "Conta logada",
                            contentScale = ContentScale.Crop
                        )
                    }
                }
            }

            // Botão para Continuar de onde parou (provavelmente não será feito)
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = {
                        val continuaDeOndeParou = continuarDeOndeParouRepository.db.listarContinuaDeOndeParouById(1)

                        // verificar se pode ou não iniciar por aqui criar uma coluna para fazer essa verificação?
                        if (continuaDeOndeParou.podeUsar) {
                            navController.navigate("jogoDaCapital?indexNivelComeca=0?indexNivelTermina=0?continente=${continuaDeOndeParou.continente}?tituloJogo=${continuaDeOndeParou.tituloJogo}?tituloContinente=${continuaDeOndeParou.tituloContinente}?tituloNivel=${continuaDeOndeParou.tituloNivel}?desafio=${continuaDeOndeParou.desafio}?todos=${continuaDeOndeParou.todos}?jogoPais=${continuaDeOndeParou.jogoPais}?jogoBandeira=${continuaDeOndeParou.jogoBandeira}?continuaOndeParou=tr ue")
                        }
                    },
                    modifier = Modifier
                        .padding(horizontal = 30.dp)
                        .height(70.dp)
                        .width(300.dp),
                    shape = RoundedCornerShape(6.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.azul3))
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Absolute.SpaceBetween,
                        modifier = Modifier
                            .fillMaxSize()
                            .fillMaxWidth()
                    ) {
                        Column {
                            Text(
                                text = "Continuar de onde parou",
                                color = colorResource(id = R.color.white),
                                fontSize = 20.sp,
                                modifier = Modifier.padding(top = 13.dp)
                            )
                        }
                        Image(
                            painter = painterResource(id = R.drawable.arrow_forward_ios_24),
                            contentDescription = "Seta pra direita",
                            modifier = Modifier
                                .padding(top = 7.dp)
                                .height(100.dp)
                                .offset(y = (-3).dp)

                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(13.dp))

            // Lista com os tipos de jogos que temos disponiveis
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .height(50.dp)
                        .fillMaxWidth()

                ) {
                    Text(
                        text = "Tipos de jogos",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.azul5),
                        modifier = Modifier
                            .height(50.dp)
                            .padding(top = 10.dp),
                    )
                }
                // Chamada dos componentes com suas respectivas informações e navegações
                TiposJogosButton(
                    texto1 = "Descubra as Capitais",
                    imagem = R.drawable.planeta,
                    onClick = { navController.navigate("opcoesDeContinente?tituloJogo=Capitais?jogoPais=false?jogoBandeira=false") },
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.vermelho))
                )
                TiposJogosButton(
                    texto1 = "Descubra as Bandeiras",
                    imagem = R.drawable.bandeira,
                    onClick = { navController.navigate("opcoesDeContinente?tituloJogo=Bandeiras?jogoPais=true?jogoBandeira=true") },
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.azul_claro))
                )
                TiposJogosButton(
                    texto1 = "Descubra os Países",
                    imagem = R.drawable.paises,
                    onClick = { navController.navigate("opcoesDeContinente?tituloJogo=Países?jogoPais=true?jogoBandeira=false") },
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.verde_claro))
                )
            }

            Spacer(modifier = Modifier.height(25.dp))

            // Lista de Consultas para estudo do usuário
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .height(50.dp)
                        .fillMaxWidth()

                ) {
                    // Texto do Titulo das Consultas
                    Text(
                        text = "Consultas",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.azul5),
                        modifier = Modifier
                            .height(50.dp)
                            .padding(top = 10.dp),
                    )
                }
                // Chamada dos componentes de consulta
                ConsultaButton(
                    texto1 = "Todas as Capitais",
                    imagem = R.drawable.todascapitais,
                    onClick = { navController.navigate("consultaCapitaisScreen?tituloJogo=Consultar Capitais") },
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.amarelomarrom))
                )
                ConsultaButton(
                    texto1 = "Todas as bandeira",
                    imagem = R.drawable.todasbandeiras,
                    onClick = { navController.navigate("consultaBandeirasScreen?tituloJogo=Consultar Bandeiras") },
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.azul_escuro))
                )
            }
        }
    }

    Box(
        contentAlignment = Alignment.BottomCenter, modifier = Modifier.fillMaxWidth()
    ) { FooterTelaInicial() }
}
