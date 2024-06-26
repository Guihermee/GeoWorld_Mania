package br.com.fiap.geoworldmania.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.geoworldmania.R

@Composable
fun TelaResultadoScreen(
    navController: NavController,
    acertos: Int,
    erros: Int,
    continente: String,
    tituloJogo: String,
    tituloContinente: String,
    jogoPais: Boolean,
    jogoBandeira: Boolean
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.azul6))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            //-----Parabéns-----
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
            ) {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Parabéns!",
                    fontSize = 60.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = colorResource(id = R.color.azul5)
                )
            }
            //-----Card Acertos e erros
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(400.dp)
                        .offset(y = (-30).dp),
                    colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.azul6)),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(
                            vertical = 16.dp,
                            horizontal = 32.dp
                        )
                    ) {
                        Text(
                            text = "Acertos",
                            modifier = Modifier.fillMaxWidth(),
                            fontSize = 48.sp,
                            fontWeight = FontWeight.Bold,
                            color = colorResource(id = R.color.azul5),
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "$acertos",
                            modifier = Modifier.fillMaxWidth(),
                            fontSize = 60.sp,
                            fontWeight = FontWeight.Bold,
                            color = colorResource(id = R.color.azul5),
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "Erros",
                            modifier = Modifier.fillMaxWidth(),
                            fontSize = 48.sp,
                            fontWeight = FontWeight.Bold,
                            color = colorResource(id = R.color.azul5),
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "$erros",
                            modifier = Modifier.fillMaxWidth(),
                            fontSize = 60.sp,
                            fontWeight = FontWeight.Bold,
                            color = colorResource(id = R.color.azul5),
                            textAlign = TextAlign.Center
                        )
                    }
                }
                //----Botões
//                Spacer(modifier = Modifier.height(36.dp))
//                Button(
//                    onClick = {},
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .height(48.dp),
//                    shape = RoundedCornerShape(16.dp),
//                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.azul1))
//                ) {
//                    Text(
//                        text = "Próximo Nível",
//                        fontWeight = FontWeight.Bold,
//                        color = Color.White,
//                        fontSize = 14.sp
//                    )
//                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = { navController.navigate("opcoesDeNiveis?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.azul1))
                ) {
                    Text(
                        text = "Voltar aos Níveis",
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        fontSize = 14.sp
                    )
                }
            }
        }
    }
}

