package cl.cjerez.app_iplabank.ui.theme

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import cl.cjerez.app_iplabank.ui.theme.dataBase.dataBase
import cl.cjerez.app_iplabank.ui.theme.dataBase.registro
import cl.cjerez.app_iplabank.ui.theme.dataBase.registroDao
import java.time.LocalDate

class viewModel : ViewModel() {

    private val _usuario = MutableLiveData<String>()
    val usuario: LiveData<String> = _usuario

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password
//registro
    private val _id= MutableLiveData<String>()
    val id: LiveData<String> = _id

    private val _nombre= MutableLiveData<String>()
    val nombre: LiveData<String> = _nombre

    private val _rut= MutableLiveData<String>()
    val rut: LiveData<String> = _rut

    private val _email= MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _telefono= MutableLiveData<String>()
    val telefono: LiveData<String> = _telefono

    private val _latitud= MutableLiveData<Float>()
    val latitud: LiveData<Float> = _latitud

    private val _longitud= MutableLiveData<Float>()
    val longitud: LiveData<Float> = _longitud

    private val _imagenF= MutableLiveData<String>()
    val imagenF: LiveData<String> = _imagenF

    private val _imagenT= MutableLiveData<String>()
    val imagenT: LiveData<String> = _imagenT

    var fechaCreacion:LocalDate = LocalDate.now()


    fun onLoginChanged(user: String, pass: String) {
        _usuario.value = user
        _password.value = pass
    }

    private fun isValidEmail(email: String): Boolean {
        return if(!email.isEmpty()){
            email === email
        }else{
            false
        }
    }

    private fun isValidPassword(password: String): Boolean = password.length > 6

    suspend fun agregarSolicitud(contexto:Context){
        var reg = nombre.value?.let {
            telefono.value?.let { it1 ->
                rut.value?.let { it2 ->
                    email.value?.let { it3 ->
                        id.value?.let { it4 ->
                            imagenF.value?.let { it5 ->
                                imagenT.value?.let { it6 ->
                                    longitud.value?.let { it7 ->
                                        latitud.value?.let { it8 ->
                                            registro(id = it4.toInt(), nombre = it, rut = it2,
                                                email= it3, telefono = it1.toInt(), latitud = it8,
                                                longitud = it7, imagenFrontal = it5,
                                                imagenTrasera = it6, fechaCreacion = fechaCreacion.toString())
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }//fin de reg
        val DB:registroDao = dataBase.getInstance(contexto).registroDao()
        if (reg != null) {
            DB.insertar(reg)
        }
    }
    fun onNombreChanged(nombre: String) {
        _nombre.value = nombre
    }

    fun onRutChanged(rut: String) {
        _rut.value = rut
    }

    fun onEmailChanged(email: String) {
        _nombre.value = email
    }

    fun onTelefonoChanged(telefono: String) {
        _nombre.value = telefono
    }

    fun onLatitudChanged(lat: Float) {
        _latitud.value = lat
    }

    fun onLongitudChanged(lon: Float) {
        _longitud.value = lon
    }

    fun onIFChanged(IF: String) {
        _imagenF.value = IF
    }

    fun onITChanged(IT: String) {
        _imagenT.value = IT
    }
}