package br.com.fiap.geoworldmania.repository


import androidx.navigation.NavController
import br.com.fiap.geoworldmania.R
import br.com.fiap.geoworldmania.model.Nivel

fun getAllNiveis(
    navController: NavController,
    continente: String,
    tituloJogo: String,
    tituloContinente: String,
    jogoPais: Boolean,
    jogoBandeira: Boolean
): List<Nivel> { // Nível é uma DataClass

    // Inicialização da variável para ser preenchida dependendo do continente e depois sendo devolvida para uso
    var listaPaisesContinente: List<Nivel> = emptyList()

    /* Talvez não é o melhor jeito de se fazer, mas como cada continente precisa de um número
     especifico de níveis, então é passado por um IF que decide qual é o nível que o usuário
     escolheu, retornando a lista para ser percorrida. */
    if (continente == "africa") {
        listaPaisesContinente = listOf(
            Nivel(
                texto = "Nível 1",
                imagem = R.drawable.lightbulb_filled_42_white,
                onClick = {navController.navigate("jogoDaCapital?indexNivelComeca=0?indexNivelTermina=10?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?tituloNivel=Nível 1?desafio=false?todos=false?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}")},
                dificuldade = 1
            ),
            Nivel(
                texto = "Nível 2",
                imagem = R.drawable.lightbulb_filled_42_white,
                onClick = {navController.navigate("jogoDaCapital?indexNivelComeca=10?indexNivelTermina=20?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?tituloNivel=Nível 2?desafio=false?todos=false?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}")},
                dificuldade = 1
            ),
            Nivel(
                texto = "Desafio 1",
                imagem = R.drawable.heart_filled_42_white,
                onClick = {navController.navigate("jogoDaCapital?indexNivelComeca=0?indexNivelTermina=20?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?tituloNivel=Desafio 1?desafio=true?todos=false?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}")},
                dificuldade = 2
            ),
            Nivel(
                texto = "Nível 3",
                imagem = R.drawable.lightbulb_filled_42_white,
                onClick = {navController.navigate("jogoDaCapital?indexNivelComeca=20?indexNivelTermina=30?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?tituloNivel=Nível 3?desafio=false?todos=false?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}")},
                dificuldade = 1
            ),
            Nivel(
                texto = "Nível 4",
                imagem = R.drawable.lightbulb_filled_42_white,
                onClick = {navController.navigate("jogoDaCapital?indexNivelComeca=30?indexNivelTermina=40?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?tituloNivel=Nível 4?desafio=false?todos=false?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}")},
                dificuldade = 1
            ),
            Nivel(
                texto = "Desafio 2",
                imagem = R.drawable.heart_filled_42_white,
                onClick = {navController.navigate("jogoDaCapital?indexNivelComeca=0?indexNivelTermina=40?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?tituloNivel=Desafio 2?desafio=true?todos=false?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}")},
                dificuldade = 2
            ),
            Nivel(
                texto = "Nível 5",
                imagem = R.drawable.lightbulb_filled_42_white,
                onClick = {navController.navigate("jogoDaCapital?indexNivelComeca=40?indexNivelTermina=50?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?tituloNivel=Nível 5?desafio=false?todos=false?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}")},
                dificuldade = 1
            ),
            Nivel(
                texto = "Nível 6",
                imagem = R.drawable.lightbulb_filled_42_white,
                onClick = {navController.navigate("jogoDaCapital?indexNivelComeca=50?indexNivelTermina=59?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?tituloNivel=Nível 6?desafio=false?todos=false?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}")},
                dificuldade = 1
            ),
            Nivel(
                texto = "Desafio Final",
                imagem = R.drawable.heart_filled_42_white,
                onClick = {navController.navigate("jogoDaCapital?indexNivelComeca=0?indexNivelTermina=59?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?tituloNivel=Desafio Final?desafio=true?todos=false?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}")},
                dificuldade = 3
            )
        )
    }

    if(continente == "America do Norte e Central"){
        val qtdTotal = getPaisByContinente("americas").count() //42
        var nivel1 = 10
        var nivel2 = 20
        var nivel3 = 30
        var nivel4 = qtdTotal

        listaPaisesContinente = listOf(
            Nivel(
                texto = "Nível 1",
                imagem = R.drawable.lightbulb_filled_42_white,
                onClick = {navController.navigate("jogoDaCapital?indexNivelComeca=0?indexNivelTermina=${nivel1}?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?tituloNivel=Nível 1?desafio=false?todos=false?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}")},
                dificuldade = 1
            ),
            Nivel(
                texto = "Nível 2",
                imagem = R.drawable.lightbulb_filled_42_white,
                onClick = {navController.navigate("jogoDaCapital?indexNivelComeca=${nivel1}?indexNivelTermina=${nivel2}?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?tituloNivel=Nível 2?desafio=false?todos=false?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}")},
                dificuldade = 1
            ),
            Nivel(
                texto = "Desafio 1",
                imagem = R.drawable.heart_filled_42_white,
                onClick = {navController.navigate("jogoDaCapital?indexNivelComeca=0?indexNivelTermina=${nivel2}?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?tituloNivel=Desafio?desafio=true?todos=false?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}")},
                dificuldade = 2
            ),
            Nivel(
                texto = "Nível 3",
                imagem = R.drawable.lightbulb_filled_42_white,
                onClick = {navController.navigate("jogoDaCapital?indexNivelComeca=${nivel2}?indexNivelTermina=${nivel3}?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?tituloNivel=Nível 3?desafio=false?todos=false?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}")},
                dificuldade = 1
            ),
            Nivel(
                texto = "Nível 4",
                imagem = R.drawable.lightbulb_filled_42_white,
                onClick = {navController.navigate("jogoDaCapital?indexNivelComeca=${nivel3}?indexNivelTermina=${nivel4}?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?tituloNivel=Nível 4?desafio=false?todos=false?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}")},
                dificuldade = 1
            ),
            Nivel(
                texto = "Desafio Final",
                imagem = R.drawable.heart_filled_42_white,
                onClick = {navController.navigate("jogoDaCapital?indexNivelComeca=0?indexNivelTermina=${nivel4}?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?tituloNivel=Desafio Final?desafio=true?todos=false?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}")},
                dificuldade = 3
            )
        )
    }

    if (continente == "america do sul") {
        listaPaisesContinente = listOf(
            Nivel(
                texto = "Nível 1",
                imagem = R.drawable.lightbulb_filled_42_white,
                onClick = { navController.navigate("jogoDaCapital?indexNivelComeca=0?indexNivelTermina=14?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?tituloNivel=Nível?desafio=false?todos=false?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}") },
                dificuldade = 1
            ),
            Nivel(
                texto = "Desafio Final",
                imagem = R.drawable.heart_filled_42_white,
                onClick = {
                    navController.navigate("jogoDaCapital?indexNivelComeca=0?indexNivelTermina=14?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?tituloNivel=Desafio Final?desafio=true?todos=false?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}")
                },
                dificuldade = 3
            ),
        )
    }

    if (continente == "asia") {
        listaPaisesContinente = listOf(
            Nivel(
                texto = "Nível 1",
                imagem = R.drawable.lightbulb_filled_42_white,
                onClick = {navController.navigate("jogoDaCapital?indexNivelComeca=0?indexNivelTermina=12?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?tituloNivel=Nível 1?desafio=false?todos=false?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}")},
                dificuldade = 1
            ),
            Nivel(
                texto = "Nível 2",
                imagem = R.drawable.lightbulb_filled_42_white,
                onClick = {navController.navigate("jogoDaCapital?indexNivelComeca=12?indexNivelTermina=24?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?tituloNivel=Nível 2?desafio=false?todos=false?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}")},
                dificuldade = 1
            ),
            Nivel(
                texto = "Desafio 1",
                imagem = R.drawable.heart_filled_42_white,
                onClick = {navController.navigate("jogoDaCapital?indexNivelComeca=0?indexNivelTermina=24?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?tituloNivel=Desafio?desafio=true?todos=false?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}")},
                dificuldade = 2
            ),
            Nivel(
                texto = "Nível 3",
                imagem = R.drawable.lightbulb_filled_42_white,
                onClick = {navController.navigate("jogoDaCapital?indexNivelComeca=24?indexNivelTermina=37?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?tituloNivel=Nível 3?desafio=false?todos=false?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}")},
                dificuldade = 1
            ),
            Nivel(
                texto = "Nível 4",
                imagem = R.drawable.lightbulb_filled_42_white,
                onClick = {navController.navigate("jogoDaCapital?indexNivelComeca=37?indexNivelTermina=50?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?tituloNivel=Nível 4?desafio=false?todos=false?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}")},
                dificuldade = 1
            ),
            Nivel(
                texto = "Desafio Final",
                imagem = R.drawable.heart_filled_42_white,
                onClick = {navController.navigate("jogoDaCapital?indexNivelComeca=0?indexNivelTermina=50?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?tituloNivel=Desafio Final?desafio=true?todos=false?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}")},
                dificuldade = 3
            )
        )
    }

    if (continente == "europa") {
        listaPaisesContinente = listOf(
            Nivel(
                texto = "Nível 1",
                imagem = R.drawable.lightbulb_filled_42_white,
                onClick = { navController.navigate("jogoDaCapital?indexNivelComeca=0?indexNivelTermina=13?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?tituloNivel=Nível 1?desafio=false?todos=false?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}") },
                dificuldade = 1
            ),
            Nivel(
                texto = "Nivel 2",
                imagem = R.drawable.lightbulb_filled_42_white,
                onClick = {
                    navController.navigate("jogoDaCapital?indexNivelComeca=13?indexNivelTermina=26?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?tituloNivel=Nível 2?desafio=false?todos=false?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}")
                },
                dificuldade = 1
            ),
            Nivel(
                texto = "Desafio - 28 Paises",
                imagem = R.drawable.heart_filled_42_white,
                onClick = {
                    navController.navigate("jogoDaCapital?indexNivelComeca=0?indexNivelTermina=26?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?tituloNivel=Desafio?desafio=true?todos=false?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}")
                },
                dificuldade = 2
            ),
            Nivel(
                texto = "Nivel 3",
                imagem = R.drawable.lightbulb_filled_42_white,
                onClick = {
                    navController.navigate("jogoDaCapital?indexNivelComeca=26?indexNivelTermina=39?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?tituloNivel=Nível 3?desafio=false?todos=false?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}")
                },
                dificuldade = 1
            ),
            Nivel(
                texto = "Nivel 4",
                imagem = R.drawable.lightbulb_filled_42_white,
                onClick = {
                    navController.navigate("jogoDaCapital?indexNivelComeca=39?indexNivelTermina=53?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?tituloNivel=Nível 4?desafio=false?todos=false?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}")
                },
                dificuldade = 1
            ),
            Nivel(
                texto = "Desafio Final",
                imagem = R.drawable.heart_filled_42_white,
                onClick = {
                    navController.navigate("jogoDaCapital?indexNivelComeca=0?indexNivelTermina=53?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?tituloNivel=Desafio Final?desafio=true?todos=false?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}")
                },
                dificuldade = 3
            )
        )
    }

    if (continente == "oceania") {
        listaPaisesContinente = listOf(
            Nivel(
                texto = "Nível 1",
                imagem = R.drawable.lightbulb_filled_42_white,
                onClick = { navController.navigate("jogoDaCapital?indexNivelComeca=0?indexNivelTermina=13?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?tituloNivel=Nível 1?desafio=false?todos=false?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}") },
                dificuldade = 1
            ),
            Nivel(
                texto = "Nivel 2",
                imagem = R.drawable.lightbulb_filled_42_white,
                onClick = {
                    navController.navigate("jogoDaCapital?indexNivelComeca=13?indexNivelTermina=27?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?tituloNivel=Nível 2?desafio=false?todos=false?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}")
                },
                dificuldade = 1
            ),
            Nivel(
                texto = "Desafio Final",
                imagem = R.drawable.heart_filled_42_white,
                onClick = {
                    navController.navigate("jogoDaCapital?indexNivelComeca=0?indexNivelTermina=27?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?tituloNivel=Desafio Final?desafio=true?todos=false?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}")
                },
                dificuldade = 3
            ),
        )
    }

    // TODO Lista completa dos Níveis de todos os paises
    if (continente == "all") {
        listaPaisesContinente = listOf(
            Nivel(
                texto = "Desafio Final",
                imagem = R.drawable.heart_filled_42_white,
                onClick = {
                    navController.navigate("jogoDaCapital?indexNivelComeca=0?indexNivelTermina=246?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?tituloNivel=Desafio Final?desafio=true?todos=true?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}")
                },
                dificuldade = 3
            ),
        )
    }
    // Retorna a lista preenchida
    return listaPaisesContinente
}