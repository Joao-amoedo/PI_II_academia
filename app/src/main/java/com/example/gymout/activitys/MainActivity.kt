package com.example.gymout.activitys

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.gymout.R
import com.example.gymout.classes.Aluno
import com.example.gymout.classes.Usuario
import com.example.gymout.model.AlunoDAO
import com.example.gymout.model.FirebaseFactory
import com.example.gymout.model.UsuarioEstatico


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.idButtonMainActivity)

        btn.setOnClickListener {

            val usuario = UsuarioEstatico.getUsuario();


            Toast.makeText(this, usuario.nome, Toast.LENGTH_LONG).show()
        }

    }
}