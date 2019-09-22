package util

import info.vividcode.time.iso8601.Iso8601ExtendedOffsetDateTimeFormat
import java.text.SimpleDateFormat
import java.util.*

class Utils {

    companion object {

        fun getCurrentDate(): String {
            val sdf = SimpleDateFormat(("yyyy/MM/dd"), Locale.US)
            return sdf.format(Calendar.getInstance().time)
        }

        fun formatISODate(isoDate: String): Pair<String, String>? {
            val isoFormatter = Iso8601ExtendedOffsetDateTimeFormat()
            val date = isoFormatter.parse(isoDate)
            val dayFormat = SimpleDateFormat(("dd-MM-yyyy"), Locale.US)
            val hourFormat = SimpleDateFormat(("hh:mm a"), Locale.US)
            date?.let {
                return Pair(dayFormat.format(it), hourFormat.format(it))
            } ?: kotlin.run {
                return null
            }
        }
    }
}