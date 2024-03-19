package br.com.fiap.geoworldmania

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import br.com.fiap.geoworldmania.components.JogoCapital
import br.com.fiap.geoworldmania.screens.JogoDaCapitalScreen
import br.com.fiap.geoworldmania.screens.OpcoesDeContinenteScreen
import br.com.fiap.geoworldmania.screens.OpcoesDeNiveisScreen
import br.com.fiap.geoworldmania.screens.TelaInicial
import br.com.fiap.geoworldmania.screens.TelaResultadoScreen
import br.com.fiap.geoworldmania.viewModel.JogoDaCapitalScreenViewModel
import br.com.fiap.geoworldmania.ui.theme.GeoWorldManiaTheme
import br.com.fiap.geoworldmania.viewModel.TelaInicialViewModel

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
                    var navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "telaInicial") {
                        composable(route = "telaInicial") {
                            TelaInicial(navController)
                        }
                        composable(route = "opcoesDeContinente") {
                            OpcoesDeContinenteScreen(navController)
                        }
                        composable(route = "opcoesDeNiveis") {
                            OpcoesDeNiveisScreen(navController, JogoDaCapitalScreenViewModel())
                        }
                        composable(route = "jogoDaCapital") {
                            JogoDaCapitalScreen(JogoDaCapitalScreenViewModel(), navController)
                        }
                        composable(
                            route = "telaResultado?acertos={acertos}?erros={erros}",
                            arguments = listOf(
                                navArgument(name = "acertos"){
                                    defaultValue = 0
                                },
                                navArgument(name = "erros"){
                                    defaultValue = 0
                                }
                            )
                        ) {
                            TelaResultadoScreen(
                                navController,
                                it.arguments?.getInt("acertos")!!,
                                it.arguments?.getInt("erros")!!
                            )
                        }
                    }
                }
            }
        }
    }
}
