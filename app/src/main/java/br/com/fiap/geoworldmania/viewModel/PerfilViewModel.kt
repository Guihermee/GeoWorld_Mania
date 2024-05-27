package br.com.fiap.geoworldmania.viewModel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.fiap.geoworldmania.model.ContinuaDeOndeParou
import br.com.fiap.geoworldmania.model.NiveisBandeiras
import br.com.fiap.geoworldmania.model.NiveisCapitais
import br.com.fiap.geoworldmania.model.NiveisPaises
import br.com.fiap.geoworldmania.model.Pais
import br.com.fiap.geoworldmania.model.Usuario
import br.com.fiap.geoworldmania.repository.ContinuarDeOndeParouRepository
import br.com.fiap.geoworldmania.repository.NiveisBandeirasRepository
import br.com.fiap.geoworldmania.repository.NiveisCapitaisRepository
import br.com.fiap.geoworldmania.repository.NiveisPaisesRepository
import br.com.fiap.geoworldmania.repository.UsuarioRepository

class PerfilViewModel : ViewModel() {
    private val _usuario = MutableLiveData<Usuario>()
    val usuario: LiveData<Usuario> = _usuario


    fun OnErrosAcertosChanged(acertos: Int, erros: Int, context: Context) {

        val usuarioRepository = UsuarioRepository(context = context)
        val user = usuarioRepository.db.buscarUsuarioPeloId(1)

        usuarioRepository.db.atualizar(
            Usuario(
                id = 1,
                acertos = user.acertos + acertos,
                erros = user.erros + erros
            )
        )
    }

    fun resetadbContinuaDeOndeParou(context: Context) {
        val continuarDeOndeParouRepository = ContinuarDeOndeParouRepository(context)
        val newContinuaDeOndeParou = ContinuaDeOndeParou()
        continuarDeOndeParouRepository.db.atualizarContinua(newContinuaDeOndeParou)
    }

    fun atualizarDbContinuaDeOndeParou(
        context: Context,
        listaDePais: List<Pais>,
        listaDoContinente: List<Pais>,
        desafio: Boolean,
        continente: String,
        tituloJogo: String,
        tituloContinente: String,
        tituloNivel: String,
        jogoPais: Boolean,
        jogoBandeira: Boolean,
        erros: Int,
        acertos: Int,
        todos: Boolean
    ) {
        // Instância do Repository
        val continuarDeOndeParouRepository = ContinuarDeOndeParouRepository(context)

        val continuaDeOndeParou = ContinuaDeOndeParou(
            id = 1,
            listaDePais = listaDePais,
            listaDoContinente = listaDoContinente,
            desafio = desafio,
            continente = continente,
            tituloJogo = tituloJogo,
            tituloContinente = tituloContinente,
            tituloNivel = tituloNivel,
            jogoPais = jogoPais,
            jogoBandeira = jogoBandeira,
            erros = erros,
            acertos = acertos,
            todos = todos,
            podeUsar = true
        )

        continuarDeOndeParouRepository.db.atualizarContinua(continuaDeOndeParou)

    }

    fun atualizarListaDePaisesDbContinuaOndeParou(
        context: Context,
        listaDePais: List<Pais>,
        pais: Pais
    ) {
        val continuarDeOndeParouRepository = ContinuarDeOndeParouRepository(context)
        val continuaDeOndeParou = continuarDeOndeParouRepository.listarContinuaDeOndeParouById(1)

        val listaDePaisAtualizada = listaDePais.toMutableList().apply { remove(pais) }.toList()

        continuarDeOndeParouRepository.db.atualizarContinua(
            ContinuaDeOndeParou(
                id = 1,
                listaDePais = listaDePaisAtualizada,
                listaDoContinente = continuaDeOndeParou.listaDoContinente,
                desafio = continuaDeOndeParou.desafio,
                continente = continuaDeOndeParou.continente,
                tituloJogo = continuaDeOndeParou.tituloJogo,
                tituloContinente = continuaDeOndeParou.tituloContinente,
                tituloNivel = continuaDeOndeParou.tituloNivel,
                jogoPais = continuaDeOndeParou.jogoPais,
                jogoBandeira = continuaDeOndeParou.jogoBandeira,
                erros = continuaDeOndeParou.erros,
                acertos = continuaDeOndeParou.acertos,
                todos = continuaDeOndeParou.todos,
                podeUsar = continuaDeOndeParou.podeUsar
            )
        )

    }

