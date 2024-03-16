package br.com.fiap.geoworldmania.jogoDaCapital

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class JogoDaCapitalScreenViewModel : ViewModel() {

    private val _pais = MutableLiveData<String>()
    val pais: LiveData<String> = _pais

    private val _capital = MutableLiveData<List<String>>()
    val capital: LiveData<List<String>> = _capital

    private val _imagem = MutableLiveData<String>()
    val imagem: LiveData<String> = _imagem

    private val _opcao01 = MutableLiveData<String>()
    val opcao01: LiveData<String> = _opcao01

    private val _opcao02 = MutableLiveData<String>()
    val opcao02: LiveData<String> = _opcao02

    private val _opcao03 = MutableLiveData<String>()
    val opcao03: LiveData<String> = _opcao03


    fun onPaisChange(novoPais: String) {
        _pais.value = novoPais
    }
    fun onCapitalChange(novoCapital: List<String>) {
        _capital.value = novoCapital
    }

    fun onImagemChange(novoImagem: String) {
        _imagem.value = novoImagem
    }

    fun onOpcao01Change(novoOpcao01: String) {
        _opcao01.value = novoOpcao01
    }

    fun onOpcao02Change(novoOpcao02: String) {
        _opcao02.value = novoOpcao02
    }

    fun onOpcao03Change(novoOpcao03: String) {
        _opcao03.value = novoOpcao03
    }

}