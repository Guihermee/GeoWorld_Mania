package br.com.fiap.geoworldmania.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import br.com.fiap.geoworldmania.R

@Composable
fun AjudaAndVidas() {
    Box {
        Row {
            Icon(
                painter = painterResource(id = R.drawable.lightbulb_filled_42),
                contentDescription = "Icone de uma lâmpada"
            )
        }
    }
}