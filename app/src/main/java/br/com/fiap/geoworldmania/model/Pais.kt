package br.com.fiap.geoworldmania.model

import com.google.gson.annotations.SerializedName

data class PaisTest(
    val nome: String = "",
    val capital: String = "",
    val bandeira: String = "",
    val regiao: String = "",
    val sigla: String = ""
)

data class Pais(
    @SerializedName("translations") val nome: Portugues,
    @SerializedName("capital") val capital: List<String> = listOf(),
    @SerializedName("flags") val bandeira: FlagSvg,
    @SerializedName("region") val regiao: String = "",
    @SerializedName("cca2") val sigla: String = ""
)

data class Portugues(
    @SerializedName("por") val portugues: Nome
)

data class Nome(
    @SerializedName("common") val common: String = ""
)

data class FlagSvg(
    var png: Int = 0
)