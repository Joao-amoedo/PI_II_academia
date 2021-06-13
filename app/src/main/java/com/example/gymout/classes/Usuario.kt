package com.example.gymout.classes

open class Usuario(

    var uid:String,
    var nome: String,
    var email: String,
    var nota: MutableList<Int>? = null,
    var dataNascimento: Int? = null,
    var isProfessor: Boolean



)