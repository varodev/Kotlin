package com.example.uf2_alertdialog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {

            val builder = AlertDialog.Builder(this)
            builder.setTitle("Ejemplo AlertDialog")
            builder.setMessage("Esto es un ejemplo de uso de AlertDialog en Android")

            //builder.setPositiveButton("OK", DialogInterface.OnClickListener(function = x))

            builder.setPositiveButton(android.R.string.ok) { dialog, which ->
                Toast.makeText(applicationContext,
                    android.R.string.ok, Toast.LENGTH_SHORT).show()
                //Aquí se define la acción al pulsar SÍ

            }

            builder.setNegativeButton(android.R.string.cancel) { dialog, which ->
                Toast.makeText(applicationContext,
                    android.R.string.cancel, Toast.LENGTH_SHORT).show()

                //Aquí se define la acción al pulsar NO
            }

            builder.setNeutralButton("Omitir") { dialog, which ->
                Toast.makeText(applicationContext,
                    "Has pulsado Omitir", Toast.LENGTH_SHORT).show()

                //Aquí se define la acción al pusar OMITIR
            }
            builder.show()

        }


    }
}