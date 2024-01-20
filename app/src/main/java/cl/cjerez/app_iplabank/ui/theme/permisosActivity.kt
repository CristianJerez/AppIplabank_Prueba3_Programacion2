/*package cl.cjerez.app_iplabank.ui.theme

import android.content.pm.PackageManager
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat

class permisosActivity :  AppComatActivity() {

    private lateinit var tvUbicacion: TextView
    private lateinit var tvMensaje  : TextView
    private lateinit var btnPermisos: Button

    fun mostrarUbicacion(){
        Ubicacion.conseguirUbicacion(
            this@PermisosActivity,
            { ubicacion ->
                Log.v("peticionPermisos", "Ubicacion OK")
                val t = "lat: ${ubicacion?.latitude} | long: ${ubicacion?.longitude}"
                tvUbicacion.text = t
                tvUbicacion.visibility = View.VISIBLE
                tvUbicacion.visibility = View.GONE
                tvMensaje.text = ""
            },
            { ex ->
                Log.v("peticionPermisos", "Ubicacion Error")
                tvMensaje.text = "Error: ${ex.message}"
            }
        )
    }

    val peticionPermiso = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permisoConcedido ->
        if (permisoConcedido ) {
            Log.v("peticionPermiso", "Permiso Concedido")
            mostrarUbicacion()
        } else {
            Log.v("peticionPermiso", "Permiso Denegado")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permisos)

        tvUbicacion = findViewById<TextView>(R.id.tvUbicacion)
        tvUbicacion.visibility = View.GONE // ocultar por defecto
        tvMensaje   = findViewById<TextView>(R.id.tvMensaje)
        btnPermisos = findViewById<Button>(R.id.btnPermisos)

        val permiso = android.Manifest.permission.ACCESS_COARSE_LOCATION

        btnPermisos?.setOnClickListener {
            peticionPermiso.launch(
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
        }
        when {
            // permiso concedido previamente
            ContextCompat.checkSelfPermission(this, permiso) ==
                    PackageManager.PERMISSION_GRANTED -> {
                btnPermisos.visibility = View.GONE // oculto boton
                mostrarUbicacion()
            }

            shouldShowRequestPermissionRationale(permiso) ->
                tvMensaje.text =
                    "se requiere el permiso, para que la aplicación funcione correctamente"
        }
        else -> {
            btnPermisos.visibility = View.VISIBLE
        }
    }
}*/