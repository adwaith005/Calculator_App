import com.example.calcora.CalculatorOperation

sealed class CalculatorAction {
    data class Number(val number: Int) : CalculatorAction()
    object Clear : CalculatorAction()
    object Delete : CalculatorAction()
    object Decimal : CalculatorAction()
    object Calculate : CalculatorAction()
    object Percent : CalculatorAction()
    // ✅ THIS MUST USE CalculatorOperation (not a specific one)
    data class Operation(
        val operation: CalculatorOperation
    ) : CalculatorAction()
}
