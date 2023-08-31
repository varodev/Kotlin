package com.example.pac_dllo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_4.*


class Activity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_4)

        //Botón, que mediante Intent, te lanza a la MainActivity
        btnBack4.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent);

        }


    }
}

