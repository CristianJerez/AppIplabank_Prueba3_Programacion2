package cl.cjerez.app_iplabank.ui.theme.domain

import java.text.NumberFormat

class formatCurrencyUseCase {

    private val formatter = NumberFormat.getCurrencyInstance()

    operator fun invoke(monto:Int):String {
        return formatter.format(monto)
    }
}