package viktor.khlebnikov.gb.gb_podgandroid_homework_4.domain.timestamp.formatter

class TimestampMillisecondsFormatter {

    fun format(timestamp: Long): String {
        val seconds = timestamp / 1000
        val secondsFormatted = (seconds % 60).pad(2)
        val minutes = seconds / 60
        val minutesFormatted = (minutes % 60).pad(2)
        val hours = minutes / 60
        val hoursFormatted = (hours % 60).pad(2)
        val days = hours / 24
        return if (days > 0) {
            val daysFormatted = (hours / 24).pad(2)
            "$daysFormatted:$hoursFormatted:$minutesFormatted"
        } else {
            "$hoursFormatted:$minutesFormatted:$secondsFormatted"
        }
    }

    private fun Long.pad(desiredLength: Int) = this.toString().padStart(desiredLength, '0')

}