package br.com.fiap.geoworldmania.screens


import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
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
        val iniciarJogo by jogoDaCapitalScreenViewModel.iniciarJogo.observeAsState(initial = true)
        Header(textContent = "Capital - Europa - Nível 1", onClickVoltar = {navController.navigate("opcoesDeNiveis")})

        var isDialog by remember {mutableStateOf(false)}

        Ajuda(onClick = {isDialog = true})

        if(isDialog){
            Dialog(onDismissRequest = { isDialog = false }, DialogProperties()) {
                var letra by remember { mutableStateOf("") }

                for (i in nivel01.indices) {
                    if (i == indexAtual) {
                        letra = nivel01[i].capital[0].first().toString()
                    }
                }

                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Card(
                        modifier = Modifier
                            .height(150.dp)
                            .width(300.dp),
                        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.azul4)),
                        elevation = CardDefaults.cardElevation(6.dp),
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxSize()
                                .fillMaxWidth()
                        ) {
                            Column (horizontalAlignment = Alignment.CenterHorizontally,){
                                Text(
                                    text = "A Primeira letra é $letra",
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White,
                                    fontSize = 25.sp
                                )
                                Button(
                                    onClick = {isDialog = false} ,
                                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.azul4)),
                                    modifier = Modifier.padding(top = 30.dp)
                                ){
                                    Text(
                                        text = "Sair",
                                        fontSize = 25.sp,
                                        modifier = Modifier.padding(start = 150.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }


        if (iniciarJogo) {
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
                    jogoDaCapitalScreenViewModel.onIniciarJogoChange(false)
                }

                override fun onFailure(call: Call<List<Pais>>, t: Throwable) {
                    Log.i("FIAP", "onResponse: ${t.message}")
                }
            })
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