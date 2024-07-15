package com.lu.converter

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class WeightActivity : AppCompatActivity() {

    private val weightOptions = arrayOf("Kg to lb", "lb to kg", "g to mg", "mg to g")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weight)

        val context = this

        val spOption: Spinner = findViewById(R.id.spWtOption)
        val resultBtn: Button = findViewById(R.id.wtCalBtn)
        val lenEditTxt: EditText = findViewById(R.id.edTxtWt)
        val resultTV: TextView = findViewById(R.id.wtResultTV)

        var spinnerVal = "Kg to lb" //default value
        spOption.adapter =
            ArrayAdapter(context, android.R.layout.simple_list_item_1, weightOptions)

        spOption.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                spinnerVal = weightOptions[position];
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Nothing implemented")
            }
        }

        resultBtn.setOnClickListener { handleSpinnerSelection(spinnerVal, lenEditTxt, resultTV) }
    }

    fun handleSpinnerSelection(spinnerVal: String, valueET: EditText, resultTV: TextView) {
        val weightValue = valueET.text.toString().toDouble()

        var resultValue = 0.0
        when (spinnerVal) {
            "Kg to lb" -> {
                resultValue = (weightValue * 2.2)
            }

            "lb to kg" -> {
                resultValue = (weightValue) / 2.2
            }

            "g to mg" -> {
                resultValue = (weightValue) * 1000
            }

            "mg to g" -> {
                resultValue = (weightValue) / 1000
            }
        }
        resultTV.text = "Converted value is " + resultValue
    }
}

