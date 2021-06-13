package com.example.gymout.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.gymout.R
import com.example.gymout.classes.Professor
import com.example.gymout.model.FirebaseFactory
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class ActivityEditarPerfilProfessor : AppCompatActivity() {

    private lateinit var nomeProfessorEdit: EditText
    private lateinit var enderecoProfessorEdit: EditText
    private lateinit var bioProfessorEdit: EditText
    private lateinit var qtdAlunosProfessorEdit: EditText
    private lateinit var crefProfessorEdit: EditText
    private lateinit var dataNascimentoProfessorEdit: EditText
    private lateinit var aplicarEditProfessor: Button
    private lateinit var dbReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_perfil_professor)

        nomeProfessorEdit = findViewById(R.id.idTextViewProfessorEditNome)
        enderecoProfessorEdit = findViewById(R.id.idTextViewProfessorEditEndereco)
        bioProfessorEdit = findViewById(R.id.idTextViewProfessorEditActivityBio)
        // Lista com os uIDs dos alunos |||FAZER
        //qtdAlunosProfessorEdit = findViewById(R.id.idTextViewProfessorEditQuantidadeAlunosAssociados)
        crefProfessorEdit = findViewById(R.id.IdTextViewProfessorEditCREF)
        // IDADE
        //ProfessorEdit = findViewById(R.id.idTextViewProfessorEditDataDeNascimento)
        aplicarEditProfessor = findViewById(R.id.EditarProfessorPerfilBtn)




        val database = FirebaseFactory.getDatabase()
        val currentUser = FirebaseAuth.getInstance().currentUser.uid
        val emailProfessor = FirebaseAuth.getInstance().currentUser.email
        val sexo:String = "Masculino"
        dbReference = FirebaseDatabase.getInstance().reference.child("professor")

        aplicarEditProfessor.setOnClickListener {
            //val professor = Professor(nomeProfessorEdit,emailProfessor,sexo,)

            dbReference.child("professor").child(currentUser).child("name").setValue(nomeProfessorEdit)
            //dbReference.child("professor").child(currentUser).child("endereco").setValue(enderecoProfessorEdit)
            //dbReference.child("professor").child(currentUser).child("bio").setValue(bioProfessorEdit)
            //dbReference.child("professor").child(currentUser).child("qntAlunos").setValue(qtdAlunosProfessorEdit)
            //dbReference.child("professor").child(currentUser).child("certificadoEducacao").setValue(crefProfessorEdit)
            //dbReference.child("professor").child(currentUser).child("dataNascimento").setValue(dataNascimentoProfessorEdit)

        }








    }
}