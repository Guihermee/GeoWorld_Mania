package br.com.fiap.geoworldmania.components

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OpcaoDeEscolhaJogo(opcao: List<String>) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp),
            shape = RoundedCornerShape(8.dp)
        ) {
            val opcaoTexto = opcao.joinToString(separator = ", ")
            Text(
                text = opcaoTexto,
                fontSize = 32.sp
            )
        }
    }
    Spacer(modifier = Modifier.height(6.dp))
}

@Composable
fun OpcaoDeEscolhaJogoErrado(opcao: String) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = opcao,
                fontSize = 32.sp
            )
        }
    }
    Spacer(modifier = Modifier.height(6.dp))
}