package br.com.fiap.geoworldmania.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import br.com.fiap.geoworldmania.model.NiveisBandeiras

@Dao
interface NiveisBandeirasDao {

    @Insert
    fun salvar(niveisBandeiras: NiveisBandeiras): Long

    @Update
    fun atualizar(niveisBandeiras: NiveisBandeiras): Int

    @Delete
    fun deletar(niveisBandeiras: NiveisBandeiras): Int

    @Query("SELECT * FROM tbl_niveis_bandeiras")
    fun listarNiveisBandeiras(): List<NiveisBandeiras>

    @Query("SELECT * FROM tbl_niveis_bandeiras WHERE id = :id")
    fun buscarNiveisBandeirasPorId(id: Long): NiveisBandeiras

}