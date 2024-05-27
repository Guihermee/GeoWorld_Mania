package br.com.fiap.geoworldmania.repository

import android.content.Context
import br.com.fiap.geoworldmania.dao.UsuarioDb
import br.com.fiap.geoworldmania.model.ContinuaDeOndeParou

class ContinuarDeOndeParouRepository(context: Context) {
    val db = UsuarioDb.getDataBase(context).continuaDeOndeParouDao()

    fun salvar(continuaDeOndeParou: ContinuaDeOndeParou):Long {
        return db.salvarContinua(continuaDeOndeParou)
    }

    fun atualizar(continuaDeOndeParou: ContinuaDeOndeParou): Int {
        return db.atualizarContinua(continuaDeOndeParou)
    }

    fun deletar(continuaDeOndeParou: ContinuaDeOndeParou): Int {
        return db.deletarContinua(continuaDeOndeParou)
    }

    fun listarContinuaDeOndeParou(): List<ContinuaDeOndeParou> {
        return db.listarContinuaDeOndeParou()
    }

    fun listarContinuaDeOndeParouById(id: Long): ContinuaDeOndeParou {
        return db.listarContinuaDeOndeParouById(id)
    }

}