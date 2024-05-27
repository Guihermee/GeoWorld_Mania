package br.com.fiap.geoworldmania.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import br.com.fiap.geoworldmania.model.ContinuaDeOndeParou

@Dao
interface ContinuarDeOndeParouDao {

    @Insert
    fun salvarContinua(ContinuaDeOndeParou: ContinuaDeOndeParou): Long

    @Update
    fun atualizarContinua(continuaDeOndeParou: ContinuaDeOndeParou): Int

    @Delete
    fun deletarContinua(ContinuaDeOndeParou: ContinuaDeOndeParou): Int

    @Query("SELECT * FROM tbl_continua_de_onde_parou")
    fun listarContinuaDeOndeParou(): List<ContinuaDeOndeParou>

    @Query("SELECT * FROM tbl_continua_de_onde_parou WHERE id = :id")
    fun listarContinuaDeOndeParouById(id: Long): ContinuaDeOndeParou

}