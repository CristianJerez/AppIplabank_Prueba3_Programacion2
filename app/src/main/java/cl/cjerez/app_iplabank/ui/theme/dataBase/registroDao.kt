package cl.cjerez.app_iplabank.ui.theme.dataBase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface registroDao {

    @Insert
    suspend fun insertar(reg:registro)

    @Delete
    suspend fun borrar(reg:registro)

    @Update
    suspend fun modificar(reg:registro)

    @Query("SELECT * FROM registro order by fechaCreacion desc")
    suspend fun getAll():List<registro>

    @Query("SELECT * FROM registro where id = :id")
    suspend fun getId(id:Int): registro
}