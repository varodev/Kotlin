package com.example.uf2_piano_sonidos

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import kotlinx.android.synthetic.main.activity_main.*;

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        botonDO.setOnClickListener {
            val mp = MediaPlayer.create(this, R.raw.notado)
            mp.start()
        }

        botonRE.setOnClickListener {
            val mp = MediaPlayer.create(this, R.raw.notare)
            mp.start()
        }


        botonMI.setOnClickListener {
            val mp = MediaPlayer.create(this, R.raw.notami)
            mp.start()
        }

        botonFA.setOnClickListener {
            val mp = MediaPlayer.create(this, R.raw.notafa)
            mp.start()
        }

        botonSOL.setOnClickListener {
            val mp = MediaPlayer.create(this, R.raw.notasol)
            mp.start()
        }

        botonLA.setOnClickListener {
            val mp = MediaPlayer.create(this, R.raw.notala)
            mp.start()
        }

        botonSI.setOnClickListener {
            val mp = MediaPlayer.create(this, R.raw.notasi)
            mp.start()
        }

        botonDO2.setOnClickListener {
            val mp = MediaPlayer.create(this, R.raw.notado)
            mp.start()
        }

    }



}