package br.com.fiap.geoworldmania

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import br.com.fiap.geoworldmania.screens.JogoDaCapitalScreen
import br.com.fiap.geoworldmania.screens.OpcoesDeContinenteScreen
import br.com.fiap.geoworldmania.screens.OpcoesDeNiveisScreen
import br.com.fiap.geoworldmania.screens.TelaInicial
import br.com.fiap.geoworldmania.screens.TelaResultadoScreen
import br.com.fiap.geoworldmania.ui.theme.GeoWorldManiaTheme
import br.com.fiap.geoworldmania.viewModel.JogoDaCapitalScreenViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GeoWorldManiaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "telaInicial") {
                        composable(route = "telaInicial") {
                            TelaInicial(navController)
                        }
                        composable(route = "opcoesDeContinente?tituloJogo={tituloJogo}") {
                            val tituloJogo = it.arguments?.getString("tituloJogo")
                            OpcoesDeContinenteScreen(navController, tituloJogo!!)
                        }
                        composable(
                            route = "opcoesDeNiveis?continente={continente}?tituloJogo={tituloJogo}?tituloContinente={tituloContinente}",
                            arguments = listOf(
                                navArgument(name = "continente"){
                                    defaultValue = ""
                                },
                                navArgument(name = "tituloContinente"){
                                    defaultValue = ""
                                },
                                navArgument(name = "tituloJogo"){
                                    defaultValue = ""
                                }
                            )
                        ) {
                            val continente = it.arguments?.getString("continente")
                            val tituloJogo = it.arguments?.getString("tituloJogo")
                            val tituloContinente = it.arguments?.getString("tituloContinente")
                            OpcoesDeNiveisScreen(navController, continente!!, tituloJogo!!, tituloContinente!!)
                        }
                        composable(
                            route = "jogoDaCapital?nivel={nivel}?continente={continente}?tituloJogo={tituloJogo}?tituloContinente={tituloContinente}?tituloNivel={tituloNivel}?desafio={desafio}",
                            arguments = listOf(
                                navArgument(name = "nivel") {
                                    defaultValue = 0
                                },
                                navArgument(name = "continente") {
                                    defaultValue = ""
                                },
                                navArgument(name = "tituloContinente"){
                                    defaultValue = ""
                                },
                                navArgument(name = "tituloJogo"){
                                    defaultValue = ""
                                },
                                navArgument(name = "tituloNivel"){
                                    defaultValue = ""
                                },
                                navArgument(name = "desafio") {
                                    defaultValue = false
                                }
                            )
                            ) {
                            val nivel = it.arguments?.getInt("nivel")
                            val continente = it.arguments?.getString("continente")
                            val tituloJogo = it.arguments?.getString("tituloJogo")
                            val tituloContinente = it.arguments?.getString("tituloContinente")
                            val tituloNivel = it.arguments?.getString("tituloNivel")
                            val desafio = it.arguments?.getBoolean("desafio")
                            JogoDaCapitalScreen(
                                JogoDaCapitalScreenViewModel(),
                                navController,
                                continente!!,
                                nivel!!,
                                tituloJogo!!,
                                tituloContinente!!,
                                tituloNivel!!,
                                desafio!!
                            )
                        }
                        composable(
                            route = "telaResultado?acertos={acertos}?erros={erros}?continente={continente}?tituloJogo={tituloJogo}?tituloContinente={tituloContinente}",
                            arguments = listOf(
                                navArgument(name = "acertos"){
                                    defaultValue = 0
                                },
                                navArgument(name = "erros"){
                                    defaultValue = 0
                                },
                                navArgument(name = "continente") {
                                    defaultValue = ""
                                },
                                navArgument(name = "tituloContinente"){
                                    defaultValue = ""
                                },
                                navArgument(name = "tituloJogo"){
                                    defaultValue = ""
                                },
                            )
                        ) {
                            val acertos =  it.arguments?.getInt("acertos")!!
                            val erros = it.arguments?.getInt("erros")!!
                            val continente = it.arguments?.getString("continente")!!
                            val tituloJogo = it.arguments?.getString("tituloJogo")!!
                            val tituloContinente = it.arguments?.getString("tituloContinente")!!
                            TelaResultadoScreen(
                                navController,
                                acertos,
                                erros,
                                continente,
                                tituloJogo,
                                tituloContinente
                            )
                        }
                    }
                }
            }
        }
    }
}