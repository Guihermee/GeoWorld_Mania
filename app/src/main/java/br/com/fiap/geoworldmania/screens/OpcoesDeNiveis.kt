package br.com.fiap.geoworldmania.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.geoworldmania.R
import br.com.fiap.geoworldmania.R.drawable.heart_filled_42_white
import br.com.fiap.geoworldmania.R.drawable.lightbulb_filled_42_white
import br.com.fiap.geoworldmania.components.Header
import br.com.fiap.geoworldmania.components.OpcoesEscolhaNivel

@Composable

fun OpcoesDeNiveisScreen (){
    Box(modifier = Modifier.fillMaxWidth()){
        Column() {
            Header(textContent = "")
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                modifier = Modifier.padding(start = 24.dp),
                text = "Níveis",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.azul5)
            )
            OpcoesEscolhaNivel(
                texto1 = "Nível 1: 10 Países",
                imagem = lightbulb_filled_42_white,
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.verde_claro)))


            OpcoesEscolhaNivel(
                texto1 = "Nivel 2: +10 Países",
                imagem = lightbulb_filled_42_white,
                onClick = {},
                colors =ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.verde_claro)) )

            OpcoesEscolhaNivel(
                texto1  = "Desafio: 20 Países",
                imagem = heart_filled_42_white,
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.azul_claro)) )

            OpcoesEscolhaNivel(
                texto1 = "Nivel 3: 10 Países",
                imagem = lightbulb_filled_42_white,
                onClick = {},
                colors =ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.verde_claro)) )

            OpcoesEscolhaNivel(
                texto1 = "Nivel 4: +10 Países",
                imagem = lightbulb_filled_42_white,
                onClick = {},
                colors =ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.verde_claro)) )

            OpcoesEscolhaNivel(
                texto1  = "Desafio: 40 Países",
                imagem = heart_filled_42_white,
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.azul_claro)) )

            OpcoesEscolhaNivel(
                texto1  = "Desafio Difícil: Todos os países",
                imagem = heart_filled_42_white,
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.vermelho)) )

        }

    }

}

@Preview (showBackground = true, showSystemUi = true)
@Composable
fun OpcoesDeNiveisScreenPreview (){
        OpcoesDeNiveisScreen()
}
