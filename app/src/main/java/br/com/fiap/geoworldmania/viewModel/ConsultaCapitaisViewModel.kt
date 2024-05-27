package br.com.fiap.geoworldmania.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ConsultaCapitaisViewModel : ViewModel() {

    private val _consulta = MutableLiveData<String>()
    val consultaState: LiveData<String> = _consulta

    fun onConsultaChanged(novoCapital: String){
        _consulta.value = novoCapital
    }

}