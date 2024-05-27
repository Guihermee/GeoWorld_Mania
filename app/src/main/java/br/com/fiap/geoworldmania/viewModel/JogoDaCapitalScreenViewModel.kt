package br.com.fiap.geoworldmania.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.fiap.geoworldmania.model.Pais
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStreamWriter
import java.nio.charset.StandardCharsets

class JogoDaCapitalScreenViewModel : ViewModel() {

    private val _listaPaisAleatorioState = MutableLiveData<List<Pais>>()
    val listaPaisAleatorioState: LiveData<List<Pais>> = _listaPaisAleatorioState

    private val _nivel01 = MutableLiveData<List<Pais>>()
    val nivel01: LiveData<List<Pais>> = _nivel01

    private val _indexAtual = MutableLiveData<Int>()
    val indexAtual: LiveData<Int> = _indexAtual

    private val _acertos = MutableLiveData<Int>()
    val acertos: LiveData<Int> = _acertos

    private val _erros = MutableLiveData<Int>()
    val erros: LiveData<Int> = _erros

    private val _listaDeContineteState = MutableLiveData<List<Pais>>()
    val listaDeContinente: LiveData<List<Pais>> = _listaDeContineteState

    private val _iniciarJogo = MutableLiveData<Boolean>()
    val iniciarJogo: LiveData<Boolean> = _iniciarJogo

    private val _heart01 = MutableLiveData<Boolean>()
    val heart01: LiveData<Boolean> = _heart01

    private val _heart02 = MutableLiveData<Boolean>()
    val heart02: LiveData<Boolean> = _heart02

    private val _heart03 = MutableLiveData<Boolean>()
    val heart03: LiveData<Boolean> = _heart03

//    fun onListaPaisAleatorioStateChange(novaListaAleatoria: List<Pais>) {
//        _listaPaisAleatorioState.value = novaListaAleatoria
//    }

    fun onIniciarJogoChange(novoBoolean: Boolean) {
        _iniciarJogo.value = novoBoolean
    }

    fun onHeart01Change(novoBoolean: Boolean) {
        _heart01.value = novoBoolean
    }

    fun onHeart02Change(novoBoolean: Boolean) {
        _heart02.value = novoBoolean
    }

    fun onHeart03Change(novoBoolean: Boolean) {
        _heart03.value = novoBoolean
    }

    fun adicionarPaisCorreto(pais: Pais) {
        val listaAtual = _listaPaisAleatorioState.value.orEmpty().toMutableList()
        listaAtual.add(pais)
        _listaPaisAleatorioState.value = listaAtual
    }

    fun embaralharPaisesAleatorios() {
        val paisesAleatorios = _listaPaisAleatorioState.value.orEmpty().toMutableList()
        paisesAleatorios.shuffle()
        _listaPaisAleatorioState.value = paisesAleatorios
    }

    fun apagarListaPais(){
        _listaPaisAleatorioState.value = emptyList()
    }

    fun encherPaisesAleatorios(listaDeContinente: List<Pais>, listadePais: List<Pais>, proxIndex: Int) {

        var proxIndexSeguro = proxIndex

        if (proxIndex > listadePais.count() - 1)
            proxIndexSeguro = proxIndex - 1

        //Este nome foi mudado removendo o "de" para ter um nome parecido com a lista recebida do parametro
        val listaContinente = listaDeContinente.toMutableList()
        val paisARemover = listadePais[proxIndexSeguro]
        listaContinente.remove(paisARemover)

        val paisesAleatorios = listaContinente.shuffled().take(3).toMutableList()
        _listaPaisAleatorioState.value = paisesAleatorios
    }

    fun saberQualProxPais(pais: Pais, listaDePais: List<Pais>): Int {
        val paisesAleatorios = listaDePais.toMutableList()
        val index = paisesAleatorios.indexOf(pais)
        return index + 1
    }

    fun onNivel01Change(novoNivel01: List<Pais>) {
        _nivel01.value = novoNivel01
    }

    fun proximoPais() {
        _indexAtual.value = (_indexAtual.value ?: 0) + 1
    }

    fun adicionarAcerto() {
        _acertos.value = (_acertos.value ?: 0) + 1
    }

    fun adicionarErro() {
        _erros.value = (_erros.value ?: 0) + 1
    }

    fun onListaDeContinenteStateChange(novaLista: List<Pais>) {
        _listaDeContineteState.value = novaLista
    }

}