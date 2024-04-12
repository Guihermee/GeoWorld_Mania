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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.geoworldmania.R
import br.com.fiap.geoworldmania.model.Continente


@Composable
fun OpcoesEscolhaCapital(continente: Continente) { // Continente é uma DataClass
    Spacer(modifier = Modifier.height(4.dp))

    // Componente inteiro é um botão clicavél
    Button(
        onClick = continente.onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .height(72.dp),
        shape = RoundedCornerShape(4.dp),
        colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = continente.cor)),
    ) {
        // Preenchendo os valores e estilização em uma Row
       Row(
           horizontalArrangement = Arrangement.Absolute.SpaceBetween,
           modifier = Modifier
               .fillMaxSize()
       ) {
           Column{
               // Titulo do Card clicavel
               Text(
                   text = continente.texto,
                   fontWeight = FontWeight.Bold,
                   color = Color.White,
                   fontSize = 20.sp
               )
               Spacer(modifier = Modifier.height(10.dp))
               Text(
                   text = "Níveis concluidos 0/${continente.qtdNivel}", // TODO Níveis concluidos
                   fontWeight = FontWeight.Normal,
                   color = Color.White,
                   fontSize = 12.sp
               )
           }
           // Ícone principal do Card
           Image(painter = painterResource(id = continente.imagem), contentDescription = "")
       }
    }
}

