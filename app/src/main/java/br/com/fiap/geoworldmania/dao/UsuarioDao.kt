package br.com.fiap.geoworldmania.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import br.com.fiap.geoworldmania.model.Usuario

@Dao
interface UsuarioDao {

    @Insert
    fun salvar(usuario: Usuario): Long

    @Update
    fun atualizar(usuario: Usuario): Int

    @Delete
    fun excluir(usuario: Usuario): Int

    @Query("SELECT * FROM tbl_usuario WHERE id = :id")
    fun buscarUsuarioPeloId(id: Long): Usuario

    @Query("SELECT * FROM TBL_USUARIO")
    fun listarUsuarios(): List<Usuario>

}