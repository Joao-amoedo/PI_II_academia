package com.example.gymout.classes

class Professor(

        uid: String,
        nome: String,
        email: String,
        sexo: String? = null,
        nota: MutableList<Int>? = null,
        dataNascimento:Int? = null,
        var certificadoEducacao:String? = null,
        var CEP:String? = null
) : Usuario(uid, nome, email, sexo, nota, dataNascimento, true)