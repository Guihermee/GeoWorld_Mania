package br.com.fiap.geoworldmania.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.intellij.lang.annotations.Identifier

@Entity(tableName = "tbl_continua_de_onde_parou")
data class ContinuaDeOndeParou(

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0, // Sempre 1
    //val pais: List<Pais>, // Lista completa dos paises para ser utilizado

//    @ColumnInfo(name = "opcoes_de_escolha")
//    val opcoesDeEscolha: List<Pais>, // opções de escolha (4)

    @ColumnInfo(name = "lista_de_pais")
    val listaDePais: List<Pais> = listOf(), // lista do nível

//    @ColumnInfo(name = "index_atual")
//    val indexAtual: Int = 0,

    @ColumnInfo(name = "lista_do_continente")
    val listaDoContinente: List<Pais> = listOf(), // Lista do continente completa

    val desafio: Boolean = false,

    val continente: String = "",

    @ColumnInfo(name = "titulo_jogo")
    val tituloJogo: String = "",

    @ColumnInfo(name = "titulo_continente")
    val tituloContinente: String = "",

    @ColumnInfo(name = "titulo_nivel")
    val tituloNivel: String = "",

    @ColumnInfo(name = "jogo_pais")
    val jogoPais: Boolean = false,

    @ColumnInfo(name = "jogo_bandeira")
    val jogoBandeira: Boolean = false,

    val erros: Int = 0,

    val acertos: Int = 0,

    val todos: Boolean = false,

    val podeUsar: Boolean = false
)