    fun addErroDbContinuaDeOndeParou(context: Context) {
        val continuarDeOndeParouRepository = ContinuarDeOndeParouRepository(context)
        val continuaDeOndeParou = continuarDeOndeParouRepository.listarContinuaDeOndeParouById(1)

        continuarDeOndeParouRepository.db.atualizarContinua(
            ContinuaDeOndeParou(
                id = 1,
                listaDePais = continuaDeOndeParou.listaDePais,
                listaDoContinente = continuaDeOndeParou.listaDoContinente,
                desafio = continuaDeOndeParou.desafio,
                continente = continuaDeOndeParou.continente,
                tituloJogo = continuaDeOndeParou.tituloJogo,
                tituloContinente = continuaDeOndeParou.tituloContinente,
                tituloNivel = continuaDeOndeParou.tituloNivel,
                jogoPais = continuaDeOndeParou.jogoPais,
                jogoBandeira = continuaDeOndeParou.jogoBandeira,
                erros = continuaDeOndeParou.erros + 1,
                acertos = continuaDeOndeParou.acertos,
                todos = continuaDeOndeParou.todos,
                podeUsar = continuaDeOndeParou.podeUsar
            )
        )
    }

    fun addAcertoDbContinuaDeOndeParou(context: Context) {
        val continuarDeOndeParouRepository = ContinuarDeOndeParouRepository(context)
        val continuaDeOndeParou = continuarDeOndeParouRepository.listarContinuaDeOndeParouById(1)

        continuarDeOndeParouRepository.db.atualizarContinua(
            ContinuaDeOndeParou(
                id = 1,
                listaDePais = continuaDeOndeParou.listaDePais,
                listaDoContinente = continuaDeOndeParou.listaDoContinente,
                desafio = continuaDeOndeParou.desafio,
                continente = continuaDeOndeParou.continente,
                tituloJogo = continuaDeOndeParou.tituloJogo,
                tituloContinente = continuaDeOndeParou.tituloContinente,
                tituloNivel = continuaDeOndeParou.tituloNivel,
                jogoPais = continuaDeOndeParou.jogoPais,
                jogoBandeira = continuaDeOndeParou.jogoBandeira,
                erros = continuaDeOndeParou.erros,
                acertos = continuaDeOndeParou.acertos + 1,
                todos = continuaDeOndeParou.todos,
                podeUsar = continuaDeOndeParou.podeUsar
            )
        )
    }

    fun addErroInDb(context: Context) {
        val usuarioRepository = UsuarioRepository(context = context)
        val user = usuarioRepository.db.buscarUsuarioPeloId(1)

        usuarioRepository.db.atualizar(
            Usuario(
                id = 1,
                nome = user.nome,
                email = user.email,
                imagem = user.imagem,
                nivel = user.nivel,
                descricaoNivel = user.descricaoNivel,
                acertos = user.acertos,
                erros = user.erros + 1
            )
        )
    }

    fun addAcertoInDb(context: Context) {
        val usuarioRepository = UsuarioRepository(context = context)
        val user = usuarioRepository.db.buscarUsuarioPeloId(1)

        usuarioRepository.db.atualizar(
            Usuario(
                id = 1,
                nome = user.nome,
                email = user.email,
                imagem = user.imagem,
                nivel = user.nivel,
                descricaoNivel = user.descricaoNivel,
                acertos = user.acertos + 1,
                erros = user.erros
            )
        )
    }

