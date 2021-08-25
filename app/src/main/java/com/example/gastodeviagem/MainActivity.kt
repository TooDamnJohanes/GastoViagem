package com.example.gastodeviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val id = view.id
        if (id == R.id.buttonCalculate) {
            calculate()
        }
    }

    private fun calculate() {
            try {
                val distance = editDistance.text.toString().toFloat()
                val price = editPrice.text.toString().toFloat()
                val autonomy = editAutonomy.text.toString().toFloat()
                if(autonomy != 0f) {
                    val totalValue = (distance * price) / autonomy
                    textTotalValue.text = "R$ ${"%.2f".format(totalValue)}"
                }
                else {
                    Toast.makeText(this, "Campo Autonomia não pode ser ZERO!", Toast.LENGTH_LONG).show()
                    textTotalValue.text = "R$ 0"
                }
            } catch(nfe: NumberFormatException) {
                cadeiaErros()
            }
    }

    private fun cadeiaErros(): Boolean {
        if (editDistance.text.toString() == "") {
            Toast.makeText(this, "Campo Distância em branco!", Toast.LENGTH_LONG).show()
            return false
        }

        else if (editPrice.text.toString() == "") {
            Toast.makeText(this, "Campo Preço em branco!", Toast.LENGTH_LONG).show()
            return false
        }

        else if (editAutonomy.text.toString() == "") {
            Toast.makeText(this, "Campo Autonomia em branco!", Toast.LENGTH_LONG).show()
            return false
        }

        else {
            return false
        }
    }
}