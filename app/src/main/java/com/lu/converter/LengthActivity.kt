package com.lu.converter

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LengthActivity : AppCompatActivity() {

    private val lengthOptions = arrayOf("cm-inch", "inch-cm", "metre-feet", "feet-metre")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_length)
        val context = this

        val spOption: Spinner = findViewById(R.id.spLenOption)
        val resultBtn: Button = findViewById(R.id.lenCalBtn)
        val lenEditTxt: EditText = findViewById(R.id.edTxtLength)
        val resultTV:TextView = findViewById(R.id.lenResultTV)

        var spinnerVal = "cm-inch" //default value
        spOption.adapter =
            ArrayAdapter(context, android.R.layout.simple_list_item_1, lengthOptions)

        spOption.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                spinnerVal = lengthOptions[position];
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Nothing implemented")
            }
        }

        resultBtn.setOnClickListener { handleSpinnerSelection(spinnerVal, lenEditTxt, resultTV) }
    }

    fun handleSpinnerSelection(spinnerVal: String, valueET: EditText, resultTV: TextView) {
        val lengthValue = valueET.text.toString().toFloat()

        var value = 0.0
        when (spinnerVal) {
            "cm-inch" -> {
                value = (lengthValue / 2.54)
            }

            "inch-cm" -> {
                value = (lengthValue * 2.54)
            }
            "metre-feet" -> {
                value = (lengthValue * 3.281)
            }
            "feet-metre" -> {
                value = (lengthValue / 3.281)
            }

        }
        resultTV.text = "Converted value is "+ value
    }
}

