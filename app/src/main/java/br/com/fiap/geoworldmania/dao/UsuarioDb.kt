package br.com.fiap.geoworldmania.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import br.com.fiap.geoworldmania.model.ContinuaDeOndeParou
import br.com.fiap.geoworldmania.model.NiveisBandeiras
import br.com.fiap.geoworldmania.model.NiveisCapitais
import br.com.fiap.geoworldmania.model.NiveisPaises
import br.com.fiap.geoworldmania.model.Usuario
import br.com.fiap.geoworldmania.utils.Converters

@Database(
    entities = [Usuario::class, NiveisCapitais::class, NiveisBandeiras::class, NiveisPaises::class, ContinuaDeOndeParou::class],
    version = 12
)
@TypeConverters(Converters::class)
abstract class UsuarioDb : RoomDatabase() {

    abstract fun usuarioDAO(): UsuarioDao
    abstract fun niveisCapitaisDao(): NiveisCapitaisDao
    abstract fun niveisPaisesDao(): NiveisPaisesDao
    abstract fun niveisBandeirasDao(): NiveisBandeirasDao
    abstract fun continuaDeOndeParouDao(): ContinuarDeOndeParouDao

    companion object {

        private lateinit var instance: UsuarioDb

        fun getDataBase(context: Context): UsuarioDb {
            if (!::instance.isInitialized) {
                instance = Room.databaseBuilder(
                    context = context,
                    klass = UsuarioDb::class.java,
                    name = "usuario_db"
                )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance
        }

    }

}