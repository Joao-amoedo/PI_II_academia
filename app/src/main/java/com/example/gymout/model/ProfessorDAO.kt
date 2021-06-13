package com.example.gymout.model

import android.app.Activity
import android.widget.Toast
import com.example.gymout.classes.Aluno
import com.example.gymout.classes.Professor

class ProfessorDAO {



    companion object {
        fun InsereProfessor(professor: Professor){
            var ref = FirebaseFactory.getReference("usuario")
            ref.child(professor.uid).setValue(professor)
        }
    }

}