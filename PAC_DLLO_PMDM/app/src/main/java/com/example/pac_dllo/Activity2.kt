package com.example.pac_dllo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_2.*


class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)
        //Mensaje corto que aparece cuando para avisar que se entra en la activity2
        Toast.makeText(this,"Accediendo a la Base de Datos",Toast.LENGTH_SHORT).show();

        //Botón, que mediante Intent, te lanza a la Actividad21 (Base de datos, Insertar)
        btnInsert.setOnClickListener {
            val intent = Intent(this, Activity21::class.java)
            startActivity(intent);
        }
        //Botón, que mediante Intent, te lanza a la Actividad21 (Base de datos, Consultar)
        btnQuery.setOnClickListener {
            val intent = Intent(this, Activity21::class.java)
            startActivity(intent);
        }
        //Botón, que mediante Intent, te lanza a la Actividad21 (Base de datos, Modificar)
        btnModif.setOnClickListener {
            val intent = Intent(this, Activity21::class.java)
            startActivity(intent);
        }
        //Botón, que mediante Intent, te lanza a la Actividad21 (Base de datos, Eliminar)
        btnDelete.setOnClickListener {
            val intent = Intent(this, Activity21::class.java)
            startActivity(intent);
        }
        //Botón, que mediante Intent, te lanza a la MainActivity
        btnBack2.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent);
        }
    }
}

