package br.com.fiap.geoworldmania.components

import android.view.Display
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CircularIndeterminateProgressBar(
    isDisplayed : Boolean
) {
    if (isDisplayed){

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        CircularProgressIndicator(
            progress = 0.8f,
            modifier = Modifier
                .size(90.dp),
            color = Color.Gray,
            strokeWidth = 10.dp,

            )

    }

}}

// Inserir a barra no screen do Jogo das capitais, pode ser logo apos o header, por ex.
//     CircularIndeterminateProgressBar(isDisplayed = loading)


// Precisa fazer uma variavel (é a loading que esta acima) mutable com true e false no local onde se inicia o jogo.

//Declarando a variavel
//  val loading = mutableStateOf(false)

// Aqui vai no inicio do jogo
// loading.value = true
// loading.value = false


// video onde o cara ensina: https://youtu.be/MPSZl4EVjQk