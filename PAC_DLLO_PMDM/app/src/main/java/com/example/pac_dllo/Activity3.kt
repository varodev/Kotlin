package com.example.pac_dllo

import android.app.Activity
import android.content.ContentValues
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_3.*
import java.util.jar.Manifest


class Activity3 : AppCompatActivity() {
    private val REQUEST_CAMERA = 1002;
    private var photo: Uri?=null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_3)
        //Mensaje corto que aparece cuando para avisar que se entra en la activity3
        Toast.makeText(this,"Entrando en Activity 3",Toast.LENGTH_SHORT).show();
            abreCamera_Click();
        //Botón, que mediante Intent, te lanza a la MainActivity
        btnBack3.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent);

        }
    }//onCreate
    //Si se acepta los permisos de la cámara
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            REQUEST_CAMERA ->{
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    abreCamera();
                else
                    Toast.makeText(this,"No puedes abrir la camara",Toast.LENGTH_SHORT).show();
            }
        }
    }
    //Método que al pulsación del botón de la camara
    private fun abreCamera_Click(){
        btnCamera.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (checkSelfPermission(android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED) {
                    val permisoCamera = arrayOf(android.Manifest.permission.CAMERA)
                    requestPermissions(permisoCamera, REQUEST_CAMERA)
                }else{
                    abreCamera()
                }
            } else {
                abreCamera()
            }
        }
    }
    //Método que abre la cámara del telefono
    private fun abreCamera(){
        val value = ContentValues()
        value.put(MediaStore.Images.Media.TITLE,"Image");
        photo = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,value);
        val camera = Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        camera.putExtra(MediaStore.EXTRA_OUTPUT,photo);
        startActivityForResult(camera, REQUEST_CAMERA);
    }
    //Método que avisa si se ha efectuado la foto por Toast
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK && requestCode == REQUEST_CAMERA){
            Toast.makeText(this,"Foto realizada",Toast.LENGTH_SHORT).show();
        }
    }
}

