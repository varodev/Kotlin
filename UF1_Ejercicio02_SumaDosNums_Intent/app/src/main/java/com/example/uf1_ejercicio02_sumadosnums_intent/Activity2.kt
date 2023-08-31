package com.example.uf1_ejercicio02_sumadosnums_intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_2.*
import kotlinx.android.synthetic.main.activity_main.*


class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        val bundle: Bundle? = intent.extras
        val resultado: Int = intent.getIntExtra("suma",0)
        tv1.text = "El resultado de la suma es: " + resultado
    }
}

