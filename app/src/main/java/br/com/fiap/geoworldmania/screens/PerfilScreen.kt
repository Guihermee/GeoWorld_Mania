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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.geoworldmania.R
import br.com.fiap.geoworldmania.repository.UsuarioRepository
import br.com.fiap.geoworldmania.viewModel.PerfilViewModel

@Composable
fun PerfilScreen(navController: NavController, perfilViewModel: PerfilViewModel) {

    val context = LocalContext.current
    val usuarioRepository = UsuarioRepository(context = context)

    val user by perfilViewModel.usuario.observeAsState(
        initial = usuarioRepository.buscarUsuarioPeloId(
            1
        )
    )

    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {

            // HEADER DIFERENCIADO
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = colorResource(id = R.color.azul1))
                    .height(70.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = { navController.navigate("telaInicial") },
                    modifier = Modifier.padding(start = 16.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.arrow_back_42),
                        contentDescription = "Icone de voltar",
                        tint = colorResource(id = R.color.azul5)
                    )
                }
                IconButton(
                    onClick = { /*navController.navigate("")TODO TELA DE CONFIG?*/ },
                    modifier = Modifier.padding(end = 16.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.settings_42),
                        contentDescription = "Icone das configurações",
                        tint = colorResource(id = R.color.azul5)
                    )
                }
            }

            // Imagem, nome e a descrição do nível da pessoa.
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .background(colorResource(id = R.color.azul1))
                    .offset(y = (-40).dp)
            ) {
                Image(
                    painter = painterResource(id = user.imagem),
                    contentDescription = "Imagem do Usuário",
                    modifier = Modifier
                        .size(200.dp)
                        .clip(shape = CircleShape),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = user.nome,
                    fontSize = 20.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 12.dp)
                )
                Text(
                    text = user.descricaoNivel,
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Light,
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 32.dp)
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxSize()
                        .offset(y = (-50).dp),
                    colors = CardDefaults.cardColors(colorResource(id = R.color.white)),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                fontSize = 20.sp,
                                text = "Erros totais",
                            )
                            Text(
                                fontSize = 30.sp,
                                text = "${user.erros}",
                                color = colorResource(id = R.color.azul5)
                            )
                        }
                        Column(
                            modifier = Modifier
                                .padding(16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                fontSize = 20.sp,
                                text = "Acertos totais",
                            )
                            Text(
                                fontSize = 30.sp,
                                text = "${user.acertos}",
                                color = colorResource(id = R.color.azul5)
                            )
                        }
                    }
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                fontSize = 20.sp,
                                text = "Nível Atual",
                            )
                            Text(
                                fontSize = 30.sp,
                                text = "${user.nivel}",
                                color = colorResource(id = R.color.azul5)
                            )
                        }

                    }
                }
            }
        }
    }
}
