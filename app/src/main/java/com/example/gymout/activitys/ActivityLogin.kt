package com.example.gymout.activitys

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.gymout.R
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth

class ActivityLogin : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    private lateinit var login_emailEt: EditText
    private lateinit var login_passwordEt: EditText

    private lateinit var login_cadastrarAlunoBtn: Button
    private lateinit var login_cadastrarProfessorBtn: Button

    private lateinit var loginBtn: Button

    private lateinit var recuperarSenhaBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)



        login_emailEt = findViewById(R.id.login_email)
        login_passwordEt = findViewById(R.id.login_password)
        login_cadastrarAlunoBtn = findViewById(R.id.login_button_cadastrar_aluno)
        login_cadastrarProfessorBtn = findViewById(R.id.login_button_cadastrar_professor)
        loginBtn = findViewById(R.id.login_button_entrar)
        recuperarSenhaBtn = findViewById(R.id.login_button_recuperarSenha)

        auth = FirebaseAuth.getInstance()

        loginBtn.setOnClickListener {
            var email: String = login_emailEt.text.toString()
            var password: String = login_passwordEt.text.toString()

            if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                Toast.makeText(
                    this@ActivityLogin,
                    "Por favor, preencha todos os campos.",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, OnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "Logado com sucesso!", Toast.LENGTH_LONG).show()
                            val intent = Intent(this, MainActivity::class.java)

                            //pegar dados
                            /*
                            val database = FirebaseFactory.getDatabase()
                            val currentUser = FirebaseAuth.getInstance().currentUser.uid
                            val database = FirebaseFactory.getDatabase()
                            database.getReference("professor").child(currentUser).get().addOnSuccessListener {
                                val x = it.value

                            }*/

                            startActivity(intent)
                            finish()
                        } else {
                            Toast.makeText(this, "Falha no Login", Toast.LENGTH_LONG).show()
                        }
                    })
            }
        }







        login_cadastrarAlunoBtn.setOnClickListener {
            val intent = Intent(this, ActivityCadastrarAluno::class.java)
            startActivity(intent)
            finish()
        }

        login_cadastrarProfessorBtn.setOnClickListener {
            val intent = Intent(this, ActivityCadastrarProfessor::class.java)
            startActivity(intent)
            finish()
        }

        recuperarSenhaBtn.setOnClickListener {
            val intent = Intent(this, ActivityRecuperarSenha::class.java)
            startActivity(intent)
        }



    }
}