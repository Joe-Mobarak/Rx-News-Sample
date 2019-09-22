package util

import java.text.SimpleDateFormat
import java.util.*

class Utils {

    companion object {

        fun getCurrentDate(): String {
            val sdf = SimpleDateFormat(("yyyy/MM/dd"), Locale.US)
            return sdf.format(Calendar.getInstance().time)
        }
    }
}
