package br.com.fiap.geoworldmania.repository

import androidx.navigation.NavController
import br.com.fiap.geoworldmania.R
import br.com.fiap.geoworldmania.model.Continente

fun getAllContinente(
    navController: NavController,
    tituloJogo: String,
    jogoPais: Boolean,
    jogoBandeira: Boolean
): List<Continente> {
    return listOf( // Uma lista com todas as informações de cada Card e sua navegação
        Continente(
            texto = "África",
            imagem = R.drawable.africa,
            onClick = {
                navController.navigate(
                    "opcoesDeNiveis?continente=africa?tituloJogo=${tituloJogo}?tituloContinente=África?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}"
                )
            },
            qtdNivel = 9,
            cor = R.color.rosa
        ),
        Continente(
            texto = "America do norte e Central",
            imagem = R.drawable.america_norte,
            onClick = {
                navController.navigate(
                    "opcoesDeNiveis?continente=America do Norte e Central?tituloJogo=${tituloJogo}?tituloContinente=America Central/Norte?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}"
                )
            },
            qtdNivel = 6,
            cor = R.color.azul_claro
        ),
        Continente(
            texto = "America do Sul",
            imagem = R.drawable.america_do_sul,
            onClick = {
                navController.navigate(
                    "opcoesDeNiveis?continente=america do sul?tituloJogo=${tituloJogo}?tituloContinente=America do Sul?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}"
                )
            },
            qtdNivel = 2,
            cor = R.color.roxo
        ),
        Continente(
            texto = "Asia",
            imagem = R.drawable.asia,
            onClick = {
                navController.navigate(
                    "opcoesDeNiveis?continente=asia?tituloJogo=${tituloJogo}?tituloContinente=Asia?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}"
                )
            },
            qtdNivel = 6,
            cor = R.color.verde_claro
        ),
        Continente(
            texto = "Europa",
            imagem = R.drawable.europa,
            onClick = {
                navController.navigate(
                    "opcoesDeNiveis?continente=europa?tituloJogo=${tituloJogo}?tituloContinente=Europa?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}"
                )
            },
            qtdNivel = 6,
            cor = R.color.amarelomarrom
        ),
        Continente(
            texto = "Oceania",
            imagem = R.drawable.oceania,
            onClick = {
                navController.navigate(
                    "opcoesDeNiveis?continente=oceania?tituloJogo=${tituloJogo}?tituloContinente=Oceania?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}"
                )
            },
            qtdNivel = 3,
            cor = R.color.vermelho
        ),
        Continente(
            texto = "Todos os Países",
            imagem = R.drawable.planeta,
            onClick = {
                navController.navigate(
                    "opcoesDeNiveis?continente=all?tituloJogo=${tituloJogo}?tituloContinente=Todos Países?jogoPais=${jogoPais}?jogoBandeira=${jogoBandeira}"
                )
            },
            qtdNivel = 15,
            cor = R.color.azul_escuro
        )
    )
}