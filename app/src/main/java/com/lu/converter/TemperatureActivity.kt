package com.lu.converter

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class TemperatureActivity : AppCompatActivity() {

    private val tempOptions = arrayOf("Fahrenheit-Celsius", "Celsius-Fahrenheit", "Celsius-Kelvin", "Kelvin-Celsius")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temperature)
        val context = this

        val spOption: Spinner = findViewById(R.id.spTempOption)
        val resultBtn: Button = findViewById(R.id.tempCalBtn)
        val lenEditTxt: EditText = findViewById(R.id.edTxtTemp)
        val resultTV: TextView = findViewById(R.id.tempResultTV)

        var spinnerVal = "Fahrenheit-Celsius" //default value
        spOption.adapter =
            ArrayAdapter(context, android.R.layout.simple_list_item_1, tempOptions)

        spOption.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                spinnerVal = tempOptions[position];
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Nothing implemented")
            }
        }

        resultBtn.setOnClickListener { handleSpinnerSelection(spinnerVal, lenEditTxt, resultTV) }
    }

    fun handleSpinnerSelection(spinnerVal: String, valueET: EditText, resultTV: TextView) {
        val temperatureValue = valueET.text.toString().toDouble()

        var resultValue = 0.0
        when (spinnerVal) {
            "Fahrenheit-Celsius" -> {
                resultValue = ((temperatureValue - 32) * 5) / 9
            }

            "Celsius-Fahrenheit" -> {
                resultValue = (temperatureValue * 1.8) + 32
            }

            "Celsius-Kelvin" -> {
                resultValue = temperatureValue + 273.15
            }

            "Kelvin-Celsius" -> {
                resultValue = temperatureValue - 273.15
            }
        }
        resultTV.text = "Converted value is " + resultValue
    }
}

