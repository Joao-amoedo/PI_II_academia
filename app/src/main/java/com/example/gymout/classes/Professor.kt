package com.example.gymout.classes

class Professor(

        uid: String,
        nome: String,
        email: String,
        nota: MutableList<Int>? = null,
        dataNascimento:Int? = null,
        var certificadoEducacao:String? = null,
        var CEP:String? = null
) : Usuario(uid, nome, email,  nota, dataNascimento, true)