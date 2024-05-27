package br.com.fiap.geoworldmania.utils

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import br.com.fiap.geoworldmania.model.Pais

class Converters {

    @TypeConverter
    fun fromPaisList(value: List<Pais>): String {
        val gson = Gson()
        val type = object : TypeToken<List<Pais>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toPaisList(value: String): List<Pais> {
        val gson = Gson()
        val type = object : TypeToken<List<Pais>>() {}.type
        return gson.fromJson(value, type)
    }
}
