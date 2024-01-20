package cl.cjerez.app_iplabank.ui.theme.dataBase

import androidx.room.TypeConverter
import java.time.LocalDate

class localDataConverter {

    @TypeConverter
    fun fromTimestamp(value: Long?): LocalDate? {
        return value?.let { LocalDate.ofEpochDay(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: LocalDate?): Long? {
        return date?.toEpochDay()
    }
}