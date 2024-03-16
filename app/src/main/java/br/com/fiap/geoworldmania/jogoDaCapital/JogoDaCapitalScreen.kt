package br.com.fiap.geoworldmania.jogoDaCapital


import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import br.com.fiap.geoworldmania.components.AjudaAndVidas
import br.com.fiap.geoworldmania.components.Header
import br.com.fiap.geoworldmania.components.JogoCapital
import br.com.fiap.geoworldmania.model.Pais
import br.com.fiap.geoworldmania.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun JogoDaCapitalScreen(jogoDaCapitalScreenViewModel: JogoDaCapitalScreenViewModel) {
    Column {

        var listaPaisState by remember { mutableStateOf(listOf<Pais>()) }

        Header(textContent = "Capital - Europa - Nível 1")
        AjudaAndVidas()

        Button(onClick = {
            var call = RetrofitFactory().getPaisService().getPaisByContinente("europe")
            call.enqueue(object : Callback<List<Pais>> {
                override fun onResponse(call: Call<List<Pais>>, response: Response<List<Pais>>) {
                    Log.i("FIAP", "onResponse: ${response.body()}")
                    listaPaisState = response.body()!!
                }

                override fun onFailure(call: Call<List<Pais>>, t: Throwable) {
                    Log.i("FIAP", "onResponse: ${t.message}")
                }
            })
        }) {}

        LazyColumn {
            items(listaPaisState){
                JogoCapital(pais = it)
            }
        }

    }
}