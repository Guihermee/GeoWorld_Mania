package br.com.fiap.geoworldmania.model

import com.google.gson.annotations.SerializedName

data class Pais(
    @SerializedName("name") val nome: name,
    @SerializedName("capital") val capital: List<String> = listOf(),
    @SerializedName("flags") val bandeira: flagSvg
)

data class name(
    val common: String = ""
)

data class flagSvg(
    var svg: String = ""
)