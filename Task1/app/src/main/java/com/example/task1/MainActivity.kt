package com.example.hw1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var nameText: EditText
    private lateinit var heightText: EditText
    private lateinit var weightText: EditText
    private lateinit var ageText: EditText
    private lateinit var calculateButton: Button
    private lateinit var resultText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nameText = findViewById(R.id.nameEditText)
        heightText = findViewById(R.id.heightEditText)
        weightText = findViewById(R.id.weightEditText)
        ageText = findViewById(R.id.ageEditText)
        calculateButton = findViewById(R.id.calculateButton)
        resultText = findViewById(R.id.textView5)

        calculateButton.setOnClickListener {
            val name = nameText.text.toString()
            val height = heightText.text.toString().toFloatOrNull()
            val weight = weightText.text.toString().toFloatOrNull()
            val age = ageText.text.toString().toIntOrNull()

            if ((name.isNotEmpty() && height != null && weight != null && age != null) &&
                (name.length <= 50 && height <= 250 && weight <= 250 && age <= 150)) {
                val calories = calculateCalories(height, weight, age)
                resultText.text = "Ответ: $name, Ваша дневная калорийность \nсоставит $calories"
            }
            else {
                resultText.text = "Данные введены некорректно."
            }
        }
    }

    private fun calculateCalories(height: Float, weight: Float, age: Int): Double {
        val weightInKg = weight
        val heightInCm = height
        return (10 * weightInKg) + (6.25 * heightInCm) - (5 * age) - 161
    }
}