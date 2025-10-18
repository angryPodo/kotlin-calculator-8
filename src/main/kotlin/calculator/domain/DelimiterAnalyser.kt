package calculator.domain

object DelimiterAnalyser {
    private val DEFAULT_DELIMITERS = listOf(",", ":")
    private val CUSTOM_DELIMITER_REGEX = Regex("//(.)\n(.*)")

    fun analyse(expression: String?): ExpressionParts {
        if (expression.isNullOrBlank()) return ExpressionParts("", DEFAULT_DELIMITERS)

        val matchResult = CUSTOM_DELIMITER_REGEX.find(expression)
        if (matchResult != null) {
            val (customDelimiter, numbersPart) = matchResult.destructured
            validateCustomDelimiter(customDelimiter)
            return ExpressionParts(numbersPart, DEFAULT_DELIMITERS + customDelimiter)
        }

        return ExpressionParts(expression, DEFAULT_DELIMITERS)
    }

    private fun validateCustomDelimiter(delimiter: String) {
        require(!delimiter.matches(Regex("[0-9.]"))) {
            "커스텀 구분자로는 숫자나 소수점을 사용할 수 없습니다."
        }
    }
}