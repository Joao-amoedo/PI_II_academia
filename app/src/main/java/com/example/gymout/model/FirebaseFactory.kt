package com.example.gymout.model

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class FirebaseFactory {

    companion object {
        fun getDatabase(): FirebaseDatabase{
            return FirebaseDatabase.getInstance()
        }

        fun getReference(reference:String): DatabaseReference{
            var database = FirebaseFactory.getDatabase()
            return database.getReference(reference)
        }
    }


}