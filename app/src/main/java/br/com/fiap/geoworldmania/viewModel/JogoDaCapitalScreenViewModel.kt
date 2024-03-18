package br.com.fiap.geoworldmania.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.fiap.geoworldmania.model.Pais

class JogoDaCapitalScreenViewModel : ViewModel() {

    private val _listaPaisState = MutableLiveData<List<Pais>>()
    val listaPaisState: LiveData<List<Pais>> = _listaPaisState

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

    fun onListaPaisStateChange(novaLista: List<Pais>) {
        _listaPaisState.value = novaLista
    }

    fun onListaPaisAleatorioStateChange(novaListaAleatoria: List<Pais>) {
        _listaPaisAleatorioState.value = novaListaAleatoria
    }

    fun adicionarPaisAleatorio(pais: Pais) {
        val listaAtual = _listaPaisAleatorioState.value.orEmpty().toMutableList()
        listaAtual.add(pais)
        _listaPaisAleatorioState.value = listaAtual
    }

    fun removerPaisAleatorio(pais: Pais) {
        val listaAtual = _listaPaisAleatorioState.value.orEmpty().toMutableList()
        listaAtual.remove(pais)
        _listaPaisAleatorioState.value = listaAtual
    }

    fun embaralharPaisesAleatorios() {
        val paisesAleatorios = _listaPaisAleatorioState.value.orEmpty().toMutableList()
        paisesAleatorios.shuffle()
        _listaPaisAleatorioState.value = paisesAleatorios
    }

    fun saberQualPaisesAtual( pais: Pais): Int {
        val paisesAleatorios = _nivel01.value.orEmpty().toMutableList()
        var index = paisesAleatorios.indexOf(pais)
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
}