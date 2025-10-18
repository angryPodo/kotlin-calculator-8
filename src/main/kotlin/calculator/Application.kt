package calculator

import calculator.domain.Calculator
import calculator.domain.DelimiterAnalyser
import calculator.domain.NumberConverter
import calculator.view.ConsoleView
import calculator.view.View

fun main() {
    val view: View = ConsoleView
    runCatching {
        val rawExpression = view.readExpression()

        if (rawExpression.isBlank()) {
            view.printResult(0.0)
            return@runCatching
        }

        val parts = DelimiterAnalyser.analyse(rawExpression)
        val numbers = NumberConverter.convert(parts)
        val result = Calculator.sum(numbers)

        view.printResult(result)

    }.onFailure {
        view.printError(it.message)
    }
}