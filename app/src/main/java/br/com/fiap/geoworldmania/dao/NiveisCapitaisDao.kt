package br.com.fiap.geoworldmania.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import br.com.fiap.geoworldmania.model.NiveisCapitais

@Dao
interface NiveisCapitaisDao {

    @Insert
    fun salvar(niveisCapitais: NiveisCapitais): Long

    @Update
    fun atualizar(niveisCapitais: NiveisCapitais): Int

    @Delete
    fun deletar(niveisCapitais: NiveisCapitais): Int

    @Query("SELECT * FROM TBL_NIVEIS_CAPITAIS")
    fun listarNiveisCapitais(): List<NiveisCapitais>

    @Query("SELECT * FROM tbl_niveis_capitais WHERE id = :id")
    fun buscarNiveisCapitaisPorId(id: Long): NiveisCapitais
}