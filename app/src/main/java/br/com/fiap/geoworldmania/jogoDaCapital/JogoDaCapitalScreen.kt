package br.com.fiap.geoworldmania.jogoDaCapital


import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import br.com.fiap.geoworldmania.components.AjudaAndVidas
import br.com.fiap.geoworldmania.components.Header

@Composable
fun JogoDaCapitalScreen() {
    Column {
        Header(textContent = "Capital - Europa - Nível 1")
        AjudaAndVidas()
    }

}