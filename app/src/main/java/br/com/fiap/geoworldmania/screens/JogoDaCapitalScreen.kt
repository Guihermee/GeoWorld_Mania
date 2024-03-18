package br.com.fiap.geoworldmania.screens


import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.geoworldmania.R
import br.com.fiap.geoworldmania.components.AjudaAndVidas
import br.com.fiap.geoworldmania.components.Header
import br.com.fiap.geoworldmania.components.JogoCapital
import br.com.fiap.geoworldmania.model.Pais
import br.com.fiap.geoworldmania.service.RetrofitFactory
import br.com.fiap.geoworldmania.viewModel.JogoDaCapitalScreenViewModel
import coil.compose.AsyncImage
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun JogoDaCapitalScreen(
    jogoDaCapitalScreenViewModel: JogoDaCapitalScreenViewModel,
    navController: NavController
) {
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
                    val paisesAleatorios = resp.shuffled().take(3).toMutableList()
                    val nivel01 = resp.take(10)

                    jogoDaCapitalScreenViewModel.onListaPaisAleatorioStateChange(paisesAleatorios)
                    jogoDaCapitalScreenViewModel.adicionarPaisAleatorio(nivel01[0])
                    jogoDaCapitalScreenViewModel.embaralharPaisesAleatorios()
                    jogoDaCapitalScreenViewModel.onNivel01Change(nivel01)

                }

                override fun onFailure(call: Call<List<Pais>>, t: Throwable) {
                    Log.i("FIAP", "onResponse: ${t.message}")
                }
            })
        }) {}
        Column {

            for (i in nivel01.indices) {
                if (i == indexAtual) {
                    JogoCapital(
                        pais = nivel01[i],
                        listaPaisAleatoriosState,
                        nivel01,
                        navController,
                        jogoDaCapitalScreenViewModel
                    )
                }
            }
        }
    }
}