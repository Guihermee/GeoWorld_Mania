package br.com.fiap.geoworldmania.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
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
import br.com.fiap.geoworldmania.R
import br.com.fiap.geoworldmania.model.Nivel


@Composable
fun OpcoesEscolhaNivel(
    texto1: String,
    imagem: Int,
    colors: ButtonColors,
    onClick: () -> Unit
) {
    Spacer(modifier = Modifier.height(8.dp))
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
            .height(60.dp),
        shape = RoundedCornerShape(4.dp),
        colors = colors,
    ) {
        Row(
            horizontalArrangement = Arrangement.Absolute.SpaceBetween,
            modifier = Modifier
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column{
                Text(
                    text = texto1,
                    fontWeight = FontWeight.Normal,
                    color = Color.White,
                    fontSize = 20.sp
                )
            }
            Image(painter = painterResource(id = imagem), contentDescription = "", Modifier.size(26.dp))
        }
    }
}


@Composable
fun OpcoesEscolhaNivelTest(nivel: Nivel) {
    Spacer(modifier = Modifier.height(8.dp))

    var corBotao = R.color.verde_claro

    // ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.verde_claro))
    if (nivel.dificuldade == 1) {
        corBotao  = R.color.verde_claro
    } else if (nivel.dificuldade == 2) {
        corBotao = R.color.azul_claro
    } else if (nivel.dificuldade == 3) {
        corBotao = R.color.vermelho
    }

    Button(
        onClick = nivel.onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
            .height(60.dp),
        shape = RoundedCornerShape(4.dp),
        colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = corBotao)),
    ) {
        Row(
            horizontalArrangement = Arrangement.Absolute.SpaceBetween,
            modifier = Modifier
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column{
                Text(
                    text = nivel.texto,
                    fontWeight = FontWeight.Normal,
                    color = Color.White,
                    fontSize = 20.sp
                )
            }
            Image(painter = painterResource(id = nivel.imagem), contentDescription = "", Modifier.size(26.dp))
        }
    }
}
