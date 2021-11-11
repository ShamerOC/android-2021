package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var previousNumber: Long = 0
    var operation = ' '
    var resetOperation = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun insertNumber(view: View) {
        val resultTextField = findViewById<TextView>(R.id.result)
        val newResult = StringBuilder()
        if (resetOperation || resultTextField.text.equals("0")) {
            resultTextField.text = ""
            resetOperation = false
            if (operation == '-') {
                newResult.append("-");
            }
        }
        newResult.append(resultTextField.text).append(getNumberFromViewId(view))
        resultTextField.text = newResult.toString()
    }

    private fun getNumberFromViewId(view : View) : Char {
        return when (view.id) {
            R.id.zero -> '0'
            R.id.one -> '1'
            R.id.two -> '2'
            R.id.three -> '3'
            R.id.four -> '4'
            R.id.five -> '5'
            R.id.six -> '6'
            R.id.seven -> '7'
            R.id.eight -> '8'
            R.id.nine -> '9'
            else -> '0'
        }
    }

    fun action(view: View) {
        val resultTextField = findViewById<TextView>(R.id.result)
        val currentNumber = getCurrentNumber()
        operation = getOperationFromViewId(view)
        previousNumber = currentNumber
        resultTextField.text = "";
    }

    private fun getOperationFromViewId(view : View) : Char {
        return when (view.id) {
            R.id.plus -> '+'
            R.id.minus -> '-'
            R.id.multiplication -> '*'
            R.id.divide -> '/'
            else -> ' '
        }
    }

    fun clear(view: View) {
        val resultTextField = findViewById<TextView>(R.id.result)
        resultTextField.text = "0"
        operation = ' '
    }

    fun equals(view: View) {
        val resultTextField = findViewById<TextView>(R.id.result)
        val currentNumber = getCurrentNumber()
        val result = calculateResult(currentNumber)
        resetOperation = true
        resultTextField.text = result.toString()
    }

    private fun calculateResult(currentNumber : Long) : Long {
        return when (operation) {
            '+' -> previousNumber + currentNumber
            '-' -> previousNumber - currentNumber
            '*' -> previousNumber * currentNumber
            '/' -> if (currentNumber != 0L) {
                    previousNumber / currentNumber
                } else {
                    0L
                }
            else -> 0L
        }
    }

    private fun getCurrentNumber(): Long {
        val label = findViewById<TextView>(R.id.result)
        var currentNumber : Long = 0
        if (label.text != null && label.text.isNotEmpty()) {
            currentNumber = label.text.toString().toLong()
        }
        return currentNumber
    }
}