    fun onNiveisCapitaisChanged(context: Context, continente: String, nivel: String): Int {

        val niveisCapitaisRepository = NiveisCapitaisRepository(context = context)
        var nivelAtual = obterNivel(nivel)
        var niveisCapitais = niveisCapitaisRepository.db.buscarNiveisCapitaisPorId(1)

        return when (continente) {
            "africa" -> {
                niveisCapitaisRepository.db.atualizar(
                    NiveisCapitais(
                        id = 1,
                        africa = nivelAtual,
                        americaDoNorteECentral = niveisCapitais.americaDoNorteECentral,
                        americaDoSul = niveisCapitais.americaDoSul,
                        asia = niveisCapitais.asia,
                        europa = niveisCapitais.europa,
                        oceania = niveisCapitais.oceania,
                        todosOsPaises = niveisCapitais.todosOsPaises
                    )
                )
            }

            "America do Norte e Central" -> {
                niveisCapitaisRepository.db.atualizar(
                    NiveisCapitais(
                        id = 1,
                        africa = niveisCapitais.africa,
                        americaDoNorteECentral = nivelAtual,
                        americaDoSul = niveisCapitais.americaDoSul,
                        asia = niveisCapitais.asia,
                        europa = niveisCapitais.europa,
                        oceania = niveisCapitais.oceania,
                        todosOsPaises = niveisCapitais.todosOsPaises
                    )
                )
            }

            "america do sul" -> {
                niveisCapitaisRepository.db.atualizar(
                    NiveisCapitais(
                        id = 1,
                        africa = niveisCapitais.africa,
                        americaDoNorteECentral = niveisCapitais.americaDoNorteECentral,
                        americaDoSul = nivelAtual,
                        asia = niveisCapitais.asia,
                        europa = niveisCapitais.europa,
                        oceania = niveisCapitais.oceania,
                        todosOsPaises = niveisCapitais.todosOsPaises
                    )
                )
            }

            "asia" -> {
                niveisCapitaisRepository.db.atualizar(
                    NiveisCapitais(
                        id = 1,
                        africa = niveisCapitais.africa,
                        americaDoNorteECentral = niveisCapitais.americaDoNorteECentral,
                        americaDoSul = niveisCapitais.americaDoSul,
                        asia = nivelAtual,
                        europa = niveisCapitais.europa,
                        oceania = niveisCapitais.oceania,
                        todosOsPaises = niveisCapitais.todosOsPaises
                    )
                )
            }

            "europa" -> {
                niveisCapitaisRepository.db.atualizar(
                    NiveisCapitais(
                        id = 1,
                        africa = niveisCapitais.africa,
                        americaDoNorteECentral = niveisCapitais.americaDoNorteECentral,
                        americaDoSul = niveisCapitais.americaDoSul,
                        asia = niveisCapitais.asia,
                        europa = nivelAtual,
                        oceania = niveisCapitais.oceania,
                        todosOsPaises = niveisCapitais.todosOsPaises
                    )
                )
            }

            "oceania" -> {
                niveisCapitaisRepository.db.atualizar(
                    NiveisCapitais(
                        id = 1,
                        africa = niveisCapitais.africa,
                        americaDoNorteECentral = niveisCapitais.americaDoNorteECentral,
                        americaDoSul = niveisCapitais.americaDoSul,
                        asia = niveisCapitais.asia,
                        europa = niveisCapitais.europa,
                        oceania = nivelAtual,
                        todosOsPaises = niveisCapitais.todosOsPaises
                    )
                )
            }

            "all" -> {
                niveisCapitaisRepository.db.atualizar(
                    NiveisCapitais(
                        id = 1,
                        africa = niveisCapitais.africa,
                        americaDoNorteECentral = niveisCapitais.americaDoNorteECentral,
                        americaDoSul = niveisCapitais.americaDoSul,
                        asia = niveisCapitais.asia,
                        europa = niveisCapitais.europa,
                        oceania = niveisCapitais.oceania,
                        todosOsPaises = nivelAtual
                    )
                )
            }

            else -> 0
        }

    }

