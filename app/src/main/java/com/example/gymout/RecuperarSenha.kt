package com.example.gymout

import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth

class RecuperarSenha : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    private lateinit var emailEt: EditText

    private lateinit var recuperarSenhaBtn: Button
    private lateinit var voltarBtn: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recuperar_senha)

        auth = FirebaseAuth.getInstance()

        emailEt = findViewById(R.id.recuperar_senha_email_Et)

        recuperarSenhaBtn = findViewById(R.id.recuperar_senha_button)
        voltarBtn = findViewById(R.id.recuperar_senha_voltar_button)

        voltarBtn.setOnClickListener {
            finish()
        }

        recuperarSenhaBtn.setOnClickListener {
            var email: String = emailEt.text.toString()

            if (TextUtils.isEmpty(email)) {
                Toast.makeText(this, "Por favor digite seu E-mail.", Toast.LENGTH_LONG).show()
            } else {
                auth.sendPasswordResetEmail(email)
                    .addOnCompleteListener(this, OnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(
                                this,
                                "Link para a troca de senha enviado para o seu E-mail.",
                                Toast.LENGTH_LONG
                            )
                                .show()
                        } else {
                            Toast.makeText(this, "Falha ao enviar E-mail.", Toast.LENGTH_LONG)
                                .show()
                        }
                    })
            }
        }
    }
}