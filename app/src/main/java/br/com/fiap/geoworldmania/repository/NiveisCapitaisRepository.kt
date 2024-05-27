package br.com.fiap.geoworldmania.repository

import android.content.Context
import br.com.fiap.geoworldmania.dao.UsuarioDb
import br.com.fiap.geoworldmania.model.NiveisCapitais

class NiveisCapitaisRepository(context: Context) {
    val db = UsuarioDb.getDataBase(context).niveisCapitaisDao()

    fun salvar(niveisCapitais: NiveisCapitais): Long {
        return db.salvar(niveisCapitais = niveisCapitais)
    }

    fun atualizar(niveisCapitais: NiveisCapitais): Int {
        return db.atualizar(niveisCapitais = niveisCapitais)
    }

    fun deletar(niveisCapitais: NiveisCapitais): Int {
        return db.deletar(niveisCapitais = niveisCapitais)
    }

    fun listarNiveisCapitais(): List<NiveisCapitais> {
        return db.listarNiveisCapitais()
    }

    fun buscarNiveisCapitaisPorId(id: Long): NiveisCapitais {
        return db.buscarNiveisCapitaisPorId(id = id)
    }

}