package br.com.fiap.geoworldmania.repository

import android.content.Context
import br.com.fiap.geoworldmania.dao.UsuarioDb
import br.com.fiap.geoworldmania.model.NiveisCapitais
import br.com.fiap.geoworldmania.model.NiveisPaises

class NiveisPaisesRepository(context: Context) {
    val db = UsuarioDb.getDataBase(context).niveisPaisesDao()

    fun salvar(niveisPaises: NiveisPaises): Long {
        return db.salvar(niveisPaises)
    }

    fun atualizar(niveisPaises: NiveisPaises): Int {
        return db.atualizar(niveisPaises)
    }

    fun deletar(niveisPaises: NiveisPaises): Int {
        return db.deletar(niveisPaises)
    }

    fun listarNiveisPaises(): List<NiveisPaises> {
        return db.listarNiveisPaises()
    }

    fun buscarNiveisPaisesPorId(id: Long): NiveisPaises {
        return db.buscarNiveisPaisesPorId(id)
    }

}