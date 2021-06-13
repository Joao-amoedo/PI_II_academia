package com.example.gymout.activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.gymout.R
import com.example.gymout.classes.Aluno
import com.example.gymout.classes.Professor
import com.example.gymout.model.AlunoDAO
import com.example.gymout.model.FirebaseFactory
import com.example.gymout.model.UsuarioEstatico
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class ActivityEditarPerfilProfessor : AppCompatActivity() {

    private lateinit var nomeProfessorEdit: EditText
    private lateinit var enderecoProfessorEdit: EditText
    private lateinit var bioProfessorEdit: EditText
    private lateinit var qtdAlunosProfessorEdit: EditText
    private lateinit var crefProfessorEdit: EditText
    private lateinit var idadeProfessorEdit: EditText


    private lateinit var aplicarEditProfessor: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_perfil_professor)

        nomeProfessorEdit = findViewById(R.id.idTextViewProfessorEditNome)
        enderecoProfessorEdit = findViewById(R.id.idTextViewProfessorEditEndereco)
        bioProfessorEdit = findViewById(R.id.idTextViewProfessorEditActivityBio)
        // Lista com os uIDs dos alunos |||FAZER
        //qtdAlunosProfessorEdit = findViewById(R.id.idTextViewProfessorEditQuantidadeAlunosAssociados)
        crefProfessorEdit = findViewById(R.id.IdTextViewProfessorEditCREF)
        idadeProfessorEdit = findViewById(R.id.idTextViewProfessorEditIdade)



        aplicarEditProfessor = findViewById(R.id.EditarProfessorPerfilBtn)

        val professor = UsuarioEstatico.getUsuario() as Professor



        aplicarEditProfessor.setOnClickListener {
            professor.nome = nomeProfessorEdit.toString()
            professor.idade = idadeProfessorEdit.toString().toInt()
            //professor.endereco = enderecoProfessorEdit.toString()
            //professor.certificadoEducacao = crefProfessorEdit.toString()
            //professor.bio = bioProfessorEdit.toString()
            //AlunoDAO.InsereAluno(professor as Aluno)
            val intent = Intent(this, ActivityPerfilProfessor::class.java)
            startActivity(intent)
            finish()

        }


    }
}