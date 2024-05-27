package br.com.fiap.geoworldmania

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import br.com.fiap.geoworldmania.screens.ConsultaBandeiraScreen
import br.com.fiap.geoworldmania.screens.ConsultaCapitaisScreen
import br.com.fiap.geoworldmania.screens.JogoDaCapitalScreen
import br.com.fiap.geoworldmania.screens.OpcoesDeContinenteScreen
import br.com.fiap.geoworldmania.screens.OpcoesDeNiveisScreen
import br.com.fiap.geoworldmania.screens.PerfilScreen
import br.com.fiap.geoworldmania.screens.TelaInicial
import br.com.fiap.geoworldmania.screens.TelaResultadoScreen
import br.com.fiap.geoworldmania.ui.theme.GeoWorldManiaTheme
import br.com.fiap.geoworldmania.viewModel.ConsultaCapitaisViewModel
import br.com.fiap.geoworldmania.viewModel.JogoDaCapitalScreenViewModel
import br.com.fiap.geoworldmania.viewModel.PerfilViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GeoWorldManiaTheme(false, false) {
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
                        composable(
                            route = "opcoesDeContinente?tituloJogo={tituloJogo}?jogoPais={jogoPais}?jogoBandeira={jogoBandeira}",
                            arguments = listOf(
                                navArgument(name = "tituloJogo") {
                                    defaultValue = ""
                                },
                                navArgument(name = "jogoPais") {
                                    defaultValue = false
                                },
                                navArgument(name = "jogoBandeira") {
                                    defaultValue = false
                                }
                            )
                        ) {
                            val tituloJogo = it.arguments?.getString("tituloJogo")!!
                            val jogoPais = it.arguments?.getBoolean("jogoPais")!!
                            val jogoBandeira = it.arguments?.getBoolean("jogoBandeira")!!
                            OpcoesDeContinenteScreen(
                                navController,
                                tituloJogo,
                                jogoPais,
                                jogoBandeira
                            )
                        }
                        composable(
                            route = "opcoesDeNiveis?continente={continente}?tituloJogo={tituloJogo}?tituloContinente={tituloContinente}?jogoPais={jogoPais}?jogoBandeira={jogoBandeira}",
                            arguments = listOf(
                                navArgument(name = "continente") {
                                    defaultValue = ""
                                },
                                navArgument(name = "tituloContinente") {
                                    defaultValue = ""
                                },
                                navArgument(name = "tituloJogo") {
                                    defaultValue = ""
                                },
                                navArgument(name = "jogoPais") {
                                    defaultValue = false
                                },
                                navArgument(name = "jogoBandeira") {
                                    defaultValue = false
                                }
                            )
                        ) {
                            val continente = it.arguments?.getString("continente")!!
                            val tituloJogo = it.arguments?.getString("tituloJogo")!!
                            val tituloContinente = it.arguments?.getString("tituloContinente")!!
                            val jogoPais = it.arguments?.getBoolean("jogoPais")!!
                            val jogoBandeira = it.arguments?.getBoolean("jogoBandeira")!!
                            OpcoesDeNiveisScreen(
                                navController,
                                continente,
                                tituloJogo,
                                tituloContinente,
                                jogoPais,
                                jogoBandeira
                            )
                        }
                        composable(
                            route = "jogoDaCapital?indexNivelComeca={indexNivelComeca}?indexNivelTermina={indexNivelTermina}?continente={continente}?tituloJogo={tituloJogo}?tituloContinente={tituloContinente}?tituloNivel={tituloNivel}?desafio={desafio}?todos={todos}?jogoPais={jogoPais}?jogoBandeira={jogoBandeira}?continuaOndeParou={continuaOndeParou}",
                            arguments = listOf(
                                navArgument(name = "indexNivelComeca") {
                                    defaultValue = 0
                                },
                                navArgument(name = "indexNivelTermina") {
                                    defaultValue = 0
                                },
                                navArgument(name = "continente") {
                                    defaultValue = ""
                                },
                                navArgument(name = "tituloContinente") {
                                    defaultValue = ""
                                },
                                navArgument(name = "tituloJogo") {
                                    defaultValue = ""
                                },
                                navArgument(name = "tituloNivel") {
                                    defaultValue = ""
                                },
                                navArgument(name = "desafio") {
                                    defaultValue = false
                                },
                                navArgument(name = "todos") {
                                    defaultValue = false
                                },
                                navArgument(name = "jogoPais") {
                                    defaultValue = false
                                },
                                navArgument(name = "jogoBandeira") {
                                    defaultValue = false
                                },
                                navArgument(name = "continuaOndeParou") {
                                    defaultValue = false
                                }
                            )
                        ) {
                            val indexNivelComeca = it.arguments?.getInt("indexNivelComeca")!!
                            val indexNivelTermina = it.arguments?.getInt("indexNivelTermina")!!
                            val continente = it.arguments?.getString("continente")!!
                            val tituloJogo = it.arguments?.getString("tituloJogo")!!
                            val tituloContinente = it.arguments?.getString("tituloContinente")!!
                            val tituloNivel = it.arguments?.getString("tituloNivel")!!
                            val desafio = it.arguments?.getBoolean("desafio")!!
                            val todos = it.arguments?.getBoolean("todos")!!
                            val jogoPais = it.arguments?.getBoolean("jogoPais")!!
                            val jogoBandeira = it.arguments?.getBoolean("jogoBandeira")!!
                            val continuaOndeParou = it.arguments?.getBoolean("continuaOndeParou")!!
                            JogoDaCapitalScreen(
                                JogoDaCapitalScreenViewModel(),
                                PerfilViewModel(),
                                navController,
                                continente,
                                indexNivelComeca,
                                indexNivelTermina,
                                tituloJogo,
                                tituloContinente,
                                tituloNivel,
                                desafio,
                                todos,
                                jogoPais,
                                jogoBandeira,
                                continuaOndeParou
                            )
                        }
                        composable(
                            route = "telaResultado?acertos={acertos}?erros={erros}?continente={continente}?tituloJogo={tituloJogo}?tituloContinente={tituloContinente}?jogoPais={jogoPais}?jogoBandeira={jogoBandeira}",
                            arguments = listOf(
                                navArgument(name = "acertos") {
                                    defaultValue = 0
                                },
                                navArgument(name = "erros") {
                                    defaultValue = 0
                                },
                                navArgument(name = "continente") {
                                    defaultValue = ""
                                },
                                navArgument(name = "tituloContinente") {
                                    defaultValue = ""
                                },
                                navArgument(name = "tituloJogo") {
                                    defaultValue = ""
                                },
                                navArgument(name = "jogoPais") {
                                    defaultValue = false
                                },
                                navArgument(name = "jogoBandeira") {
                                    defaultValue = false
                                }
                            )
                        ) {
                            val acertos = it.arguments?.getInt("acertos")!!
                            val erros = it.arguments?.getInt("erros")!!
                            val continente = it.arguments?.getString("continente")!!
                            val tituloJogo = it.arguments?.getString("tituloJogo")!!
                            val tituloContinente = it.arguments?.getString("tituloContinente")!!
                            val jogoPais = it.arguments?.getBoolean("jogoPais")!!
                            val jogoBandeira = it.arguments?.getBoolean("jogoBandeira")!!
                            TelaResultadoScreen(
                                navController,
                                acertos,
                                erros,
                                continente,
                                tituloJogo,
                                tituloContinente,
                                jogoPais,
                                jogoBandeira
                            )
                        }
                        composable(
                            route = "consultaCapitaisScreen?tituloJogo={tituloJogo}",
                            arguments = listOf(
                                navArgument(name = "tituloJogo") {
                                    defaultValue = ""
                                }
                            )
                        ){
                            val tituloJogo = it.arguments?.getString("tituloJogo")!!
                            ConsultaCapitaisScreen(
                                navController = navController,
                                consultaCapitaisViewModel = ConsultaCapitaisViewModel(),
                                tituloJogo = tituloJogo
                            )
                        }
                        composable(
                            route = "consultaBandeirasScreen?tituloJogo={tituloJogo}",
                            arguments = listOf(
                                navArgument(name = "tituloJogo") {
                                    defaultValue = ""
                                }
                            )
                        ) {
                            val tituloJogo = it.arguments?.getString("tituloJogo")!!
                            ConsultaBandeiraScreen(
                                navController = navController,
                                consultaCapitaisViewModel = ConsultaCapitaisViewModel(),
                                tituloJogo = tituloJogo
                            )
                        }
                        composable(
                            route = "PerfilScreen"
                        ) {
                            PerfilScreen(navController, PerfilViewModel())
                        }
                    }
                }
            }
        }
    }

}