package com.example.calcora

import CalculatorAction
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {

    var state by mutableStateOf(CalculatorState())
        private set

    fun onAction(action: CalculatorAction) {
        when (action) {
            is CalculatorAction.Number -> enterNumber(action.number)
            is CalculatorAction.Decimal -> enterDecimal()
            is CalculatorAction.Clear -> state = CalculatorState()
            is CalculatorAction.Operation -> enterOperation(action.operation)
            is CalculatorAction.Calculate -> performCalculation()
            is CalculatorAction.Delete -> performDeletion()
            is CalculatorAction.Percent -> performPercent()


        }
    }
    private fun performPercent() {
        // Case 1: No operation → number1 %
        if (state.operation == null && state.number1.isNotBlank()) {
            val number = state.number1.toDoubleOrNull() ?: return
            state = state.copy(
                number1 = (number / 100).toString()
            )
            return
        }

        // Case 2: Operation exists → number2 %
        if (state.number2.isNotBlank()) {
            val number1 = state.number1.toDoubleOrNull() ?: return
            val number2 = state.number2.toDoubleOrNull() ?: return

            val percentValue = when (state.operation) {
                CalculatorOperation.Add,
                CalculatorOperation.Subtract ->
                    number1 * number2 / 100

                CalculatorOperation.Multiply,
                CalculatorOperation.Division ->
                    number2 / 100

                null -> return
            }

            state = state.copy(
                number2 = percentValue.toString()
            )
        }
    }

    private fun enterOperation(operation: CalculatorOperation) {
        if (state.number1.isNotBlank()) {
            state = state.copy(operation = operation)
        }
    }

    private fun enterDecimal() {
        if (state.operation == null) {
            if (!state.number1.contains(".")) {
                state = state.copy(number1 = state.number1 + ".")
            }
            return
        }

        if (!state.number2.contains(".")) {
            state = state.copy(number2 = state.number2 + ".")
        }
    }

    private fun performCalculation() {
        val number1 = state.number1.toDoubleOrNull()
        val number2 = state.number2.toDoubleOrNull()

        if (number1 != null && number2 != null) {
            val result = when (state.operation) {
                CalculatorOperation.Add -> number1 + number2
                CalculatorOperation.Subtract -> number1 - number2
                CalculatorOperation.Multiply -> number1 * number2
                CalculatorOperation.Division -> number1 / number2
                null -> return
            }

            state = state.copy(
                number1 = result.toString().take(15),
                number2 = "",
                operation = null
            )
        }
    }

    private fun enterNumber(number: Int) {
        if (state.operation == null) {
            if (state.number1.length >= MAX_NUM_LENGTH) return
            state = state.copy(number1 = state.number1 + number)
            return
        }

        if (state.number2.length >= MAX_NUM_LENGTH) return
        state = state.copy(number2 = state.number2 + number)
    }

    private fun performDeletion() {
        when {
            state.number2.isNotBlank() ->
                state = state.copy(number2 = state.number2.dropLast(1))

            state.operation != null ->
                state = state.copy(operation = null)

            state.number1.isNotBlank() ->
                state = state.copy(number1 = state.number1.dropLast(1))
        }
    }

    companion object {
        private const val MAX_NUM_LENGTH = 8
    }
}


