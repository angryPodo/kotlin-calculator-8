package calculator.domain

object NumberConverter {
    fun convert(parts: ExpressionParts): List<Double> {
        val numberStrings = parts.content.split(*parts.delimiters.toTypedArray())
        return numberStrings.map {
            val number = it.toDoubleOrNull() ?: throw IllegalArgumentException("입력값 [$it]는 숫자가 아닙니다.")
            require(number >= 0) { "음수는 입력할 수 없습니다." }
            number
        }
    }
}
