package com.example.temperatureconvertor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

//import com.temperatureconvertor.R
import android.view.View

import android.widget.RadioButton

import android.widget.EditText
import com.example.temperatureconvertor.ConvertorUtil.convertCelsiusToFahrenheit


class MainActivity : AppCompatActivity() {
    private var text: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text = findViewById<View>(R.id.inputValue) as EditText
    }

    // this method is called at button click because we assigned the name to the
    // "OnClick" property of the button
    fun onClick(view: View) {
        when (view.getId()) {
            R.id.button -> {
                val celsiusButton = findViewById<View>(R.id.radio0) as RadioButton
                val fahrenheitButton = findViewById<View>(R.id.radio1) as RadioButton
                if (text!!.text.length == 0) {
                    Toast.makeText(
                        this, "Please enter a valid number",
                        Toast.LENGTH_LONG
                    ).show()
                    return
                }
                val inputValue = text!!.text.toString().toFloat()
                if (celsiusButton.isChecked) {
                    text!!.setText(ConvertorUtil.convertFahrenheitToCelsius(inputValue).toString())
                    celsiusButton.isChecked = false
                    fahrenheitButton.isChecked = true
                } else {
                    text!!.setText(convertCelsiusToFahrenheit(inputValue).toString())
                    fahrenheitButton.isChecked = false
                    celsiusButton.isChecked = true
                }
            }
        }
    }
}

