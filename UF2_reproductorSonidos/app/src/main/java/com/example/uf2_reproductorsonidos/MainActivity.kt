package com.example.uf2_reproductorsonidos

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var  mp: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mp = MediaPlayer.create(this, R.raw.cancion)
        var posicion = 0

        imageButton.setOnClickListener {
            mp.start()
            if (button5.text == "LOOP OFF")
                mp.isLooping = false
            else
                mp.isLooping = true
        }

        imageButton2.setOnClickListener {
            if (mp.isPlaying()) {
                posicion = mp.getCurrentPosition()
                mp.pause()
            }
        }

        imageButton3.setOnClickListener {
            if (mp.isPlaying() == false) {
                mp.seekTo(posicion)
                mp.start()
            }
        }

        imageButton4.setOnClickListener {
            mp.pause()
            posicion = 0
            mp.seekTo(0)
        }

        button5.setOnClickListener {
            if (button5.text  == "LOOP OFF")
                button5.setText("LOOP ON")
            else
                button5.setText("LOOP OFF")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mp.release()
    }
}