    fun onNiveisBandeirasChanged(context: Context, continente: String, nivel: String): Int {

        val niveisBandeirasRepository = NiveisBandeirasRepository(context = context)
        var nivelAtual = obterNivel(nivel)
        var niveisBandeiras = niveisBandeirasRepository.buscarNiveisBandeirasPorId(1)

        return when (continente) {
            "Africa" -> {
                niveisBandeirasRepository.db.atualizar(
                    NiveisBandeiras(
                        id = 1,
                        africa = nivelAtual,
                        americaDoNorteECentral = niveisBandeiras.americaDoNorteECentral,
                        americaDoSul = niveisBandeiras.americaDoSul,
                        asia = niveisBandeiras.asia,
                        europa = niveisBandeiras.europa,
                        oceania = niveisBandeiras.oceania,
                        todosOsPaises = niveisBandeiras.todosOsPaises
                    )
                )
            }

            "America do Norte e Central" -> {
                niveisBandeirasRepository.db.atualizar(
                    NiveisBandeiras(
                        id = 1,
                        africa = niveisBandeiras.africa,
                        americaDoNorteECentral = nivelAtual,
                        americaDoSul = niveisBandeiras.americaDoSul,
                        asia = niveisBandeiras.asia,
                        europa = niveisBandeiras.europa,
                        oceania = niveisBandeiras.oceania,
                        todosOsPaises = niveisBandeiras.todosOsPaises
                    )
                )
            }

            "america do sul" -> {
                niveisBandeirasRepository.db.atualizar(
                    NiveisBandeiras(
                        id = 1,
                        africa = niveisBandeiras.africa,
                        americaDoNorteECentral = niveisBandeiras.americaDoNorteECentral,
                        americaDoSul = nivelAtual,
                        asia = niveisBandeiras.asia,
                        europa = niveisBandeiras.europa,
                        oceania = niveisBandeiras.oceania,
                        todosOsPaises = niveisBandeiras.todosOsPaises
                    )
                )
            }

            "asia" -> {
                niveisBandeirasRepository.db.atualizar(
                    NiveisBandeiras(
                        id = 1,
                        africa = niveisBandeiras.africa,
                        americaDoNorteECentral = niveisBandeiras.americaDoNorteECentral,
                        americaDoSul = niveisBandeiras.americaDoSul,
                        asia = nivelAtual,
                        europa = niveisBandeiras.europa,
                        oceania = niveisBandeiras.oceania,
                        todosOsPaises = niveisBandeiras.todosOsPaises
                    )
                )
            }

            "europa" -> {
                niveisBandeirasRepository.db.atualizar(
                    NiveisBandeiras(
                        id = 1,
                        africa = niveisBandeiras.africa,
                        americaDoNorteECentral = niveisBandeiras.americaDoNorteECentral,
                        americaDoSul = niveisBandeiras.americaDoSul,
                        asia = niveisBandeiras.asia,
                        europa = nivelAtual,
                        oceania = niveisBandeiras.oceania,
                        todosOsPaises = niveisBandeiras.todosOsPaises
                    )
                )
            }

            "oceania" -> {
                niveisBandeirasRepository.db.atualizar(
                    NiveisBandeiras(
                        id = 1,
                        africa = niveisBandeiras.africa,
                        americaDoNorteECentral = niveisBandeiras.americaDoNorteECentral,
                        americaDoSul = niveisBandeiras.americaDoSul,
                        asia = niveisBandeiras.asia,
                        europa = niveisBandeiras.europa,
                        oceania = nivelAtual,
                        todosOsPaises = niveisBandeiras.todosOsPaises
                    )
                )
            }

            "all" -> {
                niveisBandeirasRepository.db.atualizar(
                    NiveisBandeiras(
                        id = 1,
                        africa = niveisBandeiras.africa,
                        americaDoNorteECentral = niveisBandeiras.americaDoNorteECentral,
                        americaDoSul = niveisBandeiras.americaDoSul,
                        asia = niveisBandeiras.asia,
                        europa = niveisBandeiras.europa,
                        oceania = niveisBandeiras.oceania,
                        todosOsPaises = nivelAtual
                    )
                )
            }

            else -> 0
        }

    }

