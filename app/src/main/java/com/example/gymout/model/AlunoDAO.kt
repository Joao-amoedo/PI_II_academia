package com.example.gymout.model

import android.app.Activity
import android.widget.Toast
import com.example.gymout.classes.Aluno
import com.google.firebase.ktx.Firebase

class AlunoDAO {


    companion object {
        fun InsereAluno(aluno: Aluno){
            var ref = FirebaseFactory.getReference("usuario")
            ref.child(aluno.uid).setValue(aluno)


        }
    }

}


