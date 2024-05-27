package br.com.fiap.geoworldmania.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import br.com.fiap.geoworldmania.model.NiveisPaises

@Dao
interface NiveisPaisesDao {

    @Insert
    fun salvar(niveisPaises: NiveisPaises): Long

    @Update
    fun atualizar(niveisPaises: NiveisPaises): Int

    @Delete
    fun deletar(niveisPaises: NiveisPaises): Int

    @Query("SELECT * FROM tbl_niveis_paises")
    fun listarNiveisPaises(): List<NiveisPaises>

    @Query("SELECT * FROM tbl_niveis_paises WHERE id = :id")
    fun buscarNiveisPaisesPorId(id: Long): NiveisPaises
}