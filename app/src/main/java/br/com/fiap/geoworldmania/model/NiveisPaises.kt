package br.com.fiap.geoworldmania.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_niveis_paises")
data class NiveisPaises(

    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val africa: Int = 0,
    @ColumnInfo("america_do_norte_e_central") val americaDoNorteECentral: Int = 0,
    @ColumnInfo("america_do_sul") val americaDoSul: Int = 0,
    val asia: Int = 0,
    val europa: Int = 0,
    val oceania: Int = 0,
    @ColumnInfo("todos_os_paises") val todosOsPaises: Int = 0
)