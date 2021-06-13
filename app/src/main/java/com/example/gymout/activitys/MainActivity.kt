package com.example.gymout.activitys

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.gymout.R
import com.example.gymout.classes.Aluno
import com.example.gymout.model.FirebaseFactory


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.idButtonMainActivity)
        val btn2 = findViewById<Button>(R.id.perfilProfessor)


        btn.setOnClickListener {

            var aluno = Aluno(nome = "João", email = "jp.advc@gmail.com")
            var myRef = FirebaseFactory.getReference("aluno")
            val alunoId = myRef.push().key

            myRef.child(alunoId.toString()).setValue(aluno)

        }

        btn2.setOnClickListener {
            val intent = Intent(this, ActivityPerfilProfessor::class.java)
            startActivity(intent)
            finish()
        }
    }
}