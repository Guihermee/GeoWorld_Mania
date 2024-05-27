package br.com.fiap.geoworldmania.repository

import android.content.Context
import br.com.fiap.geoworldmania.dao.UsuarioDb
import br.com.fiap.geoworldmania.model.Usuario

class UsuarioRepository(context: Context) {
    var db = UsuarioDb.getDataBase(context).usuarioDAO()

    fun salvar(usuario: Usuario): Long {
        return db.salvar(usuario = usuario)
    }

    fun atualizar(usuario: Usuario): Int {
        return db.atualizar(usuario = usuario)
    }

    fun excluir(usuario: Usuario): Int {
        return db.excluir(usuario = usuario)
    }

    fun buscarUsuarioPeloId(id: Long): Usuario {
        return db.buscarUsuarioPeloId(id = id)
    }

    fun listarUsuario(): List<Usuario> {
        return db.listarUsuarios()
    }

}