package com.example.gymout.activitys

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.gymout.R
import com.example.gymout.classes.Aluno
import com.example.gymout.model.AlunoDAO
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth

class ActivityCadastrarAluno : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    private lateinit var nomeEt: EditText
    private lateinit var emailEt: EditText
    private lateinit var passwordEt: EditText

    private lateinit var cadastrar_alunoBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastrar_aluno)

        auth = FirebaseAuth.getInstance()

        emailEt = findViewById(R.id.idEmailCadastrarAluno)
        passwordEt = findViewById(R.id.idSenhaCadastrarAluno)
        nomeEt = findViewById(R.id.idNomeCadastrarAluno)

        cadastrar_alunoBtn = findViewById(R.id.cadastrar_aluno_button)

        cadastrar_alunoBtn.setOnClickListener {
            var email: String = emailEt.text.toString()
            var password: String = passwordEt.text.toString()
            var nome: String = nomeEt.text.toString()

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

                            var uid = auth.currentUser.uid
                            salvaAlunoBanco(uid, nome, email)



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

    fun salvaAlunoBanco(uid:String, nome: String, email: String){
        var aluno = Aluno(uid=uid, nome=nome, email=email)
        AlunoDAO.InsereAluno(aluno)



    }

}