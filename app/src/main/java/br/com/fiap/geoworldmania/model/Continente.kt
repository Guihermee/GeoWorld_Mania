package br.com.fiap.geoworldmania.model

data class Continente(
    val texto: String = "",
    val imagem: Int = 0,
    val onClick: () -> Unit,
    val qtdNivel: Int = 0,
    val cor: Int = 0
)
