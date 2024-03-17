package br.com.fiap.geoworldmania.screens


import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import br.com.fiap.geoworldmania.components.AjudaAndVidas
import br.com.fiap.geoworldmania.components.Header
import br.com.fiap.geoworldmania.components.JogoCapital
import br.com.fiap.geoworldmania.model.Pais
import br.com.fiap.geoworldmania.service.RetrofitFactory
import br.com.fiap.geoworldmania.viewModel.JogoDaCapitalScreenViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun JogoDaCapitalScreen(jogoDaCapitalScreenViewModel: JogoDaCapitalScreenViewModel) {
    Column {

        val listaPaisAleatoriosState by jogoDaCapitalScreenViewModel
            .listaPaisAleatorioState.observeAsState(initial = listOf())
        val nivel01 by jogoDaCapitalScreenViewModel.nivel01.observeAsState(initial = listOf())
        val indexAtual by jogoDaCapitalScreenViewModel.indexAtual.observeAsState(initial = 0)

        Header(textContent = "Capital - Europa - Nível 1")
        AjudaAndVidas()

        Button(onClick = {
            val call = RetrofitFactory().getPaisService().getPaisByContinente("europe")
            call.enqueue(object : Callback<List<Pais>> {
                override fun onResponse(call: Call<List<Pais>>, response: Response<List<Pais>>) {
                    Log.i("FIAP", "onResponse: ${response.body()}")

                    val resp = response.body()!!
                    val paisesAleatorios = resp
                    val nivel01 = resp.take(10)

                    jogoDaCapitalScreenViewModel.onListaPaisAleatorioStateChange(paisesAleatorios)
                    jogoDaCapitalScreenViewModel.onNivel01Change(nivel01)

                }

                override fun onFailure(call: Call<List<Pais>>, t: Throwable) {
                    Log.i("FIAP", "onResponse: ${t.message}")
                }
            })
        }) {}

        for (i in nivel01.indices) {
            if ( i == indexAtual) {
                jogoDaCapitalScreenViewModel.adicionarPaisAleatorio(nivel01[i])
                jogoDaCapitalScreenViewModel.embaralharPaisesAleatorios()

                JogoCapital(
                    pais = nivel01[i],
                    listaPaisAleatoriosState,
                    jogoDaCapitalScreenViewModel
                )
                jogoDaCapitalScreenViewModel.removerPaisAleatorio(nivel01[i])
            }
        }
    }
}