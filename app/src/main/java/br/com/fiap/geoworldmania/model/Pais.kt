package br.com.fiap.geoworldmania.model

import com.google.gson.annotations.SerializedName

data class Pais(
    @SerializedName("name") val nome: name,
    @SerializedName("capital") val capital: List<String> = listOf(),
    @SerializedName("flags") val bandeira: flagSvg
) {
    override fun toString(): String {
        return "Pais(nome='$nome', capital=$capital, bandeira='$bandeira')"
    }
}

data class name(
    val common: String = ""
)

data class flagSvg(
    var svg: String = ""
)