package br.com.fiap.geoworldmania.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.fiap.geoworldmania.R

@Entity(tableName = "tbl_usuario")
data class Usuario(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val nome: String = "",
    val email: String = "",
    val imagem: Int = R.drawable.user_image,
    val nivel: Int = 0,
    @ColumnInfo("descricao_nivel") val descricaoNivel: String = "Iniciante",
    val acertos: Int = 0,
    val erros: Int = 0
)
