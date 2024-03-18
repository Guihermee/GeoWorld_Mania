package br.com.fiap.geoworldmania.screens

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.geoworldmania.R
import br.com.fiap.geoworldmania.R.drawable.heart_filled_42_white
import br.com.fiap.geoworldmania.R.drawable.lightbulb_filled_42_white
import br.com.fiap.geoworldmania.components.Footer
import br.com.fiap.geoworldmania.components.Header
import br.com.fiap.geoworldmania.components.OpcoesEscolhaNivel
import br.com.fiap.geoworldmania.model.Pais
import br.com.fiap.geoworldmania.service.RetrofitFactory
import br.com.fiap.geoworldmania.viewModel.JogoDaCapitalScreenViewModel
import br.com.fiap.geoworldmania.viewModel.TelaInicialViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable

fun OpcoesDeNiveisScreen(navController: NavController, jogoDaCapitalScreenViewModel: JogoDaCapitalScreenViewModel) {

    val listaPaisAleatoriosState by jogoDaCapitalScreenViewModel
        .listaPaisAleatorioState.observeAsState(initial = listOf())
    val nivel01 by jogoDaCapitalScreenViewModel.nivel01.observeAsState(initial = listOf())
    val indexAtual by jogoDaCapitalScreenViewModel.indexAtual.observeAsState(initial = 0)
    val listaDeContinente by jogoDaCapitalScreenViewModel.listaDeContinente.observeAsState(
        initial = listOf()
    )

    Box(modifier = Modifier.fillMaxWidth()) {
        Column() {
            Header(textContent = "", onClickVoltar = {navController.navigate("opcoesDeContinente")})
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
                onClick = {
                    val call = RetrofitFactory().getPaisService().getPaisByContinente("europe")
                    call.enqueue(object : Callback<List<Pais>> {
                        override fun onResponse(call: Call<List<Pais>>, response: Response<List<Pais>>) {
                            Log.i("FIAP", "onResponse: ${response.body()}")

                            val resp = response.body()!!
                            val paisesAleatorios = resp.shuffled().take(3).toMutableList()
                            val nivel01 = resp.take(10)

                            jogoDaCapitalScreenViewModel.onListaPaisAleatorioStateChange(paisesAleatorios)
                            jogoDaCapitalScreenViewModel.adicionarPaisAleatorio(nivel01[0])
                            jogoDaCapitalScreenViewModel.embaralharPaisesAleatorios()
                            jogoDaCapitalScreenViewModel.onNivel01Change(nivel01)
                            jogoDaCapitalScreenViewModel.onListaDeContinenteStateChange(resp)

                        }

                        override fun onFailure(call: Call<List<Pais>>, t: Throwable) {
                            Log.i("FIAP", "onResponse: ${t.message}")
                        }
                    })
                    navController.navigate("jogoDaCapital")
                },
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.verde_claro))
            )


            OpcoesEscolhaNivel(
                texto1 = "Nivel 2: +10 Países",
                imagem = lightbulb_filled_42_white,
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.verde_claro))
            )

            OpcoesEscolhaNivel(
                texto1 = "Desafio: 20 Países",
                imagem = heart_filled_42_white,
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.azul_claro))
            )

            OpcoesEscolhaNivel(
                texto1 = "Nivel 3: 10 Países",
                imagem = lightbulb_filled_42_white,
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.verde_claro))
            )

            OpcoesEscolhaNivel(
                texto1 = "Nivel 4: +10 Países",
                imagem = lightbulb_filled_42_white,
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.verde_claro))
            )

            OpcoesEscolhaNivel(
                texto1 = "Desafio: 40 Países",
                imagem = heart_filled_42_white,
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.azul_claro))
            )

            OpcoesEscolhaNivel(
                texto1 = "Desafio Difícil: Todos os países",
                imagem = heart_filled_42_white,
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.vermelho))
            )

        }
        Box(contentAlignment = Alignment.BottomCenter) { Footer() }
    }

}

//@Preview (showBackground = true, showSystemUi = true)
//@Composable
//fun OpcoesDeNiveisScreenPreview (){
//        OpcoesDeNiveisScreen()
//}
