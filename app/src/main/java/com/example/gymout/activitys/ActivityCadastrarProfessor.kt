package com.example.gymout.activitys

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.gymout.R
import com.example.gymout.classes.Professor
import com.example.gymout.model.ProfessorDAO
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth

class ActivityCadastrarProfessor : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    private lateinit var nomeEt: EditText
    private lateinit var emailEt: EditText
    private lateinit var passwordEt: EditText

    private lateinit var cadastrarProfessorBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastrar_professor)

        auth = FirebaseAuth.getInstance()

        nomeEt = findViewById(R.id.idNomeCadastrarProfessor)
        emailEt = findViewById(R.id.idEmailCadastrarProfessor)
        passwordEt = findViewById(R.id.idSenhaCadastrarProfessor)

        cadastrarProfessorBtn = findViewById(R.id.cadastrar_professor_button)

        cadastrarProfessorBtn.setOnClickListener {
            val email: String = emailEt.text.toString()
            val password: String = passwordEt.text.toString()
            val nome:String = nomeEt.text.toString()

            if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                Toast.makeText(
                    this,
                    "Por favor, preencha os campos de E-mail e Senha",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, OnCompleteListener { task ->
                        if (task.isSuccessful) {
                            salvaProfessorBanco(nome, email)
                            Toast.makeText(this, "Cadastrado com sucesso!", Toast.LENGTH_LONG)
                                .show()
                            val intent = Intent(this, ActivityLogin::class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            Toast.makeText(this, "Falha no cadastro.", Toast.LENGTH_LONG).show()
                        }
                    })
            }
        }




    }

    private fun salvaProfessorBanco(nome:String, email:String){

        val professor = Professor(nome=nome, email=email)
        ProfessorDAO.InsereProfessor(professor)


    }
}