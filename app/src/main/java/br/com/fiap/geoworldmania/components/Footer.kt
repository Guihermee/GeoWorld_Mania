package br.com.fiap.geoworldmania.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.geoworldmania.R

@Composable
fun Footer(navController: NavController) {

    Box(
        contentAlignment = Alignment.BottomStart,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = colorResource(id = R.color.azul2))
                .height(70.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                IconButton(onClick = { navController.navigate("telaInicial") }) {
                    Icon(
                        painter = painterResource(id = R.drawable.home_42),
                        contentDescription = "Icone de Menu",
                        tint = colorResource(id = R.color.azul5)
                    )
                }
            }
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(40.dp, 40.dp)
                    .clip(shape = CircleShape)
            ){
                IconButton(onClick = { /*TODO*/ }) {
                    Image(
                        painter = painterResource(id = R.drawable.ana),
                        contentDescription = "Conta logada",
                        contentScale = ContentScale.Crop
                    )
                }
            }
            IconButton(onClick = { /*TODO BOTÃO DOS SETTINGS*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.settings_42),
                    contentDescription = "Ícone de configurações",
                    tint = colorResource (id = R.color.azul5)
                )
            }
        }
    }
}