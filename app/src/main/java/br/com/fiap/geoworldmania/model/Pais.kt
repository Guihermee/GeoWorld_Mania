package br.com.fiap.geoworldmania.model

import com.google.gson.annotations.SerializedName

data class Pais(
    @SerializedName("translations") val nome: Portugues,
    @SerializedName("capital") val capital: List<String> = listOf(),
    @SerializedName("flags") val bandeira: FlagSvg
)

data class Portugues(
    @SerializedName("por") val portugues: Nome
)

data class Nome(
    @SerializedName("common") val common: String = ""
)

data class FlagSvg(
    var png: String = ""
)