package com.example.gymout

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.gymout.classes.Aluno
import com.example.gymout.model.FirebaseFactory
import com.google.firebase.database.FirebaseDatabase


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.idButtonMainActivity)

        btn.setOnClickListener {

            var aluno = Aluno(nome = "João", email = "jp.advc@gmail.com")
            var myRef = FirebaseFactory.getReference("aluno")
            val alunoId = myRef.push().key

            myRef.child(alunoId.toString()).setValue(aluno)

        }

        val btn1 = findViewById<Button>(R.id.idChat)

        btn1.setOnClickListener { val intent = Intent( this, Chatbot::class.java)
        startActivity(intent)

        }



    }
}


