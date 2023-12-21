package com.example.estudos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import javax.xml.validation.Validator


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.buttonCalcular)
        val textInputGasolina = findViewById<TextInputEditText>(R.id.textInputEditGasolina)
        val textInputLayoutGasolina = findViewById<TextInputLayout>(R.id.textInputLayoutGasolina)
        val textInputLayoutAlcool = findViewById<TextInputLayout>(R.id.textInputLayoutAlcool)
        val textInputAlcool = findViewById<TextInputEditText>(R.id.textInputEditAlcool)
        val textView = findViewById<TextView>(R.id.textViewResultado)

        button.setOnClickListener {
            if (validarCampos(textInputLayoutGasolina, textInputLayoutAlcool, textInputGasolina.text.toString(), textInputAlcool.text.toString())
            ) {
                val gasolinaFloat = textInputGasolina.text.toString().toFloat()
                val acoolFloat = textInputAlcool.text.toString().toFloat()

                textView.text = if((acoolFloat / gasolinaFloat) >= 0.7) "Gasolina" else "Acool"

            }
        }
    }

    fun validarCampos(
        textInputLayout: TextInputLayout,
        textInputLayout2: TextInputLayout,
        campo1: String,
        campo2: String
    ): Boolean {
        textInputLayout.error = null
        textInputLayout2.error = null

        when {
            campo1.isEmpty() -> {
                textInputLayout.error = "Preencha o campo da gasolina corretamente"
                Toast.makeText(this,textInputLayout.error,Toast.LENGTH_SHORT).show()
                return false
            }

            campo2.isEmpty() -> {
                textInputLayout2.error = "Preencha o campo do acool corretamente"
                Toast.makeText(this,textInputLayout2.error,Toast.LENGTH_SHORT).show()
                return false
            }
        }
        return true
    }

}