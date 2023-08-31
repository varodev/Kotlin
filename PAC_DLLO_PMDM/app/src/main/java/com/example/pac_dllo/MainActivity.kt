package com.example.pac_dllo

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
        private lateinit var  mp: MediaPlayer
    //Visualizado con Pixel2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Recurso de reprodución en res /raw
        mp = MediaPlayer.create(this, R.raw.bark)
        var posicion = 0
        //Botón que reproduce la musica
        btnOn.setOnClickListener {
            if (!mp.isPlaying()) {
                mp.seekTo(posicion)
                mp.start()
            }
        }
        //Botón que para la música
        btnOff.setOnClickListener {
            if (mp.isPlaying()) {
                posicion = mp.getCurrentPosition()
                mp.pause()
            }
        }
        //Botón, que mediante Intent, te lanza a la Actividad2
        btnA2.setOnClickListener {
            val intent = Intent(this, Activity2::class.java)
            startActivity(intent);
        }
        //Botón, que mediante Intent, te lanza a la Actividad3
        btnA3.setOnClickListener {
            val intent = Intent(this, Activity3::class.java)
            startActivity(intent);
        }
        //Botón, que mediante Intent, te lanza a la Actividad4
        btnA4.setOnClickListener {
            val intent = Intent(this, Activity4::class.java)
            startActivity(intent);
        }
    }
    /*override fun onDestroy() {
        super.onDestroy()
        mp.release()
    }*/
}