    fun onNiveisPaisesChanged(context: Context, continente: String, nivel: String): Int {

        val niveisPaisesRepository = NiveisPaisesRepository(context = context)
        var nivelAtual = obterNivel(nivel)
        var niveisPaises = niveisPaisesRepository.buscarNiveisPaisesPorId(1)

        return when (continente) {
            "Africa" -> {
                niveisPaisesRepository.db.atualizar(
                    NiveisPaises(
                        id = 1,
                        africa = nivelAtual,
                        americaDoNorteECentral = niveisPaises.americaDoNorteECentral,
                        americaDoSul = niveisPaises.americaDoSul,
                        asia = niveisPaises.asia,
                        europa = niveisPaises.europa,
                        oceania = niveisPaises.oceania,
                        todosOsPaises = niveisPaises.todosOsPaises
                    )
                )
            }

            "America do Norte e Central" -> {
                niveisPaisesRepository.db.atualizar(
                    NiveisPaises(
                        id = 1,
                        africa = niveisPaises.africa,
                        americaDoNorteECentral = nivelAtual,
                        americaDoSul = niveisPaises.americaDoSul,
                        asia = niveisPaises.asia,
                        europa = niveisPaises.europa,
                        oceania = niveisPaises.oceania,
                        todosOsPaises = niveisPaises.todosOsPaises
                    )
                )
            }

            "america do sul" -> {
                niveisPaisesRepository.db.atualizar(
                    NiveisPaises(
                        id = 1,
                        africa = niveisPaises.africa,
                        americaDoNorteECentral = niveisPaises.americaDoNorteECentral,
                        americaDoSul = nivelAtual,
                        asia = niveisPaises.asia,
                        europa = niveisPaises.europa,
                        oceania = niveisPaises.oceania,
                        todosOsPaises = niveisPaises.todosOsPaises
                    )
                )
            }

            "asia" -> {
                niveisPaisesRepository.db.atualizar(
                    NiveisPaises(
                        id = 1,
                        africa = niveisPaises.africa,
                        americaDoNorteECentral = niveisPaises.americaDoNorteECentral,
                        americaDoSul = niveisPaises.americaDoSul,
                        asia = nivelAtual,
                        europa = niveisPaises.europa,
                        oceania = niveisPaises.oceania,
                        todosOsPaises = niveisPaises.todosOsPaises
                    )
                )
            }

            "europa" -> {
                niveisPaisesRepository.db.atualizar(
                    NiveisPaises(
                        id = 1,
                        africa = niveisPaises.africa,
                        americaDoNorteECentral = niveisPaises.americaDoNorteECentral,
                        americaDoSul = niveisPaises.americaDoSul,
                        asia = niveisPaises.asia,
                        europa = nivelAtual,
                        oceania = niveisPaises.oceania,
                        todosOsPaises = niveisPaises.todosOsPaises
                    )
                )
            }

            "oceania" -> {
                niveisPaisesRepository.db.atualizar(
                    NiveisPaises(
                        id = 1,
                        africa = niveisPaises.africa,
                        americaDoNorteECentral = niveisPaises.americaDoNorteECentral,
                        americaDoSul = niveisPaises.americaDoSul,
                        asia = niveisPaises.asia,
                        europa = niveisPaises.europa,
                        oceania = nivelAtual,
                        todosOsPaises = niveisPaises.todosOsPaises
                    )
                )
            }

            "all" -> {
                niveisPaisesRepository.db.atualizar(
                    NiveisPaises(
                        id = 1,
                        africa = niveisPaises.africa,
                        americaDoNorteECentral = niveisPaises.americaDoNorteECentral,
                        americaDoSul = niveisPaises.americaDoSul,
                        asia = niveisPaises.asia,
                        europa = niveisPaises.europa,
                        oceania = niveisPaises.oceania,
                        todosOsPaises = nivelAtual
                    )
                )
            }

            else -> 0
        }

    }

    fun obterNivel(nivel: String): Int {
        return when (nivel) {
            "Nível 1" -> 1
            "Nível 2" -> 2
            "Nível 3" -> 3
            "Nível 4" -> 4
            "Nível 5" -> 5
            "Nível 6" -> 6
            "Nível 7" -> 7
            "Nível 8" -> 8
            "Nível 9" -> 9
            else -> 0
        }
    }


}