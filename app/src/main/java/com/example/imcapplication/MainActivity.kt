package com.example.imcapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_relative)
        setListeners()
    }
    private fun setListeners(){
        alturaEDT.doAfterTextChanged { text ->
//            Toast.makeText(this, text.toString(), Toast.LENGTH_SHORT).show()
        }
        pesoEDT.doOnTextChanged { text, _, _, _ ->
//            titleTXT.text = text
        }
        calcularBTN?.setOnClickListener {
            calcularIMC(pesoEDT.text.toString(), alturaEDT.text.toString())
        }
    }
    private fun calcularIMC(peso: String, altura: String){
        val peso = peso.toFloatOrNull()
        val altura = altura.toFloatOrNull()

        if (peso !=null && altura !=null){
            val imc = peso/ (altura * altura)
            titleTXT.text = "Seu IMC é: ".format(imc)
        }
    }

}



