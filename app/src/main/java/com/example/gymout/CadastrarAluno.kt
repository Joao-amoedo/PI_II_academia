package com.example.gymout

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth

class CadastrarAluno : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    private lateinit var nomeEt: EditText
    private lateinit var emailEt: EditText
    private lateinit var passwordEt: EditText

    private lateinit var cadastrar_alunoBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastrar_aluno)

        auth = FirebaseAuth.getInstance()

        emailEt = findViewById(R.id.cadastrar_aluno_email)
        passwordEt = findViewById(R.id.cadastrar_aluno_senha)
        cadastrar_alunoBtn = findViewById(R.id.cadastrar_aluno_button)

        cadastrar_alunoBtn.setOnClickListener {
            var email: String = emailEt.text.toString()
            var password: String = passwordEt.text.toString()

            if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                Toast.makeText(
                    this,
                    "Por favor, preencha os campos de E-mail e Senha.",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, OnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "Cadastrado com sucesso!", Toast.LENGTH_LONG)
                                .show()
                            val intent = Intent(this, Login::class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            Toast.makeText(this, "Falha no cadastro.", Toast.LENGTH_LONG).show()
                        }
                    })
            }
        }
    }
}