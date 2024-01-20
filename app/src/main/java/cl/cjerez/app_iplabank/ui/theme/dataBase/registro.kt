package cl.cjerez.app_iplabank.ui.theme.dataBase

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Timestamp
import java.time.LocalDate

@Entity
data class registro(
    @PrimaryKey(autoGenerate = true) val id:Int,
    var nombre:String,
    var rut:String,
    var email:String,
    var telefono:Int,
    var latitud:Float,
    var longitud:Float,
    var imagenFrontal:String, //rutas
    var imagenTrasera:String,
    var fechaCreacion:String
)
