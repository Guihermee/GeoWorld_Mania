package br.com.fiap.geoworldmania.screens


import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import br.com.fiap.geoworldmania.R
import br.com.fiap.geoworldmania.components.Ajuda
import br.com.fiap.geoworldmania.components.Header
import br.com.fiap.geoworldmania.components.JogoCapital
import br.com.fiap.geoworldmania.model.Pais
import br.com.fiap.geoworldmania.service.RetrofitFactory
import br.com.fiap.geoworldmania.viewModel.JogoDaCapitalScreenViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun JogoDaCapitalScreen(
    jogoDaCapitalScreenViewModel: JogoDaCapitalScreenViewModel,
    navController: NavController,


) {
    Column {

        val listaPaisAleatoriosState by jogoDaCapitalScreenViewModel
            .listaPaisAleatorioState.observeAsState(initial = listOf())
        val nivel01 by jogoDaCapitalScreenViewModel.nivel01.observeAsState(initial = listOf())
        val indexAtual by jogoDaCapitalScreenViewModel.indexAtual.observeAsState(initial = 0)
        val listaDeContinente by jogoDaCapitalScreenViewModel.listaDeContinente.observeAsState(
            initial = listOf()
        )
        var visibilidadeBotao by remember { mutableStateOf(true) }

        Header(textContent = "Capital - Europa - Nível 1", onClickVoltar = {navController.navigate("opcoesDeNiveis")})
        Ajuda(onClick = {})

        if (visibilidadeBotao) {
            Button(

                onClick = {
                    val call = RetrofitFactory().getPaisService().getPaisByContinente("europe")
                    call.enqueue(object : Callback<List<Pais>> {
                        override fun onResponse(
                            call: Call<List<Pais>>,
                            response: Response<List<Pais>>
                        ) {
                            Log.i("FIAP", "onResponse: ${response.body()}")

                            val resp = response.body()!!
                            val paisesAleatorios = resp.shuffled().take(3).toMutableList()
                            val nivel01 = resp.take(10)

                            jogoDaCapitalScreenViewModel.onListaPaisAleatorioStateChange(
                                paisesAleatorios
                            )
                            jogoDaCapitalScreenViewModel.adicionarPaisAleatorio(nivel01[0])
                            jogoDaCapitalScreenViewModel.embaralharPaisesAleatorios()
                            jogoDaCapitalScreenViewModel.onNivel01Change(nivel01)
                            jogoDaCapitalScreenViewModel.onListaDeContinenteStateChange(resp)
                            visibilidadeBotao = false
                        }

                        override fun onFailure(call: Call<List<Pais>>, t: Throwable) {
                            Log.i("FIAP", "onResponse: ${t.message}")
                        }
                    })
                },
            )
            { Text(stringResource(id = R.string.iniciar_jogo)) }
        }
        Column {

            for (i in nivel01.indices) {
                if (i == indexAtual) {
                    JogoCapital(
                        pais = nivel01[i],
                        listaPaisAleatoriosState,
                        nivel01,
                        listaDeContinente,
                        navController,
                        jogoDaCapitalScreenViewModel
                    )
                }
            }
        }
    }
}