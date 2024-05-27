package br.com.fiap.geoworldmania.repository


import android.content.Context
import androidx.navigation.NavController
import br.com.fiap.geoworldmania.R
import br.com.fiap.geoworldmania.model.NiveisCapitais
import br.com.fiap.geoworldmania.model.Nivel

fun getAllNiveis(
    navController: NavController,
    continente: String,
    tituloJogo: String,
    tituloContinente: String,
    jogoPais: Boolean,
    jogoBandeira: Boolean,
    context: Context
): List<Nivel> {

    var niveisCapitais = NiveisCapitais()

    if (tituloJogo == "Capitais") {
        val userRepository = NiveisCapitaisRepository(context)
        val nivelUserDb = userRepository.db.buscarNiveisCapitaisPorId(1)

        //Tentei usar o Spring framework, mas passei por muitos erros diferentes dos outros então optei fazer isso manualmente
        //BeanUtils.copyProperties(nivelUserDb, niveisCapitais)

        niveisCapitais = NiveisCapitais(
            id = nivelUserDb.id,
            africa = nivelUserDb.africa,
            americaDoNorteECentral = nivelUserDb.americaDoNorteECentral,
            americaDoSul = nivelUserDb.americaDoSul,
            asia = nivelUserDb.asia,
            europa = nivelUserDb.europa,
            oceania = nivelUserDb.oceania,
            todosOsPaises = nivelUserDb.todosOsPaises
        )

    } else if (tituloJogo == "Bandeiras") {
        val userRepository = NiveisBandeirasRepository(context)
        val nivelUserDb = userRepository.db.buscarNiveisBandeirasPorId(1)

        niveisCapitais = NiveisCapitais(
            id = nivelUserDb.id,
            africa = nivelUserDb.africa,
            americaDoNorteECentral = nivelUserDb.americaDoNorteECentral,
            americaDoSul = nivelUserDb.americaDoSul,
            asia = nivelUserDb.asia,
            europa = nivelUserDb.europa,
            oceania = nivelUserDb.oceania,
            todosOsPaises = nivelUserDb.todosOsPaises
        )

    } else {
        val userRepository = NiveisPaisesRepository(context)
        val nivelUserDb = userRepository.db.buscarNiveisPaisesPorId(1)

        niveisCapitais = NiveisCapitais(
            id = nivelUserDb.id,
            africa = nivelUserDb.africa,
            americaDoNorteECentral = nivelUserDb.americaDoNorteECentral,
            americaDoSul = nivelUserDb.americaDoSul,
            asia = nivelUserDb.asia,
            europa = nivelUserDb.europa,
            oceania = nivelUserDb.oceania,
            todosOsPaises = nivelUserDb.todosOsPaises
        )

    }


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
                onClick = {navController.navigate("jogoDaCapital?indexNivelComeca=0?indexNivelTermina=10?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?tituloNivel=Nível 1?desafio=false?todos=false?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}?continuaOndeParou=false")},
                dificuldade = 1,
                desativadoAtivado = desativaAtivaNivel(niveisCapitais.africa, 1)
            ),
            Nivel(
                texto = "Nível 2",
                imagem = R.drawable.lightbulb_filled_42_white,
                onClick = {navController.navigate("jogoDaCapital?indexNivelComeca=10?indexNivelTermina=20?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?tituloNivel=Nível 2?desafio=false?todos=false?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}?continuaOndeParou=false")},
                dificuldade = 1,
                desativadoAtivado = desativaAtivaNivel(niveisCapitais.africa, 2)
            ),
            Nivel(
                texto = "Nível 3 - Desafio",
                imagem = R.drawable.heart_filled_42_white,
                onClick = {navController.navigate("jogoDaCapital?indexNivelComeca=0?indexNivelTermina=20?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?tituloNivel=Nível 3?desafio=true?todos=false?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}?continuaOndeParou=false")},
                dificuldade = 2,
                desativadoAtivado = desativaAtivaNivel(niveisCapitais.africa, 1)
            ),
            Nivel(
                texto = "Nível 4",
                imagem = R.drawable.lightbulb_filled_42_white,
                onClick = {navController.navigate("jogoDaCapital?indexNivelComeca=20?indexNivelTermina=30?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?tituloNivel=Nível 4?desafio=false?todos=false?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}?continuaOndeParou=false")},
                dificuldade = 1,
                desativadoAtivado = desativaAtivaNivel(niveisCapitais.africa, 4)
            ),
            Nivel(
                texto = "Nível 5",
                imagem = R.drawable.lightbulb_filled_42_white,
                onClick = {navController.navigate("jogoDaCapital?indexNivelComeca=30?indexNivelTermina=40?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?tituloNivel=Nível 5?desafio=false?todos=false?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}?continuaOndeParou=false")},
                dificuldade = 1,
                desativadoAtivado = desativaAtivaNivel(niveisCapitais.africa, 5)
            ),
            Nivel(
                texto = "Nível 6 - Desafio",
                imagem = R.drawable.heart_filled_42_white,
                onClick = {navController.navigate("jogoDaCapital?indexNivelComeca=0?indexNivelTermina=40?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?tituloNivel=Nível 6?desafio=true?todos=false?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}?continuaOndeParou=false")},
                dificuldade = 2,
                desativadoAtivado = desativaAtivaNivel(niveisCapitais.africa, 1)
            ),
            Nivel(
                texto = "Nível 7",
                imagem = R.drawable.lightbulb_filled_42_white,
                onClick = {navController.navigate("jogoDaCapital?indexNivelComeca=40?indexNivelTermina=50?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?tituloNivel=Nível 7?desafio=false?todos=false?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}?continuaOndeParou=false")},
                dificuldade = 1,
                desativadoAtivado = desativaAtivaNivel(niveisCapitais.africa, 7)
            ),
            Nivel(
                texto = "Nível 8",
                imagem = R.drawable.lightbulb_filled_42_white,
                onClick = {navController.navigate("jogoDaCapital?indexNivelComeca=50?indexNivelTermina=56?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?tituloNivel=Nível 8?desafio=false?todos=false?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}?continuaOndeParou=false")},
                dificuldade = 1,
                desativadoAtivado = desativaAtivaNivel(niveisCapitais.africa, 8)
            ),
            Nivel(
                texto = "Nível 9 - Desafio Final",
                imagem = R.drawable.heart_filled_42_white,
                onClick = {navController.navigate("jogoDaCapital?indexNivelComeca=0?indexNivelTermina=56?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?tituloNivel=Nível 9?desafio=true?todos=false?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}?continuaOndeParou=false")},
                dificuldade = 3,
                desativadoAtivado = desativaAtivaNivel(niveisCapitais.africa, 1)
            )
        )
    }

    if(continente == "America do Norte e Central"){
        val qtdTotal = getPaisByContinente("America do Norte e Central").count() //42
        val nivel1 = 10
        val nivel2 = 20
        val nivel3 = 30
        val nivel4 = qtdTotal - 1

        listaPaisesContinente = listOf(
            Nivel(
                texto = "Nível 1",
                imagem = R.drawable.lightbulb_filled_42_white,
                onClick = {navController.navigate("jogoDaCapital?indexNivelComeca=0?indexNivelTermina=${nivel1}?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?tituloNivel=Nível 1?desafio=false?todos=false?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}?continuaOndeParou=false")},
                dificuldade = 1,
                desativadoAtivado = desativaAtivaNivel(niveisCapitais.americaDoNorteECentral, 1)
            ),
            Nivel(
                texto = "Nível 2",
                imagem = R.drawable.lightbulb_filled_42_white,
                onClick = {navController.navigate("jogoDaCapital?indexNivelComeca=${nivel1}?indexNivelTermina=${nivel2}?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?tituloNivel=Nível 2?desafio=false?todos=false?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}?continuaOndeParou=false")},
                dificuldade = 1,
                desativadoAtivado = desativaAtivaNivel(niveisCapitais.americaDoNorteECentral, 2)
            ),
            Nivel(
                texto = "Nível 3 - Desafio",
                imagem = R.drawable.heart_filled_42_white,
                onClick = {navController.navigate("jogoDaCapital?indexNivelComeca=0?indexNivelTermina=${nivel2}?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?tituloNivel=Nível 3?desafio=true?todos=false?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}?continuaOndeParou=false")},
                dificuldade = 2,
                desativadoAtivado = desativaAtivaNivel(niveisCapitais.americaDoNorteECentral, 1)
            ),
            Nivel(
                texto = "Nível 4",
                imagem = R.drawable.lightbulb_filled_42_white,
                onClick = {navController.navigate("jogoDaCapital?indexNivelComeca=${nivel2}?indexNivelTermina=${nivel3}?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?tituloNivel=Nível 4?desafio=false?todos=false?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}?continuaOndeParou=false")},
                dificuldade = 1,
                desativadoAtivado = desativaAtivaNivel(niveisCapitais.americaDoNorteECentral, 4)
            ),
            Nivel(
                texto = "Nível 5",
                imagem = R.drawable.lightbulb_filled_42_white,
                onClick = {navController.navigate("jogoDaCapital?indexNivelComeca=${nivel3}?indexNivelTermina=${nivel4}?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?tituloNivel=Nível 5?desafio=false?todos=false?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}?continuaOndeParou=false")},
                dificuldade = 1,
                desativadoAtivado = desativaAtivaNivel(niveisCapitais.americaDoNorteECentral, 5)
            ),
            Nivel(
                texto = "Nível 6 - Desafio Final",
                imagem = R.drawable.heart_filled_42_white,
                onClick = {navController.navigate("jogoDaCapital?indexNivelComeca=0?indexNivelTermina=${nivel4}?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?tituloNivel=Nível 6?desafio=true?todos=false?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}?continuaOndeParou=false")},
                dificuldade = 3,
                desativadoAtivado = desativaAtivaNivel(niveisCapitais.americaDoNorteECentral, 1)
            )
        )
    }

    if (continente == "america do sul") {
        listaPaisesContinente = listOf(
            Nivel(
                texto = "Nível 1",
                imagem = R.drawable.lightbulb_filled_42_white,
                onClick = { navController.navigate("jogoDaCapital?indexNivelComeca=0?indexNivelTermina=14?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?tituloNivel=Nível 1?desafio=false?todos=false?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}?continuaOndeParou=false") },
                dificuldade = 1,
                desativadoAtivado = desativaAtivaNivel(niveisCapitais.americaDoSul, 1)
            ),
            Nivel(
                texto = "Nível 2 - Desafio Final",
                imagem = R.drawable.heart_filled_42_white,
                onClick = {
                    navController.navigate("jogoDaCapital?indexNivelComeca=0?indexNivelTermina=14?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?tituloNivel=Nível 2?desafio=true?todos=false?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}?continuaOndeParou=false")
                },
                dificuldade = 3,
                desativadoAtivado = desativaAtivaNivel(niveisCapitais.americaDoSul, 1)
            ),
        )
    }

    if (continente == "asia") {
        listaPaisesContinente = listOf(
            Nivel(
                texto = "Nível 1",
                imagem = R.drawable.lightbulb_filled_42_white,
                onClick = {navController.navigate("jogoDaCapital?indexNivelComeca=0?indexNivelTermina=12?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?tituloNivel=Nível 1?desafio=false?todos=false?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}?continuaOndeParou=false")},
                dificuldade = 1,
                desativadoAtivado = desativaAtivaNivel(niveisCapitais.asia, 1)
            ),
            Nivel(
                texto = "Nível 2",
                imagem = R.drawable.lightbulb_filled_42_white,
                onClick = {navController.navigate("jogoDaCapital?indexNivelComeca=12?indexNivelTermina=24?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?tituloNivel=Nível 2?desafio=false?todos=false?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}?continuaOndeParou=false")},
                dificuldade = 1,
                desativadoAtivado = desativaAtivaNivel(niveisCapitais.asia, 2)
            ),
            Nivel(
                texto = "Nível 3 - Desafio",
                imagem = R.drawable.heart_filled_42_white,
                onClick = {navController.navigate("jogoDaCapital?indexNivelComeca=0?indexNivelTermina=24?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?tituloNivel=Nível 3?desafio=true?todos=false?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}?continuaOndeParou=false")},
                dificuldade = 2,
                desativadoAtivado = desativaAtivaNivel(niveisCapitais.asia, 1)
            ),
            Nivel(
                texto = "Nível 4",
                imagem = R.drawable.lightbulb_filled_42_white,
                onClick = {navController.navigate("jogoDaCapital?indexNivelComeca=24?indexNivelTermina=37?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?tituloNivel=Nível 4?desafio=false?todos=false?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}?continuaOndeParou=false")},
                dificuldade = 1,
                desativadoAtivado = desativaAtivaNivel(niveisCapitais.asia, 4)
            ),
            Nivel(
                texto = "Nível 5",
                imagem = R.drawable.lightbulb_filled_42_white,
                onClick = {navController.navigate("jogoDaCapital?indexNivelComeca=37?indexNivelTermina=50?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?tituloNivel=Nível 5?desafio=false?todos=false?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}?continuaOndeParou=false")},
                dificuldade = 1,
                desativadoAtivado = desativaAtivaNivel(niveisCapitais.asia, 5)
            ),
            Nivel(
                texto = "Nível 6 - Desafio Final",
                imagem = R.drawable.heart_filled_42_white,
                onClick = {navController.navigate("jogoDaCapital?indexNivelComeca=0?indexNivelTermina=50?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?tituloNivel=Nível 6?desafio=true?todos=false?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}?continuaOndeParou=false")},
                dificuldade = 3,
                desativadoAtivado = desativaAtivaNivel(niveisCapitais.asia, 1)
            )
        )
    }

    if (continente == "europa") {
        listaPaisesContinente = listOf(
            Nivel(
                texto = "Nível 1",
                imagem = R.drawable.lightbulb_filled_42_white,
                onClick = { navController.navigate("jogoDaCapital?indexNivelComeca=0?indexNivelTermina=13?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?tituloNivel=Nível 1?desafio=false?todos=false?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}?continuaOndeParou=false") },
                dificuldade = 1,
                desativadoAtivado = desativaAtivaNivel(niveisCapitais.europa, 1)
            ),
            Nivel(
                texto = "Nivel 2",
                imagem = R.drawable.lightbulb_filled_42_white,
                onClick = {                     //jogoDaCapital?indexNivelComeca={indexNivelComeca}?indexNivelTermina={indexNivelTermina}?continente={continente}?tituloJogo={tituloJogo}?tituloContinente={tituloContinente}?tituloNivel={tituloNivel}?desafio={desafio}?todos={todos}?jogoPais={jogoPais}?jogoBandeira={jogoBandeira}?continuaOndeParou={continuaOndeParou}
                    navController.navigate("jogoDaCapital?indexNivelComeca=13?indexNivelTermina=26?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?tituloNivel=Nível 2?desafio=false?todos=false?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}?continuaOndeParou=false")
                },
                dificuldade = 1,
                desativadoAtivado = desativaAtivaNivel(niveisCapitais.europa, 2)
            ),
            Nivel(
                texto = "Desafio 1",
                imagem = R.drawable.heart_filled_42_white,
                onClick = {
                    navController.navigate("jogoDaCapital?indexNivelComeca=0?indexNivelTermina=26?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?tituloNivel=Desafio?desafio=true?todos=false?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}?continuaOndeParou=false")
                },
                dificuldade = 2,
                desativadoAtivado = desativaAtivaNivel(niveisCapitais.europa, 1)
            ),
            Nivel(
                texto = "Nivel 3",
                imagem = R.drawable.lightbulb_filled_42_white,
                onClick = {
                    navController.navigate("jogoDaCapital?indexNivelComeca=26?indexNivelTermina=39?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?tituloNivel=Nível 3?desafio=false?todos=false?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}?continuaOndeParou=false")
                },
                dificuldade = 1,
                desativadoAtivado = desativaAtivaNivel(niveisCapitais.europa, 4)
            ),
            Nivel(
                texto = "Nivel 4",
                imagem = R.drawable.lightbulb_filled_42_white,
                onClick = {
                    navController.navigate("jogoDaCapital?indexNivelComeca=39?indexNivelTermina=53?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?tituloNivel=Nível 4?desafio=false?todos=false?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}?continuaOndeParou=false")
                },
                dificuldade = 1,
                desativadoAtivado = desativaAtivaNivel(niveisCapitais.europa, 5)
            ),
            Nivel(
                texto = "Desafio Final",
                imagem = R.drawable.heart_filled_42_white,
                onClick = {
                    navController.navigate("jogoDaCapital?indexNivelComeca=0?indexNivelTermina=53?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?tituloNivel=Desafio Final?desafio=true?todos=false?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}?continuaOndeParou=false")
                },
                dificuldade = 3,
                desativadoAtivado = desativaAtivaNivel(niveisCapitais.europa, 1)
            )
        )
    }

    if (continente == "oceania") {
        listaPaisesContinente = listOf(
            Nivel(
                texto = "Nível 1",
                imagem = R.drawable.lightbulb_filled_42_white,
                onClick = { navController.navigate("jogoDaCapital?indexNivelComeca=0?indexNivelTermina=13?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?tituloNivel=Nível 1?desafio=false?todos=false?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}?continuaOndeParou=false") },
                dificuldade = 1,
                desativadoAtivado = desativaAtivaNivel(niveisCapitais.oceania, 1)
            ),
            Nivel(
                texto = "Nivel 2",
                imagem = R.drawable.lightbulb_filled_42_white,
                onClick = {
                    navController.navigate("jogoDaCapital?indexNivelComeca=13?indexNivelTermina=27?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?tituloNivel=Nível 2?desafio=false?todos=false?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}?continuaOndeParou=false")
                },
                dificuldade = 1,
                desativadoAtivado = desativaAtivaNivel(niveisCapitais.oceania, 2)
            ),
            Nivel(
                texto = "Nível 3 - Desafio Final",
                imagem = R.drawable.heart_filled_42_white,
                onClick = {
                    navController.navigate("jogoDaCapital?indexNivelComeca=0?indexNivelTermina=27?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?tituloNivel=Nível 3?desafio=true?todos=false?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}?continuaOndeParou=false")
                },
                dificuldade = 3,
                desativadoAtivado = desativaAtivaNivel(niveisCapitais.oceania, 1)
            ),
        )
    }

    // TODO Lista completa dos Níveis de todos os paises
    if (continente == "all") {
        listaPaisesContinente = listOf(
            Nivel(
                texto = "Nível 1 - Desafio Final",
                imagem = R.drawable.heart_filled_42_white,
                onClick = {
                    navController.navigate("jogoDaCapital?indexNivelComeca=0?indexNivelTermina=246?continente=${continente}?tituloJogo=${tituloJogo}?tituloContinente=${tituloContinente}?tituloNivel=Nível 1?desafio=true?todos=true?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}?continuaOndeParou=false")
                },
                dificuldade = 3,
                desativadoAtivado = desativaAtivaNivel(niveisCapitais.todosOsPaises, 1)
            ),
        )
    }
    // Retorna a lista preenchida
    return listaPaisesContinente
}

fun desativaAtivaNivel(nivelDoUsuario: Int, nivelNecessario: Int): Boolean {
    if (nivelDoUsuario + 1 >= nivelNecessario)
        return true
    else return false
}