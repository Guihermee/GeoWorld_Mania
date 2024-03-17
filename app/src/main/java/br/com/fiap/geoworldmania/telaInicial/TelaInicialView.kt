package br.com.fiap.geoworldmania.telaInicial

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.geoworldmania.R
import br.com.fiap.geoworldmania.components.TiposJogosButton

@Composable
fun TelaInicial(telaInicialViewModel: TelaInicialViewModel,navController: NavController){

    Box(
        modifier = Modifier.padding(16.dp),
    ){
        Column{
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth()

            ){
                Text(
                    text = "Bem-vindo de volta Ana!",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.azul5),
                    modifier = Modifier
                        .height(50.dp)
                        .padding(top = 10.dp, end = 90.dp),
                )
                Image(
                    painter = painterResource(id = R.drawable.user),
                    contentDescription = "Foto Usuário",
                    Modifier.size(50.dp)
                )
            }
            Column (horizontalAlignment = Alignment.CenterHorizontally){
                Button(
                    onClick = {  },
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.azul3))
                ) {
                    Text(text = "Continuar de onde parou", color = Color.Black)
                    Image(
                        painter = painterResource(id = R.drawable.arrow_forward_ios_24),
                        contentDescription = "Foto Usuário",
                        Modifier.size(40.dp)
                    )
                }
            }
            Column(
                modifier = Modifier.fillMaxWidth()
            ){
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .height(100.dp)
                        .fillMaxWidth()

                ){
                    Text(
                        text = "Tipos de jogos!",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.azul5),
                        modifier = Modifier
                            .height(50.dp)
                            .padding(top = 10.dp, end = 90.dp),
                    )
                }
                TiposJogosButton(texto1 = "Capitais do Mundo", imagem = R.drawable.planeta,  colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.vermelho)))
                TiposJogosButton(texto1 = "Bandeiras", imagem = R.drawable.planeta,  colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.azul_claro)))
                TiposJogosButton(texto1 = "Países", imagem = R.drawable.planeta,  colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.verde_claro)))
            }
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
            ){
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .height(100.dp)
                        .fillMaxWidth()

                ){
                    Text(
                        text = "Consultas!",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.azul5),
                        modifier = Modifier
                            .height(50.dp)
                            .padding(top = 10.dp, end = 90.dp),
                    )
                }
                TiposJogosButton(texto1 = "Todas as Capitais", imagem = R.drawable.planeta,  colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.amarelomarrom)))
                TiposJogosButton(texto1 = "Todas as bandeira", imagem = R.drawable.planeta,  colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.azul_escuro)))
            }

        }
    }
}
