package calculator.view

interface View {
    fun readExpression(): String
    fun printResult(result: Double)
    fun printError(message: String?)
}
