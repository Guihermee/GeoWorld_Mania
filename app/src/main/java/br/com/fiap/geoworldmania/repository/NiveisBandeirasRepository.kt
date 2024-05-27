package br.com.fiap.geoworldmania.repository

import android.content.Context
import br.com.fiap.geoworldmania.dao.UsuarioDb
import br.com.fiap.geoworldmania.model.NiveisBandeiras

class NiveisBandeirasRepository(context: Context) {
    val db = UsuarioDb.getDataBase(context).niveisBandeirasDao()

    fun salvar(niveisBandeiras: NiveisBandeiras): Long {
        return db.salvar(niveisBandeiras)
    }

    fun atualizar(niveisBandeiras: NiveisBandeiras): Int {
        return db.atualizar(niveisBandeiras)
    }

    fun deletar(niveisBandeiras: NiveisBandeiras): Int {
        return db.deletar(niveisBandeiras)
    }

    fun listarNiveisBandeiras(): List<NiveisBandeiras> {
        return db.listarNiveisBandeiras()
    }

    fun buscarNiveisBandeirasPorId(id: Long): NiveisBandeiras {
        return db.buscarNiveisBandeirasPorId(id)
    }

}