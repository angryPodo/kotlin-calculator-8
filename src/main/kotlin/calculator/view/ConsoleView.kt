package calculator.view

import camp.nextstep.edu.missionutils.Console

object ConsoleView : View {
    private const val PROMPT_MESSAGE = "덧셈할 문자열을 입력해 주세요."
    private const val RESULT_PREFIX = "결과 : "

    override fun readExpression(): String {
        println(PROMPT_MESSAGE)
        return Console.readLine()
    }

    override fun printResult(result: Double) =
        println("$RESULT_PREFIX${printFormatter(result)}")

    override fun printError(message: String?) = println(message)

    private fun printFormatter(result: Double): String =
        if (result % 1.0 != 0.0) result.toString() else result.toInt().toString()

}
