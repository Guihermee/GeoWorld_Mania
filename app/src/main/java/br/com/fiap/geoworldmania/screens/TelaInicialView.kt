package br.com.fiap.geoworldmania.screens

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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

@Composable
fun TelaInicial(navController: NavController) {

    Box(
        modifier = Modifier.padding(16.dp),
    ) {
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth()

            ) {
                // Titulo principal
                Text(
                    text = "Bem-vinda de volta Ana!",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.azul5),
                    modifier = Modifier
                        .height(50.dp)
                        .padding(top = 10.dp, end = 60.dp),
                )
                // Ícone com a foto do usuário
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(45.dp, 45.dp)
                        .clip(shape = CircleShape)
                ) {
                    IconButton(onClick = { /*TODO Perfil do usuário*/ }) {
                        Image(
                            painter = painterResource(id = R.drawable.ana),
                            contentDescription = "Conta logada",
                            contentScale = ContentScale.Crop
                        )
                    }
                }
            }

            // Botão para Continuar de onde parou (provavelmente não será feito)
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Button(
                    onClick = { /*TODO Continuar de onde parou*/ },
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
                                color = Color.Black,
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
                    texto1 = "Capitais do Mundo",
                    imagem = R.drawable.planeta,
                    onClick = { navController.navigate("opcoesDeContinente?tituloJogo=Capitais?jogoPais=false?jogoBandeira=false") },
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.vermelho))
                )
                TiposJogosButton(
                    texto1 = "Bandeiras",
                    imagem = R.drawable.bandeira,
                    onClick = { navController.navigate("opcoesDeContinente?tituloJogo=Bandeiras?jogoPais=true?jogoBandeira=true") },
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.azul_claro))
                )
                TiposJogosButton(
                    texto1 = "Países",
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
                    onClick = {/*TODO Consulta Bandeiras*/ },
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.azul_escuro))
                )
            }
        }
    }

    Box(
        contentAlignment = Alignment.BottomCenter, modifier = Modifier.fillMaxWidth()
    ) { FooterTelaInicial() }
}
