package cl.cjerez.app_iplabank.ui.theme.dataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [registro::class] , version = 1)
abstract class dataBase : RoomDatabase() {
    abstract fun registroDao() : registroDao

    companion object {
        @Volatile
        private var BASE_DATOS : dataBase? = null
        const val DB_NOMBRE = "iplabank.db"

        fun getInstance (contexto : Context) : dataBase {
            return BASE_DATOS ?: synchronized(this) {
                Room.databaseBuilder(
                    contexto.applicationContext,
                    dataBase::class.java,
                    DB_NOMBRE
                ).fallbackToDestructiveMigration().build().also { BASE_DATOS = it }
            }
        }
    }
}