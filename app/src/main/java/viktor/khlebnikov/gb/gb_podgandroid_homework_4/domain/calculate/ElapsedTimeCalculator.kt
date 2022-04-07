package viktor.khlebnikov.gb.gb_podgandroid_homework_4.domain.calculate

import viktor.khlebnikov.gb.gb_podgandroid_homework_4.state.StopwatchState
import viktor.khlebnikov.gb.gb_podgandroid_homework_4.domain.timestamp.TimestampProvider

class ElapsedTimeCalculator(
    private val timestampProvider: TimestampProvider,
) {

    fun calculate(state: StopwatchState.Running): Long {
        val currentTimestamp = timestampProvider.getMilliseconds()
        val timePassedSinceStart = if (currentTimestamp > state.startTime) {
            currentTimestamp - state.startTime
        } else {
            0
        }
        return timePassedSinceStart + state.elapsedTime
    }
}