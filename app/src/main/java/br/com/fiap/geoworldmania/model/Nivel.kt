package br.com.fiap.geoworldmania.model

data class Nivel(
    val texto: String = "",
    val imagem: Int = 0,
    val onClick: () -> Unit,
    val dificuldade: Int = 0,
    val continente: String = "",
    val desativadoAtivado: Boolean
)
