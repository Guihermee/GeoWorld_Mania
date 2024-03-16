package br.com.fiap.geoworldmania.opcoesDeContinente

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.geoworldmania.R
import br.com.fiap.geoworldmania.components.Header
import br.com.fiap.geoworldmania.components.OpcoesEscolhaCapital

@Composable
fun OpcoesDeContinenteScreen() {

    Box(modifier = Modifier.fillMaxSize()){
        Column {
            Header(textContent = "Capitais")
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                modifier = Modifier.padding(start = 24.dp),
                text = "Continentes",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.azul5)
            )
            OpcoesEscolhaCapital(
                texto1 = "America Central e do Sul",
                imagem = R.drawable.america_do_sul,
                colors = ButtonDefaults
                    .buttonColors(containerColor = colorResource(id = R.color.azul_claro))
            )
            OpcoesEscolhaCapital(
                texto1 = "America do Norte",
                imagem = R.drawable.america_norte,
                colors = ButtonDefaults
                    .buttonColors(containerColor = colorResource(id = R.color.roxo))
            )
            OpcoesEscolhaCapital(
                texto1 = "Asia",
                imagem = R.drawable.asia,
                colors = ButtonDefaults
                    .buttonColors(containerColor = colorResource(id = R.color.verde_claro))
            )
            OpcoesEscolhaCapital(
                texto1 = "Europa",
                imagem = R.drawable.europa,
                colors = ButtonDefaults
                    .buttonColors(containerColor = colorResource(id = R.color.amarelomarrom))
            )
            OpcoesEscolhaCapital(
                texto1 = "Oceania",
                imagem = R.drawable.oceania,
                colors = ButtonDefaults
                    .buttonColors(containerColor = colorResource(id = R.color.vermelho))
            )
            OpcoesEscolhaCapital(
                texto1 = "Todos os Paises",
                imagem = R.drawable.planeta,
                colors = ButtonDefaults
                    .buttonColors(containerColor = colorResource(id = R.color.azul_escuro))
            )
        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun OpcoesDeContinenteScreenPreview() {
    OpcoesDeContinenteScreen()
}