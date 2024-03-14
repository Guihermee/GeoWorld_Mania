package br.com.fiap.geoworldmania.jogoDaCapital

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class JogoDaCapitalScreenViewModel: ViewModel() {

    private val _pais = MutableLiveData<String>()
    val pais: LiveData<String> = _pais

    fun onPaisChange(novoPais: String) {
    _pais.value = novoPais
    }

}