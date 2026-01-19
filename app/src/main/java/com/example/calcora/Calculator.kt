package com.example.calcora


import CalculatorAction
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calcora.ui.theme.CalculatorBackground
import com.example.calcora.ui.theme.EqualsButton
import com.example.calcora.ui.theme.LightGray
import com.example.calcora.ui.theme.NumberButton
import com.example.calcora.ui.theme.OperatorButton
import com.example.calcora.ui.theme.Orange

@Composable
fun Calculator(modifier:

               Modifier = Modifier,
               state: CalculatorState,
               buttonSpacing: Dp = 8.dp,
               onAction: (CalculatorAction) -> Unit
) {
    Box(
        modifier = modifier.fillMaxSize().background(CalculatorBackground).padding(13.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),


            verticalArrangement = Arrangement.spacedBy(buttonSpacing)

        ) {

            val scrollState = rememberScrollState()

            LaunchedEffect(state.number1, state.number2, state.operation) {
                scrollState.scrollTo(scrollState.maxValue)
            }

            Text(
                text = state.number1 + (state.operation?.symbol ?: "") + state.number2,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
                    .horizontalScroll(scrollState),
                textAlign = TextAlign.End,
                fontSize = 64.sp,
                fontWeight = FontWeight.Light,
                color = Color.White,
                maxLines = 1,
                softWrap = false
            )


            //row 1
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                        symbol = "AC",
                        modifier = Modifier
                            .background(OperatorButton)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                    onAction(CalculatorAction.Clear)

                    }
                )


                CalculatorButton(
                    symbol = "Del",
                    modifier = Modifier
                        .background(OperatorButton)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Delete)

                    }
                )
                CalculatorButton(
                    symbol = "%",
                    modifier = Modifier
                        .background(OperatorButton)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Percent)

                    }
                )

                CalculatorButton(
                    symbol = "/",
                    modifier = Modifier
                        .background(OperatorButton)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Operation(CalculatorOperation.Division))

                    }
                )
            }
            //row 2
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    symbol = "7",
                    modifier = Modifier
                        .background(NumberButton)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(7))

                    }
                )

                CalculatorButton(
                    symbol = "8",
                    modifier = Modifier
                        .background(NumberButton)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(8))

                    }
                )

                CalculatorButton(
                    symbol = "9",
                    modifier = Modifier
                        .background(NumberButton)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(9))

                    }
                )
                CalculatorButton(
                    symbol = "x",
                    modifier = Modifier
                        .background(OperatorButton)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Operation(CalculatorOperation.Multiply))
                       
                    }
                )
            }

            //row 3
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    symbol = "4",
                    modifier = Modifier
                        .background(NumberButton)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(4))

                    }
                )

                CalculatorButton(
                    symbol = "5",
                    modifier = Modifier
                        .background(NumberButton)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(5))

                    }
                )

                CalculatorButton(
                    symbol = "6",
                    modifier = Modifier
                        .background(NumberButton)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(6))

                    }
                )
                CalculatorButton(
                    symbol = "-",
                    modifier = Modifier
                        .background(OperatorButton)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Operation(CalculatorOperation.Subtract))

                    }
                )
            }
            //row 4
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    symbol = "1",
                    modifier = Modifier
                        .background(NumberButton)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(1))

                    }
                )

                CalculatorButton(
                    symbol = "2",
                    modifier = Modifier
                        .background(NumberButton)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(2))

                    }
                )

                CalculatorButton(
                    symbol = "3",
                    modifier = Modifier
                        .background(NumberButton)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(3))

                    }
                )
                CalculatorButton(
                    symbol = "+",
                    modifier = Modifier
                        .background(OperatorButton)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Operation(CalculatorOperation.Add))

                    }
                )
            }
            //row 5

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    symbol = "0",
                    modifier = Modifier
                        .background(NumberButton)
                        .aspectRatio(2f)
                        .weight(2f),
                    onClick = {
                        onAction(CalculatorAction.Number(0))

                    }
                )

                CalculatorButton(
                    symbol = ".",
                    modifier = Modifier
                        .background(OperatorButton)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Decimal)

                    }
                )


                CalculatorButton(
                    symbol = "=",
                    modifier = Modifier
                        .background(EqualsButton)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Calculate)

                    }
                )
            }
        }
    }
}

