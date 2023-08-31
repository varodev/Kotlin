package com.example.uf1_ejercicio02_sumadosnums_intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Configuramos el botón Sumar
        botonSumar.setOnClickListener {
            val nro1 = et1.text.toString().toInt()
            val nro2 = et2.text.toString().toInt()
            val suma = nro1 + nro2

            val intent = Intent(this, Activity2::class.java)
            intent.putExtra("suma", suma)
            startActivityForResult(intent,0)

        }

    }
}