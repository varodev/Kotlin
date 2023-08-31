package com.example.pac_dllo

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_2_1.*
import kotlinx.android.synthetic.main.activity_2_1.eTEdad
import kotlinx.android.synthetic.main.activity_2_1.eTID
import kotlinx.android.synthetic.main.activity_2_1.eTNombre


class Activity21 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2_1)
        //Botón de dar de Alta
        btnCreate.setOnClickListener {
            val admin = AdminSQLiteOpenHelper(this,"administracion", null, 1)
            val bd = admin.writableDatabase
            val registro = ContentValues()
            registro.put("id", eTID.getText().toString())
            registro.put("nombre", eTNombre.getText().toString())
            registro.put("edad", eTEdad.getText().toString())
            bd.insert("perros", null, registro)
            bd.close()
            eTNombre.setText("")
            eTID.setText("")
            eTEdad.setText("")
            Toast.makeText(this, "Se cargaron los datos del perro", Toast.LENGTH_SHORT).show()
        }
        //Botón de Actualizar
        btnUpdate.setOnClickListener {
            val admin = AdminSQLiteOpenHelper(this,"administracion", null, 1)
            val bd = admin.writableDatabase
            val registro = ContentValues()
            registro.put("nombre", eTNombre.getText().toString())
            registro.put("edad", eTEdad.getText().toString())
            val cant = bd.update("perros", registro, "id=${eTID.text.toString()}", null)
            bd.close()
            if (cant == 1)
                Toast.makeText(this, "se modificaron los datos del perro", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "no existe un perro con el id ingresado", Toast.LENGTH_SHORT).show()
        }
        //Botón de buscar por ID
        btnBusquedaID.setOnClickListener {
            val admin = Activity21.AdminSQLiteOpenHelper(this, "administracion", null, 1)
            val bd = admin.writableDatabase
            val fila = bd.rawQuery("select nombre,edad from perros where id=${eTID.text.toString()}", null)
            if (fila.moveToFirst()) {
                eTNombre.setText(fila.getString(0))
                eTEdad.setText(fila.getString(1))
            } else
                Toast.makeText(this, "No existe un perro con dicho id",  Toast.LENGTH_SHORT).show()
            bd.close()
        }
        //Botón de buscar por nombre
        btnBusquedaNombre.setOnClickListener {
            val admin = Activity21.AdminSQLiteOpenHelper(this, "administracion", null, 1)
            val bd = admin.writableDatabase
            val fila = bd.rawQuery("select id,edad from perros where nombre='${eTNombre.text.toString()}'", null)
            if (fila.moveToFirst()) {
                eTID.setText(fila.getString(0))
                eTEdad.setText(fila.getString(1))
            } else
                Toast.makeText(this, "No existe un perro con dicho nombre", Toast.LENGTH_SHORT).show()
            bd.close()
        }
        //Botón de eliminar por ID
        btnErase.setOnClickListener(){
            val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
            val bd = admin.writableDatabase
            val cant = bd.delete("perros", "id=${eTID.text.toString()}", null)
            bd.close()
            eTID.setText("")
            eTNombre.setText("")
            eTEdad.setText("")
            if (cant == 1)
                Toast.makeText(this, "Se borró el perro con dicho código", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "No existe un perro con dicho código", Toast.LENGTH_SHORT).show()
        }

        //Botón, que mediante Intent, te lanza a la Activity2
        btnVolver.setOnClickListener {
            val intent = Intent(this, Activity2::class.java)
            startActivity(intent);
        }
    }
    //clase SQLite donde se crea la tabla de la BBDD
    class AdminSQLiteOpenHelper(context: Context, name: String, factory: SQLiteDatabase.CursorFactory?, version: Int) : SQLiteOpenHelper(context, name, factory, version) {
        override fun onCreate(db: SQLiteDatabase) {
            db.execSQL("create table perros(id int primary key, nombre text, edad int)")
        }

        override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

        }
    }
}