package com.example.gymout.activitys
import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.example.gymout.R
import com.example.gymout.model.FirebaseFactory


class ActivityPerfilProfessor : AppCompatActivity() {

    private lateinit var emailProfessor: TextView
    private lateinit var nomeProfessor: TextView
    private lateinit var thisactivity:Activity
    lateinit var auth: FirebaseAuth
    var dbRef : DatabaseReference? = null
    var database: FirebaseDatabase? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil_professor)

        thisactivity = this
        emailProfessor = findViewById(R.id.idTextViewPaginaUsuarioActivityEmail)
        nomeProfessor = findViewById(R.id.idTextViewPaginaUsuarioActivityNome)

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        //dbRef = database!!.reference.

        loadprofile()

    }

    private fun loadprofile() {
        val user = auth.currentUser
        val userRef =  dbRef?.child(user?.uid!!)
        val database = FirebaseFactory.getDatabase()

        emailProfessor.text = user?.email


        userRef?.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                nomeProfessor.text = snapshot.child("nome").value.toString()
                emailProfessor.text = snapshot.child("email").value.toString()

                database.getReference("professor").get().addOnSuccessListener {
                    val x = it.value
                    Toast.makeText(thisactivity, x.toString(), Toast.LENGTH_LONG).show()

                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
}