package viktor.khlebnikov.gb.gb_podgandroid_homework_4.state

import viktor.khlebnikov.gb.gb_podgandroid_homework_4.domain.calculate.ElapsedTimeCalculator
import viktor.khlebnikov.gb.gb_podgandroid_homework_4.domain.calculate.StopwatchStateCalculator
import viktor.khlebnikov.gb.gb_podgandroid_homework_4.domain.timestamp.formatter.TimestampMillisecondsFormatter
import viktor.khlebnikov.gb.gb_podgandroid_homework_4.state.StopwatchState

class StopwatchStateHolder(
    private val stopwatchStateCalculator: StopwatchStateCalculator,
    private val elapsedTimeCalculator: ElapsedTimeCalculator,
    private val timestampMillisecondsFormatter: TimestampMillisecondsFormatter,
) {

    var currentState: StopwatchState = StopwatchState.Paused(0)
        private set

    fun start() {
        currentState = stopwatchStateCalculator.calculateRunningState(currentState)
    }

    fun pause() {
        currentState = stopwatchStateCalculator.calculatePausedState(currentState)
    }

    fun stop() {
        currentState = StopwatchState.Paused(0)
    }

    fun getStringTimeRepresentation(): String {
        val elapsedTime = when (val currentState = currentState) {
            is StopwatchState.Paused -> currentState.elapsedTime
            is StopwatchState.Running -> elapsedTimeCalculator.calculate(currentState)
        }
        return timestampMillisecondsFormatter.format(elapsedTime)
    }
}