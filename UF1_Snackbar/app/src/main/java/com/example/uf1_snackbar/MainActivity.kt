package com.example.uf1_snackbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonEnter.setOnClickListener{showSnackBar("Has pulsado Entrar")}


        buttonExit.setOnClickListener{showSnackBarSalir("¿Estás seguro de que quieres salir?")}
    }

    fun showSnackBar(text:String){
        Snackbar.make(findViewById(R.id.textView2), text, Snackbar.LENGTH_SHORT).show()
    }

    fun showSnackBarSalir(text:String){
        Snackbar.make(findViewById(R.id.textView2), text, Snackbar.LENGTH_SHORT).setAction("Salir", {finish()})
                .setActionTextColor(ContextCompat.getColor(this,R.color.teal_200)).show()
    }
}