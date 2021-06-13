package com.example.gymout.classes

class Professor(

        uid: String,
        nome: String,
        email: String,
        nota: MutableList<Int>? = null,
        idade:Int? = null,
        var endereco:String? = null,
        var certificadoEducacao:String? = null,
        var CEP:String? = null,
        var bio:String? = null
) : Usuario(uid, nome, email,  nota, idade, true)